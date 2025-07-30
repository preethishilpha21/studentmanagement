package com.student.studentmanagement.controller;

import com.student.studentmanagement.dto.StudentDTO;
import com.student.studentmanagement.dto.StudentResponseDTO;
import com.student.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.addStudent(dto));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }


    @GetMapping("/response/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentResponseById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentResponseById(id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.updateStudent(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
