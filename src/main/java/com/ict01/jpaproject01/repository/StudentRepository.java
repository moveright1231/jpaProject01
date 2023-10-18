package com.ict01.jpaproject01.repository;

import com.ict01.jpaproject01.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
