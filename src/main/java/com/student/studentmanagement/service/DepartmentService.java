package com.student.studentmanagement.service;

import com.student.studentmanagement.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO getDepartmentById(Long id);
    DepartmentDTO updateDepartment(Long id, DepartmentDTO dto);
    void deleteDepartment(Long id);
}
