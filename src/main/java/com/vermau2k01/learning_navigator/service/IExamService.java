package com.vermau2k01.learning_navigator.service;

import com.vermau2k01.learning_navigator.entity.Exam;
import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.payload.ExamDto;

import java.util.List;
import java.util.UUID;

public interface IExamService {

    Exam createExams(ExamDto exam);
    List<Exam> getAllExams();
    Exam getExamById(UUID id);
    Student registerStudent(UUID sid, UUID eId);

}
