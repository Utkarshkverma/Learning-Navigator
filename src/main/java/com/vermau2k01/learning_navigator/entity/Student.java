package com.vermau2k01.learning_navigator.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",joinColumns = {
            @JoinColumn(name = "student_id",
                    referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id",
            referencedColumnName = "id")})
    @JsonManagedReference
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "student_exams",joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")},
    inverseJoinColumns = {
            @JoinColumn(name = "exam_id", referencedColumnName = "id")
    })
    @JsonManagedReference
    private  Set<Exam> exams = new HashSet<>();

}
