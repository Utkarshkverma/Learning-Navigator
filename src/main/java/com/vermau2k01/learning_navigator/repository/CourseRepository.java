package com.vermau2k01.learning_navigator.repository;

import com.vermau2k01.learning_navigator.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
