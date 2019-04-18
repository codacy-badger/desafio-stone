package com.barros.desafiostone.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.barros.desafiostone.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class ProfitsAndDividendsTest {

	private Employee employee;

	private ProfitsAndDividends profitsAndDividends;

	private String minimalSalary = "998";

	@Before
	public void init() {

		Employee employeeInstance = new Employee();
		employeeInstance.setMatricula("0009968");
		employeeInstance.setNome("Victor Wilson");
		employeeInstance.setArea("Diretoria");
		employeeInstance.setCargo("Diretor Financeiro");
		employeeInstance.setSalarioBruto(new BigDecimal("12696.20"));
		employeeInstance.setDataAdmissao(LocalDate.parse("2012-01-05"));

		this.employee = spy(employeeInstance);
		profitsAndDividends = mock(ProfitsAndDividends.class, CALLS_REAL_METHODS);
	}

	@Test
	public void testCalculateDirector() {
		ReflectionTestUtils.setField(profitsAndDividends, "employee", employee);
		ReflectionTestUtils.setField(profitsAndDividends, "minimalSalary", minimalSalary);

		BigDecimal calcResult = profitsAndDividends.calculate();

		assertThat(calcResult).isNotNull();
		assertThat(calcResult).isEqualTo(new BigDecimal("121883.52"));
	}

	@Test
	public void testCalculateTrainee() {
		this.employee.setArea("Financeiro");
		this.employee.setCargo("Estagiario");
		this.employee.setSalarioBruto(new BigDecimal("1426.13"));
		this.employee.setDataAdmissao(LocalDate.parse("2016-09-20"));
		
		ReflectionTestUtils.setField(profitsAndDividends, "employee", employee);
		ReflectionTestUtils.setField(profitsAndDividends, "minimalSalary", minimalSalary);

		BigDecimal calcResult = profitsAndDividends.calculate();

		assertThat(calcResult).isNotNull();
		assertThat(calcResult).isEqualTo(new BigDecimal("68454.24"));
	}

}
