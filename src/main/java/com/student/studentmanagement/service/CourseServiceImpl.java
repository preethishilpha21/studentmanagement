package com.student.studentmanagement.service;

import com.student.studentmanagement.dto.CourseDTO;
import com.student.studentmanagement.model.Course;
import com.student.studentmanagement.model.Department;
import com.student.studentmanagement.repository.CourseRepository;
import com.student.studentmanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;
    private final DepartmentRepository departmentRepo;

    @Override
    public CourseDTO addCourse(CourseDTO dto) {
        Department department = departmentRepo.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        Course course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .department(department)
                .build();

        return convertToDTO(courseRepo.save(course));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return convertToDTO(course);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());

        return convertToDTO(courseRepo.save(course));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO.CourseDTOBuilder builder = CourseDTO.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription());


        if (course.getDepartment() != null) {
            builder.departmentId(course.getDepartment().getId());
        }

        return builder.build();
    }

}