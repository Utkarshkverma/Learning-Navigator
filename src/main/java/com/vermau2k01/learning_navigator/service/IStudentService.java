package com.vermau2k01.learning_navigator.service;

import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.payload.StudentDto;

import java.util.List;
import java.util.UUID;

public interface IStudentService {

    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    Student addStudent(StudentDto student);
    void deleteStudent(UUID id);
}
