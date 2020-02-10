package edu.roadrunner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.roadrunner.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	List<Filme> findByTituloContainingOrSinopseContaining(String palavraChave, String repetirPalavraChave);
	
	List<Filme> findBygenero_idGenero(int idgenero);
	
	@Query(value = "select idFilme, Titulo, Sinopse, Consumo, Categoria_idCategoria, Genero_idGenero from filme t1 where idFilme in (select idFilme from (select max(Consumo), Categoria_idCategoria, idFilme from filme t3 group by Categoria_idCategoria) t2)",
           nativeQuery = true)
    List<Filme> findMaisVistosCategoria();
}
