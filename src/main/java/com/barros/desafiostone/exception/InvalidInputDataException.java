package com.barros.desafiostone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Valor disponibilizado não encontrado.")
public class InvalidInputDataException extends Exception {

	private static final long serialVersionUID = 6691967849272359867L;

	public InvalidInputDataException(String message) {
		super(message);
	}
}
