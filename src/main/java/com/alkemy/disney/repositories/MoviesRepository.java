package com.alkemy.disney.repositories;

import com.alkemy.disney.models.CharactersModel;
import com.alkemy.disney.models.MoviesModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesModel, Long> {
    List<MoviesModel> findAll(Specification<MoviesModel> specification);
}
