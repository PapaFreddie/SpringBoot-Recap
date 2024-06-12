package com.freddiepapasone.department.service;

import com.freddiepapasone.department.entity.Department;
import com.freddiepapasone.department.error.DepartmentNotFoundException;
import com.freddiepapasone.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository repository;
    @Override
    public Department createDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                repository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available!");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        //create new department object depDB and set its current value

        Department db = repository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            db.setDepartmentName(db.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
        !"".equalsIgnoreCase(department.getDepartmentAddress())){
            db.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())&&
        !"".equalsIgnoreCase(department.getDepartmentCode())){
            db.setDepartmentCode(department.getDepartmentCode());
        }

        return repository.save(db);
    }

    @Override
    public Department getByDepartmentName(String departmentName) {
        return repository.getByDepartmentNameIgnoreCase(departmentName);
    }



}
