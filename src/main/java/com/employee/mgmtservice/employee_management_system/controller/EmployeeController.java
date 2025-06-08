package com.employee.mgmtservice.employee_management_system.controller;

import com.employee.mgmtservice.employee_management_system.entity.Employee;
import com.employee.mgmtservice.employee_management_system.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add-employee")
    public ResponseEntity<Map<String,String>> addEmployee(@Valid @RequestBody Employee employee) {
        Map<String,String> response = new HashMap<>();
        boolean status = employeeService.addEmployee(employee);
        if(status){
            response.put("status","Employee successfully added");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
            response.put("status","Failed to add employee");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/employees-list")
    public ResponseEntity<List<Employee>> getAllEmployees() {
       List<Employee> employeeList = employeeService.getAllEmployees();
       if(employeeList.isEmpty()){
           return new ResponseEntity<>(employeeList,HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
