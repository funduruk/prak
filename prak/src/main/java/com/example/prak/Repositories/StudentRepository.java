package com.example.prak.Repositories;

import com.example.prak.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
    List<Student> findByStatus(String status);

    List<Student> findByPhonenumber(String numberPhone);
}
