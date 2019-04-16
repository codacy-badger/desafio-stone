package com.barros.desafiostone.rules;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:test.properties")
public class SalaryWeightTest extends WeightTest {

	@Value("${salario.minimo}")
	private String minimalSalary;

	@Test
	public void testWeightTrainee() {
		employee.setCargo("Estagiário");
		employee.setSalarioBruto(new BigDecimal("3696.20"));
		
		SalaryWeight salaryWeight = new SalaryWeight(employee, new BigDecimal(minimalSalary));

		assertThat(salaryWeight.getWeight()).isNotNull();
		assertThat(salaryWeight.getWeight()).isEqualTo(1);
	}

	@Test
	public void testWeightEquals5() {
		employee.setSalarioBruto(new BigDecimal("12696.20"));
		
		SalaryWeight salaryWeight = new SalaryWeight(employee, new BigDecimal(minimalSalary));

		assertThat(salaryWeight.getWeight()).isNotNull();
		assertThat(salaryWeight.getWeight()).isEqualTo(5);
	}
	
	@Test
	public void testWeightEquals3() {
		employee.setSalarioBruto(new BigDecimal("6969.20"));
		
		SalaryWeight salaryWeight = new SalaryWeight(employee, new BigDecimal(minimalSalary));

		assertThat(salaryWeight.getWeight()).isNotNull();
		assertThat(salaryWeight.getWeight()).isEqualTo(3);
	}
	
	@Test
	public void testWeightEquals2() {
		employee.setSalarioBruto(new BigDecimal("4696.20"));
		
		SalaryWeight salaryWeight = new SalaryWeight(employee, new BigDecimal(minimalSalary));

		assertThat(salaryWeight.getWeight()).isNotNull();
		assertThat(salaryWeight.getWeight()).isEqualTo(2);
	}
	
	@Test
	public void testWeightEquals1() {
		employee.setSalarioBruto(new BigDecimal("1269.20"));
		
		SalaryWeight salaryWeight = new SalaryWeight(employee, new BigDecimal(minimalSalary));

		assertThat(salaryWeight.getWeight()).isNotNull();
		assertThat(salaryWeight.getWeight()).isEqualTo(1);
	}

}
