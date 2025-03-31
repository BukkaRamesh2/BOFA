
package com.bofa.controller;
import org.springframework.web.bind.annotation.PathVariable;
import com.bofa.model.Employee;
import com.bofa.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gmail")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/getEmployeeById/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployee(employeeId);
    }
}
