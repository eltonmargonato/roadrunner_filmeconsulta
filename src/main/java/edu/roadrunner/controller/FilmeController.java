package edu.roadrunner.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.roadrunner.bean.Titulo;
import edu.roadrunner.exception.FilmeNotFoundException;
import edu.roadrunner.model.Filme;
import edu.roadrunner.repository.FilmeRepository;

@RestController
public class FilmeController {

	@Autowired
	FilmeRepository filmeRepository;
	
		
	@GetMapping("/filme/busca/id/{idFilme}")
	public Filme busca(@PathVariable int idFilme) throws FilmeNotFoundException {
		Optional<Filme> opFilme = filmeRepository.findById(idFilme);
		if (!opFilme.isPresent())
			throw new FilmeNotFoundException();
		return opFilme.get();
	}
	
	@GetMapping("/filme/busca/palavrachave/{palavraChave}")
	public List<Titulo> buscaPalavraChave(@PathVariable String palavraChave) {
		List<Filme> resultado = filmeRepository.findByTituloContainingOrSinopseContaining(palavraChave, palavraChave);
		return getListaTitulos(resultado);
	}
	
	@GetMapping("/filme/busca/maisvistoscategoria")
	public List<Titulo> buscaMaisVistosCategoria() {
		List<Filme> resultado = filmeRepository.findMaisVistosCategoria();
		return getListaTitulos(resultado);
	}
	
	@GetMapping("/filme/busca/genero/{idgenero}")
	public List<Titulo> buscaPalavraChave(@PathVariable int idgenero) {
		List<Filme> resultado = filmeRepository.findBygenero_idGenero(idgenero);
		return getListaTitulos(resultado);
	}

	private List<Titulo> getListaTitulos(List<Filme> resultado) {
		List<Titulo> titulos = new ArrayList<Titulo>();
		for (Iterator<Filme> iterator = resultado.iterator(); iterator.hasNext();) {
			Filme filme = (Filme) iterator.next();
			Titulo umTitulo = new Titulo();
			umTitulo.setIdFilme(filme.getIdFilme());
			umTitulo.setTitulo(filme.getTitulo());
			umTitulo.setSinopse(filme.getSinopse());
			umTitulo.setCategoria(filme.getCategoria().getNomeCategoria());
			titulos.add(umTitulo);
		}
		return titulos;
	}

}
