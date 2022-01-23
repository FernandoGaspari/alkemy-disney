package com.alkemy.disney.repositories;

import com.alkemy.disney.models.CharactersModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharactersRepository extends JpaRepository<CharactersModel, Long> {
    List<CharactersModel> findAll(Specification<CharactersModel>specification);
}
