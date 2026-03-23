package com.cg.employee_department_api.exception;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNameNotFoundException.class)
    public ResponseEntity<String> handleDept(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MobileNumberNotFoundException.class)
    public ResponseEntity<String> handleMobile(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}