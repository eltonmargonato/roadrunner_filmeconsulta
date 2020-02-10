package edu.roadrunner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.roadrunner.model.Categoria;

@Repository
public interface GeneroRepository extends JpaRepository<Categoria, Integer> {
	
}
