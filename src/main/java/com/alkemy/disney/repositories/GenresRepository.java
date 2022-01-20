package com.alkemy.disney.repositories;

import com.alkemy.disney.models.GenresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<GenresModel, Long> {
}
