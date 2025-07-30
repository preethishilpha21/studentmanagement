package com.student.studentmanagement.service;

import com.student.studentmanagement.dto.CourseDTO;
import com.student.studentmanagement.model.Course;
import java.util.List;

public interface CourseService {
    CourseDTO addCourse(CourseDTO dto);
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO updateCourse(Long id, CourseDTO dto);
    void deleteCourse(Long id);
}
