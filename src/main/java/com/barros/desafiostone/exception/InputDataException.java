package com.barros.desafiostone.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class InputDataException extends JsonProcessingException {

	private static final long serialVersionUID = -8966065309706965273L;

	public InputDataException(String message) {
		super(message);
	}
}
