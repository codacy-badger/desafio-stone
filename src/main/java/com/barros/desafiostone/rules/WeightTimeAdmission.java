package com.barros.desafiostone.rules;

import java.time.Duration;
import java.time.LocalDate;

import com.barros.desafiostone.model.Employee;

public class WeightTimeAdmission implements Weight {

	private static final int YEAR = 365;
	private Employee employee;

	@SuppressWarnings("unused")
	private WeightTimeAdmission() {
		super();
	}

	public WeightTimeAdmission(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Integer getWeight() {
		Integer weight = null;
		Long contractedDays = this.calculateHomeTime(this.employee.getDataAdmissao());
		
		double years = ((double)contractedDays)/((double)YEAR);

		if (years > 8) {
			weight = 5;
		} else if (years > 3 && years < 8) {
			weight = 3;
		} else if (years > 1 && years < 3) {
			weight = 2;
		} else {
			weight = 1;
		}

		return weight;
	}

	private Long calculateHomeTime(LocalDate employeeAdmission) {
		LocalDate today = LocalDate.now();

		return Duration.between(employeeAdmission.atStartOfDay(), today.atStartOfDay()).toDays();
	}

}
