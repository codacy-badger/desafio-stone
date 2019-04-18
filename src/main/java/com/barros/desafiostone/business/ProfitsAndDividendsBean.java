package com.barros.desafiostone.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.barros.desafiostone.exception.InsufficientAvailableExcepetion;
import com.barros.desafiostone.model.Employee;
import com.barros.desafiostone.model.EmployeeParticipation;
import com.barros.desafiostone.model.Participations;
import com.barros.desafiostone.repository.EmployeeRepository;

@Component
public class ProfitsAndDividendsBean implements Serializable {

	private static final long serialVersionUID = 4139194694199905183L;

	@Value("${salario.minimo}")
	private String minimalSalary;

	private EmployeeRepository employeeRepository;

	public ProfitsAndDividendsBean(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Participations process(BigDecimal disponibilizado) throws InsufficientAvailableExcepetion {
		Participations participations = new Participations();
		BigDecimal totalDistributed = BigDecimal.ZERO;
		final BigDecimal amoutAvaiable = disponibilizado;

		final List<Employee> employees = employeeRepository.findAll();
		for (Employee employee : employees) {
			ProfitsAndDividends profitsAndDividends = new ProfitsAndDividends(employee, minimalSalary);

			EmployeeParticipation employeeParticipation = new EmployeeParticipation();
			employeeParticipation.setMatricula(employee.getMatricula());
			employeeParticipation.setNome(employee.getNome());
			employeeParticipation.setTotalParticipation(profitsAndDividends.calculate());

			if (disponibilizado.compareTo(employeeParticipation.getTotalParticipation()) == 1) {
				participations.addToEmployeeParticipations(employeeParticipation);

				totalDistributed = totalDistributed.add(employeeParticipation.getTotalParticipation());

				disponibilizado = disponibilizado.subtract(employeeParticipation.getTotalParticipation());
			} else {
				throw new InsufficientAvailableExcepetion("Valor disponibilizado é insufuciente.");
			}
		}

		participations.setTotalAvailable(amoutAvaiable);
		participations.setTotalDistributed(totalDistributed);
		BigDecimal totalBalanceAvailable = amoutAvaiable.subtract(totalDistributed);
		participations.setTotalBalanceAvailable(totalBalanceAvailable);
		participations.setTotalStaff(employees.size());

		return participations;
	}

}
