package com.vermau2k01.learning_navigator.service;

import com.vermau2k01.learning_navigator.entity.Course;
import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.payload.SubjectDto;


import java.util.List;
import java.util.UUID;

public interface ICourseService {

    List<Course> getAllSubjects();
    Course getSubject(UUID id);
    Course createSubject(SubjectDto subject);
    void deleteSubject(UUID id);
    Student registerSubject(UUID sid, UUID subId);
}
