package com.barros.desafiostone.rules;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;

import com.barros.desafiostone.model.Employee;

public abstract class WeightTest {

	protected Employee employee;

	@Before
	public void init() {
		employee = new Employee();
		employee.setMatricula("0009968");
		employee.setNome("Victor Wilson");
		employee.setArea("Diretoria");
		employee.setCargo("Diretor Financeiro");
		employee.setSalarioBruto(new BigDecimal("12696.20"));
		employee.setDataAdmissao(LocalDate.parse("2012-01-05"));
	}

}