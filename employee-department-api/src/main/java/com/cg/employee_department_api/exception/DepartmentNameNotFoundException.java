package com.cg.employee_department_api.exception;

public class DepartmentNameNotFoundException extends RuntimeException {
    public DepartmentNameNotFoundException(String msg) {
        super(msg);
    }
}