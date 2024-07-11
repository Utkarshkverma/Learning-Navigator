package com.vermau2k01.learning_navigator.controller;

import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.payload.StudentDto;
import com.vermau2k01.learning_navigator.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDto student) {
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent
                ,HttpStatus.CREATED);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable UUID id) {
        return new ResponseEntity<>(studentService.getStudentById(id)
                ,HttpStatus.FOUND);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getAllStudents()
                ,HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted Successfully"
                ,HttpStatus.NO_CONTENT);
    }
}
