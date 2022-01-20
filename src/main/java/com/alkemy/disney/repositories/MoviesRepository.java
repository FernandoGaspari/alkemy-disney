package com.alkemy.disney.repositories;

import com.alkemy.disney.models.MoviesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesModel, Long> {

}
