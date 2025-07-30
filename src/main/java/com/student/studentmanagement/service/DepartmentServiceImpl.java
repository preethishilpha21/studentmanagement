package com.student.studentmanagement.service;

import com.student.studentmanagement.dto.DepartmentDTO;
import com.student.studentmanagement.model.Department;
import com.student.studentmanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository deptRepo;

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO dto) {
        Department dept = Department.builder()
                .name(dto.getName())
                .build();

        return convertToDTO(deptRepo.save(dept));
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return deptRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department dept = deptRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return convertToDTO(dept);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
        Department dept = deptRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        dept.setName(dto.getName());

        return convertToDTO(deptRepo.save(dept));
    }

    @Override
    public void deleteDepartment(Long id) {
        deptRepo.deleteById(id);
    }

    private DepartmentDTO convertToDTO(Department dept) {
        return DepartmentDTO.builder()
                .id(dept.getId())
                .name(dept.getName())
                .build();
    }
}
