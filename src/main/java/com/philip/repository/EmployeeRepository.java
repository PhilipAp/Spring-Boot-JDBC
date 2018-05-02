package com.philip.repository;

import com.philip.model.Employee;

public interface EmployeeRepository {
	public abstract void createEmployee(Employee Employee);
	public abstract Employee getEmployeeById(Integer employeeId);
	public abstract void updateEmployeeByEmail(Integer employeeId, String newEmail);
	public abstract void deleteEmployeeById(Integer employeeId);

}
