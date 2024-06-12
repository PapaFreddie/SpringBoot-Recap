package com.freddiepapasone.department.service;

import com.freddiepapasone.department.entity.Department;
import com.freddiepapasone.department.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean


    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department
                .builder()
                .departmentName("IT")
                .departmentAddress("KIRIKO")
                .departmentCode("KI-02")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.getByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found =
                departmentService.getByDepartmentName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}