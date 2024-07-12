package com.vermau2k01.learning_navigator.controller;

import com.vermau2k01.learning_navigator.entity.Course;
import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.payload.SubjectDto;
import com.vermau2k01.learning_navigator.service.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllSubjects(),
                HttpStatus.FOUND);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody SubjectDto course) {
        Course subject = courseService.createSubject(course);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable UUID id) {
        Course subject = courseService.getSubject(id);
        return new ResponseEntity<>(subject, HttpStatus.FOUND);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable UUID id) {
        courseService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/students/{sid}/courses/{cid}")
    public ResponseEntity<Student> updateCourse(@PathVariable UUID sid,
                                                @PathVariable UUID cid) {
        Student student = courseService.registerSubject(sid, cid);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}
