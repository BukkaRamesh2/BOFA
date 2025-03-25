package com.bofa.service;


import com.bofa.model.Employee;
import com.bofa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository EmpRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo) {
        EmpRepo = empRepo;
    }

    @Override
    public Employee getEmployee(Long employeeId){
        return EmpRepo.findById(employeeId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }
    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> emplist=new ArrayList();
        emplist=EmpRepo.findAll();
        if(emplist.size()==0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Employee found");
        }
        emplist.forEach(employee -> System.out.println(employee));
        return emplist;
    }
    @Override
    public void deleteEmployee(Long employeeId){
        EmpRepo.deleteById(employeeId);
    }
    @Override
    public Employee updateCustomer(Employee employee){
        if(employee.getFirstName()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "FirstName is required");
        }
        switch(employee.getFirstName()){
            case "alex": System.out.println();
            case "bob": System.out.println();
        }
        return EmpRepo.save(employee);
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return EmpRepo.save(employee);
    }


}
