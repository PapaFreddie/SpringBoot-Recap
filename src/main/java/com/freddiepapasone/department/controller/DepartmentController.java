package com.freddiepapasone.department.controller;

import com.freddiepapasone.department.entity.Department;
import com.freddiepapasone.department.error.DepartmentNotFoundException;
import com.freddiepapasone.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    //create API's here

    @Autowired
    DepartmentService service;

    //Create new department
    @PostMapping("/")
    public Department createDepartment(@Valid @RequestBody Department department){
        return service.createDepartment(department);
    }

    //Get all departments

    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return service.getAllDepartments();
    }

    //Get departments by id

    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") Long departmentId) throws DepartmentNotFoundException {
        return service.getDepartmentById(departmentId);
    }

    //delete department by id

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId){
        service.deleteDepartmentById(departmentId);
        return "Department deleted successfully!!";
    }

    //update department by id

    @PutMapping("/departments/{departmentId}")

    public Department updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department department){
        return service.updateDepartment(departmentId, department);
    }


    //get department by name

    @GetMapping("/departments/name/{departmentName}")
    public Department getByDepartmentName(@PathVariable("departmentName") String departmentName){
        return service.getByDepartmentName(departmentName);
    }

}
