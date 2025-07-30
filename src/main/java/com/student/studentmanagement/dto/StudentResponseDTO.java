package com.student.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseDTO {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String departmentName;
    private Set<String> courseTitles;
}
