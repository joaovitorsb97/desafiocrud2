package com.desafiocrud.desafiocrud2.repositories;

import com.desafiocrud.desafiocrud2.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
