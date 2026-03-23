package com.cg.employee_department_api.repo;
import com.cg.employee_department_api.entity.Department;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

    @Query("SELECT d.name, COUNT(e) FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
    List<Object[]> countEmployeesByDepartment();
}
