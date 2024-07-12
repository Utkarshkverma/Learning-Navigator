package com.vermau2k01.learning_navigator.service;

import com.vermau2k01.learning_navigator.entity.Exam;
import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.exception.CourseNotExistWithNameException;
import com.vermau2k01.learning_navigator.exception.ExamNotExistsException;
import com.vermau2k01.learning_navigator.exception.StudentNotFoundException;
import com.vermau2k01.learning_navigator.exception.SubjectNotRegisteredExceptions;
import com.vermau2k01.learning_navigator.payload.ExamDto;
import com.vermau2k01.learning_navigator.repository.CourseRepository;
import com.vermau2k01.learning_navigator.repository.ExamRepository;
import com.vermau2k01.learning_navigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExamService implements IExamService {

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Exam createExams(ExamDto exam) {
        courseRepository
                .findByName(exam.getExamName())
                .orElseThrow(()-> new CourseNotExistWithNameException(exam.getExamName()));
        Exam exam1 = new Exam();
        exam1.setTitle(exam.getExamName());
        return examRepository.save(exam1);
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam getExamById(UUID id) {
        return examRepository
                .findById(id)
                .orElseThrow(()->new ExamNotExistsException(id.toString()));
    }

    @Override
    public Student registerStudent(UUID sid, UUID eId) {
        Student student = studentRepository
                .findById(sid)
                .orElseThrow(() -> new StudentNotFoundException(sid.toString()));
        Exam exam = examRepository
                .findById(eId)
                .orElseThrow(() -> new ExamNotExistsException(eId.toString()));

        boolean isEnrolled = student
                .getCourses()
                .stream()
                .anyMatch(sub -> sub.getName().equals(exam.getTitle()));

        if(!isEnrolled)
            throw new SubjectNotRegisteredExceptions();

        exam.getStudents().add(student);
        student.getExams().add(exam);
        return studentRepository.save(student);
    }


}
