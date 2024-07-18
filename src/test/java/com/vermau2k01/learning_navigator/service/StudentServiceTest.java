package com.vermau2k01.learning_navigator.service;

import com.vermau2k01.learning_navigator.entity.Course;
import com.vermau2k01.learning_navigator.entity.Exam;
import com.vermau2k01.learning_navigator.entity.Student;
import com.vermau2k01.learning_navigator.exception.StudentNotFoundException;
import com.vermau2k01.learning_navigator.payload.StudentDto;
import com.vermau2k01.learning_navigator.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setup()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnAllStudents() {

        UUID studentId1 = UUID.randomUUID();
        UUID studentId2 = UUID.randomUUID();

        Set<Course> courses1 = new HashSet<>();
        Set<Course> courses2 = new HashSet<>();

        Set<Exam> exams1 = new HashSet<>();
        Set<Exam> exams2 = new HashSet<>();

        Student student1 = new Student(studentId1, "Utkarsh Verma", courses1, exams1);
        Student student2 = new Student(studentId2, "Rishab Verma", courses2, exams2);

        List<Student> students = Arrays.asList(student1, student2);
        when(studentRepository.findAll()).thenReturn(students);


        List<Student> returnedStudents = studentService.getAllStudents();

        assertEquals(2, returnedStudents.size());
        assertEquals(studentId1, returnedStudents.get(0).getId());
        assertEquals(studentId2, returnedStudents.get(1).getId());
        assertEquals("Utkarsh Verma", returnedStudents.get(0).getName());
        assertEquals("Rishab Verma", returnedStudents.get(1).getName());

    }

    @Test
    public void shouldReturnStudentById() {
        UUID studentId1 = UUID.randomUUID();
        Set<Course> courses1 = new HashSet<>();
        Set<Exam> exams1 = new HashSet<>();

        Student student1 = new Student(studentId1, "Utkarsh Verma", courses1, exams1);

        when(studentRepository.findById(studentId1)).thenReturn(Optional.of(student1));

        Student returnedStudent = studentService.getStudentById(studentId1);
        assertEquals(studentId1, returnedStudent.getId());
        assertEquals("Utkarsh Verma", returnedStudent.getName());
        assertEquals(courses1, returnedStudent.getCourses());
        assertEquals(exams1, returnedStudent.getExams());
    }



}
