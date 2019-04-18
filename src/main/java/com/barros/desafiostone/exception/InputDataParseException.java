package com.barros.desafiostone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Dado inválido.")
public class InputDataParseException extends JsonProcessingException {

	private static final long serialVersionUID = -8966065309706965273L;

	public InputDataParseException(String message) {
		super(message);
	}
}
