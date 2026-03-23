package com.cg.employee_department_api.service;
import com.cg.employee_department_api.dto.*;
import com.cg.employee_department_api.entity.*;
import com.cg.employee_department_api.exception.*;
import com.cg.employee_department_api.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    public void addEmployee(Employee employee) {
        empRepo.save(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> list = empRepo.findAllWithDepartment();
        List<EmployeeDTO> result = new ArrayList<>();

        for (Employee e : list) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.id = e.getId();
            dto.name = e.getName();
            dto.salary = e.getSalary();
            dto.departmentName = e.getDepartment().getName();
            dto.managerName = e.getDepartment().getManagerName();
            result.add(dto);
        }
        return result;
    }

    public List<DepartmentDTO> getEmployeeCount() {
        List<Object[]> data = deptRepo.countEmployeesByDepartment();
        List<DepartmentDTO> result = new ArrayList<>();

        for (Object[] row : data) {
            DepartmentDTO dto = new DepartmentDTO();
            dto.name = (String) row[0];
            dto.employeeCount = (Long) row[1];
            result.add(dto);
        }
        return result;
    }

    public List<Employee> getByDepartment(String deptName) {
        List<Employee> list = empRepo.findByDepartmentName(deptName);
        if (list.isEmpty()) throw new DepartmentNameNotFoundException("Department not found");
        return list;
    }

    public EmployeeDepartmentDTO getByMobile(String mobile) {
        Employee e = empRepo.findByMobile(mobile);
        if (e == null) throw new MobileNumberNotFoundException("Mobile not found");

        EmployeeDepartmentDTO dto = new EmployeeDepartmentDTO();
        dto.empId = e.getId();
        dto.empName = e.getName();
        dto.deptName = e.getDepartment().getName();
        dto.managerName = e.getDepartment().getManagerName();

        return dto;
    }
}
