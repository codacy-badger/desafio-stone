package com.barros.desafiostone.rest.service;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.barros.desafiostone.business.ProfitsAndDividendsBean;
import com.barros.desafiostone.exception.InsufficientAvailableExcepetion;
import com.barros.desafiostone.exception.InvalidInputDataException;
import com.barros.desafiostone.model.Participations;

@RestController
@RequestMapping("/rest/profits-dividends")
public class ProfitsAndDividendsService {

	private ProfitsAndDividendsBean profitsAndDividendsBean;
	
	public ProfitsAndDividendsService(ProfitsAndDividendsBean profitsAndDividendsBean) {
		this.profitsAndDividendsBean = profitsAndDividendsBean;
	}

	@GetMapping("/distribute")
	public @ResponseBody ResponseEntity<Participations> distribute(
			@Valid @RequestParam("available") BigDecimal available) throws InsufficientAvailableExcepetion, InvalidInputDataException {

		if(Objects.isNull(available)) {
			throw new InvalidInputDataException("Valor disponibilizado inválido.");
		}else {
			return ResponseEntity.ok(profitsAndDividendsBean.process(available));
		}

	}

}
