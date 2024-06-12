package com.freddiepapasone.department.controller;

import com.freddiepapasone.department.entity.Department;
import com.freddiepapasone.department.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("KISWAHILI")
                .departmentAddress("KOKARE")
                .departmentCode("KI-02")
                .departmentId(1L)
                .build();
    }

    @Test
    void createDepartment() {
        Department inputDepartment = Department.builder()
                .departmentName("KISWAHILI")
                .departmentAddress("KOKARE")
                .departmentCode("KI-02")
                .build();

        Mockito.when(departmentService.createDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .content(" \"departmentName\": \"KISWAHILI\",\n" +
                        "    \"departmentAddress\": \"KOKARE\",\n" +
                        "    \"departmentCode\" : \"KI-02\""))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentById() {
        MockMvc.when(departmentService.getDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentTypes(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}