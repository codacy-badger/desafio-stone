package com.barros.desafiostone.repository;

import org.springframework.stereotype.Repository;

import com.barros.desafiostone.model.Employee;
import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;

@Repository
public class EmployeeRepository extends DefaultFirebaseRealtimeDatabaseRepository<Employee, String> {

}
