package com.student.studentmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        private String name;
        private int age;
        private String email;

        @ManyToOne
        @JoinColumn(name="department_id")
        private Department department;

        @ManyToMany
        @JoinTable(
                name="student_course",
                joinColumns=@JoinColumn(name="student_id"),
                inverseJoinColumns = @JoinColumn(name="course_id")

        )
        private Set<Course> courses=new HashSet<>();

    }

