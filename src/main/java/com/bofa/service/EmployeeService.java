package com.bofa.service;

import com.bofa.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployee(Long employeeId);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Long employeeId);

    public Employee updateCustomer(Employee employee);

    public Employee saveEmployee(Employee employee);
}
