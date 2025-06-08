package com.employee.mgmtservice.employee_management_system.service;

import com.employee.mgmtservice.employee_management_system.entity.Employee;
import com.employee.mgmtservice.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private  final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean addEmployee(Employee employee) {
        try{
            Employee saved = employeeRepository.save(employee);
            return saved.getId() != null;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    public List<Employee> getAllEmployees(){
        try {
            return employeeRepository.findAll();
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
