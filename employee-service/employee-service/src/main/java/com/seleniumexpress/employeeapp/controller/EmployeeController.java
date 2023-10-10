package com.seleniumexpress.employeeapp.controller;


import com.seleniumexpress.employeeapp.response.EmployeeResponse;
import com.seleniumexpress.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    ResponseEntity<EmployeeResponse> GetEmployeeDetails(@PathVariable("id") int id){

        var employeeResponse = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }
}
