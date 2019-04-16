package com.barros.desafiostone.rules;

import java.math.BigDecimal;

import com.barros.desafiostone.model.Employee;

public class SalaryWeight implements Weight {

	private Employee employee;

	private BigDecimal minimumSalary;

	@SuppressWarnings("unused")
	private SalaryWeight() {
		super();
	}

	public SalaryWeight(Employee employee, BigDecimal minimumSalary) {
		super();
		this.employee = employee;
		this.minimumSalary = minimumSalary;
	}

	@Override
	public Integer getWeight() {
		Integer weight = null;
		Integer numberOfSalaries = this.calculateMinimumSalaries(this.employee.getSalarioBruto());

		if (this.employee.getCargo().equals("Estagiário")) {
			weight = 1;
		} else {
			if (numberOfSalaries > 8) {
				weight = 5;
			} else if (numberOfSalaries > 5 && numberOfSalaries < 8) {
				weight = 3;
			} else if (numberOfSalaries > 3 && numberOfSalaries < 5) {
				weight = 2;
			} else {
				weight = 1;
			}
		}

		return weight;
	}

	private Integer calculateMinimumSalaries(BigDecimal employeeSalaray) {
		return employeeSalaray.divide(this.minimumSalary, BigDecimal.ROUND_HALF_EVEN).abs().intValue();
	}

}
