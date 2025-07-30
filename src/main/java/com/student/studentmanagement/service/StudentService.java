package com.student.studentmanagement.service;

import com.student.studentmanagement.dto.StudentDTO;
import com.student.studentmanagement.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentDTO addStudent(StudentDTO studentDTO);
    List<StudentResponseDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentResponseDTO getStudentResponseById(Long id);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}
