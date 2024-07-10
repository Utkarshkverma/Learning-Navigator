package com.vermau2k01.learning_navigator.repository;

import com.vermau2k01.learning_navigator.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExamRepository extends JpaRepository<Exam, UUID> {
}
