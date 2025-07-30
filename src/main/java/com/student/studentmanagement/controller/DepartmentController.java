package com.student.studentmanagement.controller;

import com.student.studentmanagement.dto.DepartmentDTO;
import com.student.studentmanagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor

public class DepartmentController {
    private final DepartmentService deptService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO dto){
        return ResponseEntity.ok(deptService.addDepartment(dto));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(deptService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(deptService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
        return ResponseEntity.ok(deptService.updateDepartment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        deptService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully");
    }

}
