package com.barros.desafiostone.rest.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barros.desafiostone.model.Employee;
import com.barros.desafiostone.repository.EmployeeRepository;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PostMapping("/create/all")
	public List<Employee> addAll(@Valid @RequestBody List<Employee> employees) {

		for (Employee employee : employees) {
			employeeRepository.set(employee);
		}

		return all();
	}

	@PostMapping("/create")
	public Employee add(@Valid @RequestBody Employee employee) {

		return employeeRepository.set(employee);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> update(@Valid @RequestBody Employee employeeIncomming) {
		final Employee employee = this.employeeRepository.get(employeeIncomming.getMatricula());
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}

		employee.setMatricula(employeeIncomming.getMatricula());
		employee.setDataAdmissao(employeeIncomming.getDataAdmissao());
		employee.setNome(employeeIncomming.getNome());
		employee.setArea(employeeIncomming.getArea());
		employee.setCargo(employeeIncomming.getCargo());
		employee.setSalarioBruto(employeeIncomming.getSalarioBruto());

		return ResponseEntity.ok(employeeRepository.update(employee));
	}

	@DeleteMapping("/delete/{matricula}")
	public List<Employee> delete(@PathVariable("matricula") final String matricula) {

		employeeRepository.remove(matricula);

		return all();
	}

	@GetMapping("/all")
	public List<Employee> all() {
		return employeeRepository.findAll();
	}

}
