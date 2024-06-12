package com.freddiepapasone.department.repository;

import com.freddiepapasone.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department getByDepartmentName(String departmentName);
    Department getByDepartmentNameIgnoreCase(String departmentName);
}
