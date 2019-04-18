package com.barros.desafiostone.business;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.barros.desafiostone.model.Employee;
import com.barros.desafiostone.rules.SalaryWeight;
import com.barros.desafiostone.rules.WeightAreaActuation;
import com.barros.desafiostone.rules.WeightTimeAdmission;

public class ProfitsAndDividends {

	private static final String MONTHS = "12";

	private String minimalSalary;

	private Employee employee;

	@SuppressWarnings("unused")
	private ProfitsAndDividends() {
		super();
	}

	@Autowired
	public ProfitsAndDividends(Employee employee, String minimalSalary) {
		super();
		this.employee = employee;
		this.minimalSalary = minimalSalary;
	}

	public BigDecimal calculate() {
		WeightAreaActuation weightAreaActuation = new WeightAreaActuation(this.employee);
		SalaryWeight salaryWeight = new SalaryWeight(this.employee, new BigDecimal(minimalSalary));
		WeightTimeAdmission weightTimeAdmission = new WeightTimeAdmission(this.employee);

		BigDecimal articleOne = this.employee.getSalarioBruto()
				.multiply(new BigDecimal(weightTimeAdmission.getWeight()));
		BigDecimal articleTwo = this.employee.getSalarioBruto()
				.multiply(new BigDecimal(weightAreaActuation.getWeight()));
		BigDecimal articleThree = articleOne.add(articleTwo).divide(new BigDecimal(salaryWeight.getWeight()));

		return articleThree.multiply(new BigDecimal(MONTHS));
	}

}
