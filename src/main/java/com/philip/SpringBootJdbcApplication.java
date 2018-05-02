package com.philip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.philip.model.Employee;
import com.philip.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createEmployee();
		getEmployeeById();
	}

	private void getEmployeeById() {
		Employee employee = employeeRepository.getEmployeeById(1);
		System.out.println(employee);
	}

	private void createEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("George");
		employee.setEmail("george@gmail.com");
		employee.setSalary(1190000.00);
		employeeRepository.createEmployee(employee);
	}
}
