package com.cg.employee_department_api.service;

import com.cg.employee_department_api.dto.*;
import com.cg.employee_department_api.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<EmployeeDTO> getAllEmployees();
    List<DepartmentDTO> getEmployeeCount();
    List<Employee> getByDepartment(String deptName);
    EmployeeDepartmentDTO getByMobile(String mobile);
}