package com.bofa.controller;
import com.bofa.model.Client;
import org.springframework.web.bind.annotation.PathVariable;
import com.bofa.model.Employee;
import com.bofa.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gmail")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployee(employeeId);
    }
    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee){
        if(employee.getEmployeeId() == employeeId){
            throw new RuntimeException("EmployeeId do not match");
        }
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        if(employeeId == null){
            throw new RuntimeException("EmployeeId do not match");
        }
        employeeService.deleteEmployee(employeeId);
    }

}
