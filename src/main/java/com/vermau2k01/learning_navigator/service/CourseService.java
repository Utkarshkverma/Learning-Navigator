package com.vermau2k01.learning_navigator.service;

import com.vermau2k01.learning_navigator.entity.Course;
import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.exception.CourseNotFoundException;
import com.vermau2k01.learning_navigator.exception.StudentNotFoundException;
import com.vermau2k01.learning_navigator.payload.SubjectDto;
import com.vermau2k01.learning_navigator.repository.CourseRepository;
import com.vermau2k01.learning_navigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.UUID;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Course> getAllSubjects() {
        return courseRepository.findAll();
    }

    @Override
    public Course getSubject(UUID id) {
        return courseRepository.findById(id).orElseThrow(()->
                new CourseNotFoundException(id.toString()));
    }

    @Override
    public Course createSubject(SubjectDto subject) {
        Course course = new Course();
        course.setName(subject.getSubject());
        return courseRepository.save(course);
    }

    @Override
    public void deleteSubject(UUID id) {
        courseRepository.findById(id).orElseThrow(()->
                new CourseNotFoundException(id.toString()));
        courseRepository.deleteById(id);
    }

    @Override
    public Student registerSubject(UUID sid, UUID subId) {
        Student student = studentRepository.findById(sid)
                .orElseThrow(() -> new StudentNotFoundException(sid.toString()));

        Course course = courseRepository.findById(subId)
                .orElseThrow(() -> new CourseNotFoundException(subId.toString()));

        student.getCourses().add(course);
        course.getStudents().add(student);

        courseRepository.save(course);
        return studentRepository.save(student);
    }
}
