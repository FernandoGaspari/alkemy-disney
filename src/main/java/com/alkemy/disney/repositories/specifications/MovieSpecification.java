package com.alkemy.disney.repositories.specifications;

import com.alkemy.disney.dto.MoviesFilterDTO;
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

@Component
public class MovieSpecification {
        public Specification<MoviesModel> getByFilters(MoviesFilterDTO filters) {
            return (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasLength(filters.getTitle())) {
                    predicates.add(criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("title")),
                            "%" + filters.getTitle().toLowerCase() + "%"));
                }

                if (!CollectionUtils.isEmpty(filters.getGenres())){
                    Join<GenresModel, MoviesModel> join= root.join("genres", JoinType.INNER);
                    Expression<String> idGenre=join.get("id");

                    predicates.add(idGenre.in(filters.getGenres()));
                }
                query.distinct(true);

                String orderByCreationDate = "creationDate";
                query.orderBy(filters.isASC()?
                        criteriaBuilder.asc(root.get(orderByCreationDate)) :
                        criteriaBuilder.desc(root.get(orderByCreationDate))
                        );

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
        }
    }

