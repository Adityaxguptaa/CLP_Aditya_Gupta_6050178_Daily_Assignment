package com.cg.employee_department_api.exception;

public class MobileNumberNotFoundException extends RuntimeException {
    public MobileNumberNotFoundException(String msg) {
        super(msg);
    }
}