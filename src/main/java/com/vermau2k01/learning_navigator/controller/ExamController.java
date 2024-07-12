package com.vermau2k01.learning_navigator.controller;

import com.vermau2k01.learning_navigator.entity.Exam;
import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.payload.ExamDto;
import com.vermau2k01.learning_navigator.service.IExamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class ExamController {

    @Autowired
    private IExamService examService;

    @PostMapping("/exams")
    public ResponseEntity<Exam> addExam(@Valid @RequestBody ExamDto exam) {
        Exam exams = examService.createExams(exam);
        return new ResponseEntity<>(exams, HttpStatus.CREATED);
    }

    @GetMapping("/exams")
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @GetMapping("/exams/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable UUID id) {
        Exam examById = examService.getExamById(id);
        return new ResponseEntity<>(examById, HttpStatus.FOUND);
    }

    @PutMapping("/students/{sid}/exams/{eid}")
    public ResponseEntity<Student> updateExam(@PathVariable UUID sid,
                                           @PathVariable UUID eid) {

        Student student = examService.registerStudent(sid, eid);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
