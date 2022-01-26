package com.alkemy.disney.repositories.specifications;

import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.models.MoviesModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CharacterSpecification {
    public Specification<CharactersModel> getByFilters(String name, Short age, Set<Long> movies) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(name)) {
                System.out.println("hola name!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"));
            }
            if (age != null) {
                System.out.println("hola age!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                predicates.add(criteriaBuilder.equal(root.get("age"), age));
            }
            System.out.println("hola");
            if (!CollectionUtils.isEmpty(movies)){
                System.out.println("hola movies!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                Join<MoviesModel, CharactersModel> join= root.join("movies", JoinType.INNER);
                Expression<String>idMovie=join.get("id");

                predicates.add(idMovie.in(movies));
            }
            query.distinct(true);
            System.out.println("hola3");
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
