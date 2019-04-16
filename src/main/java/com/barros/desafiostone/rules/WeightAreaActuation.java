package com.barros.desafiostone.rules;

import com.barros.desafiostone.model.Employee;

public class WeightAreaActuation implements Weight {
	
	private Employee employee;

	@SuppressWarnings("unused")
	private WeightAreaActuation() {
		super();
	}

	public WeightAreaActuation(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Integer getWeight() {

		Integer weight = null;

		switch (this.employee.getArea()) {
		case "Diretoria":
			weight = 1;
			break;
		case "Contabilidade":
			weight = 2;
			break;
		case "Financeiro":
			weight = 2;
			break;
		case "Tecnologia":
			weight = 2;
			break;
		case "Serviços Gerais":
			weight = 3;
			break;
		case "Relacionamento com o Cliente":
			weight = 5;
			break;

		default:
			break;
		}

		return weight;
	}

}
