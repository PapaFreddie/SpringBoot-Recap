package com.freddiepapasone.department.service;

import com.freddiepapasone.department.entity.Department;
import com.freddiepapasone.department.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department getByDepartmentName(String departmentName);
}
