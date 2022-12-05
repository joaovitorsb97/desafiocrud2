package com.desafiocrud.desafiocrud2.repositories;

import com.desafiocrud.desafiocrud2.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
