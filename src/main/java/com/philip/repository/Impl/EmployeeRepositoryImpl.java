package com.philip.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.philip.model.Employee;
import com.philip.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String createEmployeeSql = "INSERT INTO employee_table(employee_name,email,salary) values (?,?,?)";
		int Success = jdbcTemplate.update(createEmployeeSql, employee.getEmployeeName(),employee.getEmail(),employee.getSalary());
		
		if(Success == 1) {
			System.out.println("Employee is created .. ");
		}
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		String getEmployeeSql = "SELECT * FROM employee_table WHERE employee_id = ?";
		Employee employee = jdbcTemplate.queryForObject(getEmployeeSql, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	@Override
	public void updateEmployeeByEmail(Integer employeeId, String newEmail) {
		String updateEmployeeSql = "UPDATE employee_table SET email = ? WHERE employee_id = ? ";
		int update = jdbcTemplate.update(updateEmployeeSql, newEmail, employeeId);
		
		if(update == 1) {
			System.out.println("Employee email is updated .. ");
		}
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		String deleteEmployeeSql = "DELETE FROM employee_table WHERE employee_id = ? ";
		int delete = jdbcTemplate.update(deleteEmployeeSql, employeeId);
		
		if(delete == 1) {
			System.out.println("Employee id deleted .. ");
		}
	}

}
