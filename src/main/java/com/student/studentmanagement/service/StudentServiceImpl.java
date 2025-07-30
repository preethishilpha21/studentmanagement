package com.student.studentmanagement.service;

import com.student.studentmanagement.dto.StudentDTO;
import com.student.studentmanagement.dto.StudentResponseDTO;
import com.student.studentmanagement.model.Course;
import com.student.studentmanagement.model.Department;
import com.student.studentmanagement.model.Student;
import com.student.studentmanagement.repository.CourseRepository;
import com.student.studentmanagement.repository.DepartmentRepository;
import com.student.studentmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {

   private final StudentRepository studentRepo;
   private final DepartmentRepository deptRepo;
   private final CourseRepository courseRepo;

    @Override
    public StudentDTO addStudent(StudentDTO dto) {
       Department department=deptRepo.findById(dto.getDepartmentId()).orElseThrow(()->new RuntimeException("Department not found"));
        Set<Course> courses = courseRepo.findAllById(dto.getCourseIds())
                .stream()
                .collect(Collectors.toSet());


        Student student=Student.builder()
               .name(dto.getName())
               .age(dto.getAge())
               .email(dto.getEmail())
               .department(department)
               .courses(courses)
               .build();

       Student saved=studentRepo.save(student);
       return convertToDTO(saved);

    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepo.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }



    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        return convertToDTO(student);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        Department department=deptRepo.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));


        Set<Course> courses = courseRepo.findAllById(dto.getCourseIds())
                .stream()
                .collect(Collectors.toSet());


        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        student.setDepartment(department);
        student.setCourses(courses);

        Student updated=studentRepo.save(student);
        return convertToDTO(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }


    private StudentDTO convertToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .email(student.getEmail())
                .departmentId(student.getDepartment() != null ? student.getDepartment().getId() : null)
                .courseIds(student.getCourses() != null ? student.getCourses().stream().map(Course::getId).collect(Collectors.toSet())
                        : new HashSet<>())
                .build();
    }

    private StudentResponseDTO convertToResponseDTO(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .email(student.getEmail())
                .departmentName(student.getDepartment() != null ? student.getDepartment().getName() : null)
                .courseTitles(student.getCourses().stream()
                        .map(course -> course.getTitle())
                        .collect(Collectors.toSet()))
                .build();
    }
    @Override
    public StudentResponseDTO getStudentResponseById(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        return convertToResponseDTO(student);
    }




}
