package com.barros.desafiostone.rules;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:test.properties")
public class WeightTimeAdmissionTest extends WeightTest {
	
	@Test
	public void testWeightEquals5() {
		employee.setDataAdmissao(LocalDate.parse("2008-05-01"));
		
		WeightTimeAdmission weightTimeAdmission = new WeightTimeAdmission(employee);

		assertThat(weightTimeAdmission.getWeight()).isNotNull();
		assertThat(weightTimeAdmission.getWeight()).isEqualTo(5);
	}
	
	@Test
	public void testWeightEquals3() {
		employee.setDataAdmissao(LocalDate.parse("2013-05-01"));
		
		WeightTimeAdmission weightTimeAdmission = new WeightTimeAdmission(employee);

		assertThat(weightTimeAdmission.getWeight()).isNotNull();
		assertThat(weightTimeAdmission.getWeight()).isEqualTo(3);
	}
	
	@Test
	public void testWeightEquals2() {
		employee.setDataAdmissao(LocalDate.parse("2017-05-01"));
		
		WeightTimeAdmission weightTimeAdmission = new WeightTimeAdmission(employee);
		
		assertThat(weightTimeAdmission.getWeight()).isNotNull();
		assertThat(weightTimeAdmission.getWeight()).isEqualTo(2);
	}
	
	@Test
	public void testWeightEquals1() {
		employee.setDataAdmissao(LocalDate.parse("2018-05-01"));
		
		WeightTimeAdmission weightTimeAdmission = new WeightTimeAdmission(employee);

		assertThat(weightTimeAdmission.getWeight()).isNotNull();
		assertThat(weightTimeAdmission.getWeight()).isEqualTo(1);
	}

}
