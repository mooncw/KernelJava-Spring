package com.example.kerneljavaspring.sisproject.domain.student.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByStudentId(Long studentId);
}
