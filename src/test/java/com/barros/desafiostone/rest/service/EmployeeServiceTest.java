package com.barros.desafiostone.rest.service;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.barros.desafiostone.model.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeService.class)
public class EmployeeServiceTest {

	private static final String EMPLOYEE = "/rest/employee";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService employeeService;

	@Test
	public void getEmployees() throws Exception {
		Employee employee = new Employee();
		employee.setNome("José Stone");

		List<Employee> allEmployees = singletonList(employee);

		given(employeeService.all()).willReturn(allEmployees);

		mvc.perform(get(EMPLOYEE + "/all")
				.contentType(APPLICATION_JSON))
		.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].nome", is(employee.getNome())));
	}

}
