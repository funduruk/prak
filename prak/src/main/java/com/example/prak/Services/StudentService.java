package com.example.prak.Services;

import com.example.prak.Entities.Student;
import com.example.prak.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findStudentYoungerThan25(){
        LocalDate now = LocalDate.now();
        return studentRepository.findAll().stream()
                .filter(student -> Period.between(student.getBirthdate(), now).getYears() < 25)
                .collect(Collectors.toList());
    }

    public List<Student> findEndingStudent(){
        return studentRepository.findByStatus("Окончил");
    }

    public List<Student> findEmptyStudent(){
        return studentRepository.findByPhonenumber(null);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long id){
        return studentRepository.findById(id).orElse(null);
    }


}
