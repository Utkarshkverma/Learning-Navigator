package com.vermau2k01.learning_navigator.repository;

import com.vermau2k01.learning_navigator.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
