package com.barros.desafiostone.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:test.properties")
public class WeightAreaActuationTest extends WeightTest {
	
	@Test
	public void testWeightEquals5() {
		employee.setArea("Relacionamento com o Cliente");
		
		WeightAreaActuation weightAreaActuation = new WeightAreaActuation(employee);

		assertThat(weightAreaActuation.getWeight()).isNotNull();
		assertThat(weightAreaActuation.getWeight()).isEqualTo(5);
	}
	
	@Test
	public void testWeightEquals3() {
		employee.setArea("Serviços Gerais");
		
		WeightAreaActuation weightAreaActuation = new WeightAreaActuation(employee);

		assertThat(weightAreaActuation.getWeight()).isNotNull();
		assertThat(weightAreaActuation.getWeight()).isEqualTo(3);
	}
	
	@Test
	public void testWeightEquals2() {
		WeightAreaActuation weightAreaActuation = new WeightAreaActuation(employee);
		
		employee.setArea("Contabilidade");
		assertThat(weightAreaActuation.getWeight()).isNotNull();
		assertThat(weightAreaActuation.getWeight()).isEqualTo(2);
		
		employee.setArea("Financeiro");
		assertThat(weightAreaActuation.getWeight()).isNotNull();
		assertThat(weightAreaActuation.getWeight()).isEqualTo(2);
		
		employee.setArea("Tecnologia");
		assertThat(weightAreaActuation.getWeight()).isNotNull();
		assertThat(weightAreaActuation.getWeight()).isEqualTo(2);
	}
	
	@Test
	public void testWeightEquals1() {
		employee.setArea("Diretoria");
		
		WeightAreaActuation weightAreaActuation = new WeightAreaActuation(employee);

		assertThat(weightAreaActuation.getWeight()).isNotNull();
		assertThat(weightAreaActuation.getWeight()).isEqualTo(1);
	}


}
