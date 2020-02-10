package edu.roadrunner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Filme não encontrado")
public class FilmeNotFoundException extends Exception  {

	private static final long serialVersionUID = 7938075346139164978L;

}


