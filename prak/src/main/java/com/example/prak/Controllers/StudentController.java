package com.example.prak.Controllers;

import com.example.prak.Entities.Student;
import com.example.prak.Repositories.StudentRepository;
import com.example.prak.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/userlist")
    public String getAllStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "userlist"; // Возвращаем имя шаблона для отображения списка студентов
    }

    @GetMapping("/sortByName")
    public String sortByName(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students",students);
        return "sortByName";
    }



    @GetMapping("/findByEmail")
    public String findStudentByEmail(@RequestParam(required = false) String email, Model model) {
        if (email == null) {
            return "error"; // Вернуть страницу с ошибкой
        }

        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            model.addAttribute("email", email); // Передаем email в модель
            model.addAttribute("student", student); // Передаем найденного студента в модель
            return "findByEmail"; // Вернуть страницу с информацией о студенте
        } else {
            return "notFound"; // Вернуть страницу с сообщением о том, что студент не найден
        }
    }

    @GetMapping("/less25")
    public String getStudentsYoungerThan25(Model model){
        List<Student> youngStudent = studentService.findStudentYoungerThan25();
        model.addAttribute("students", youngStudent);
        return "youngStudents";
    }

    @GetMapping("/endingStudents")
    public String getEndingStudents(Model model){
        List<Student> endingStudent = studentService.findEndingStudent();
        model.addAttribute("students", endingStudent);
        return "endingStudents";
    }

    @GetMapping("/emptyNumber")
    public String getEmptyNumber(Model model){
        List<Student> emptyNumber = studentService.findEmptyStudent();
        model.addAttribute("students", emptyNumber);
        return "emptyPhone";
    }

}