package com.alkemy.disney.repositories.specifications;

import com.alkemy.disney.models.GenresModel;
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
public class MovieSpecification {
        public Specification<MoviesModel> getByFilters(String title, String order, Set<Long> genre) {
            return (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasLength(title)) {
                    predicates.add(criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("title")),
                            "%" + title.toLowerCase() + "%"));
                }

                if (!CollectionUtils.isEmpty(genre)){
                    System.out.println("genres!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    Join<GenresModel, MoviesModel> join= root.join("genres", JoinType.INNER);
                    Expression<String> idGenre=join.get("id");

                    predicates.add(idGenre.in(genre));
                }
                query.distinct(true);

                //System.out.println(order);
                String orderByCreationDate = "creationDate";
                query.orderBy(
                        order.equalsIgnoreCase("asc") ?
                                criteriaBuilder.asc(root.get(orderByCreationDate)) :
                                criteriaBuilder.desc(root.get(orderByCreationDate)));

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
        }
    }

