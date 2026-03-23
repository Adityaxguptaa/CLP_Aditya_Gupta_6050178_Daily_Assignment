package com.cg.employee_department_api.repo;
import com.cg.employee_department_api.entity.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> findAllWithDepartment();

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    @Query("SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mobile")
    Employee findByMobile(@Param("mobile") String mobile);
}