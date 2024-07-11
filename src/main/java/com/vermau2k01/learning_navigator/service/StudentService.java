package com.vermau2k01.learning_navigator.service;

import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.exception.StudentNotFoundException;
import com.vermau2k01.learning_navigator.payload.StudentDto;
import com.vermau2k01.learning_navigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(UUID id) {
        return studentRepository.
                findById(id).
                orElseThrow(()-> new StudentNotFoundException(id.toString()));
    }

    @Override
    public Student addStudent(StudentDto student) {
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        return studentRepository.save(newStudent);
    }

    @Override
    public void deleteStudent(UUID id) {
        Student student = studentRepository.
                findById(id).
                orElseThrow(() -> new StudentNotFoundException(id.toString()));

        studentRepository.delete(student);

    }
}
