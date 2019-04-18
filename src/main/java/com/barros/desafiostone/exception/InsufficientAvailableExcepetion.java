package com.barros.desafiostone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Valor insuficiente.")
public class InsufficientAvailableExcepetion extends Exception {

	private static final long serialVersionUID = 6691967849272359867L;

	public InsufficientAvailableExcepetion(String message) {
		super(message);
	}
}
