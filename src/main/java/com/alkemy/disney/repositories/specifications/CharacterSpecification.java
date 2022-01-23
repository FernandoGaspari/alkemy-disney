package com.alkemy.disney.repositories.specifications;

import com.alkemy.disney.dto.CharactersFilterDTO;
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

@Component
public class CharacterSpecification {
    public Specification<CharactersModel> getByFilters(CharactersFilterDTO filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filters.getName())) {
                System.out.println("hola name!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + filters.getName().toLowerCase() + "%"));
            }
            if (filters.getAge() != null) {
                System.out.println("hola age!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                predicates.add(criteriaBuilder.equal(root.get("age"), filters.getAge()));
            }
            if (!CollectionUtils.isEmpty(filters.getMovies())){
                System.out.println("hola movies!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                Join<MoviesModel, CharactersModel> join= root.join("characters", JoinType.INNER);
                Expression<String>idMovie=join.get("id");

                predicates.add(idMovie.in(filters.getMovies()));
            }
            query.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
