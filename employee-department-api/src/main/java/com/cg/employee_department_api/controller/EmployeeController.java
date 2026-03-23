package com.cg.employee_department_api.controller;

import com.cg.employee_department_api.dto.*;
import com.cg.employee_department_api.entity.Employee;
import com.cg.employee_department_api.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public String add(@Valid @RequestBody Employee emp) {
        service.addEmployee(emp);
        return "Employee added";
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/count")
    public List<DepartmentDTO> count() {
        return service.getEmployeeCount();
    }

    @GetMapping("/department/{name}")
    public List<Employee> getByDept(@PathVariable String name) {
        return service.getByDepartment(name);
    }

    @GetMapping("/mobile/{number}")
    public EmployeeDepartmentDTO getByMobile(@PathVariable String number) {
        return service.getByMobile(number);
    }
}