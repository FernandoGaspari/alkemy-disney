package com.alkemy.disney.repositories;

import com.alkemy.disney.models.CharactersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends JpaRepository<CharactersModel, Long> {

}
