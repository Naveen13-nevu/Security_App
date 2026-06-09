package com.springsecurity.controller;

import com.springsecurity.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/new")
    public String samples() {
        return "Hello Java";
    }

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Naveen", 70),
            new Student(2, "Arun", 80)
    ));

    @GetMapping("/students")
    public List<Student> getStudent() {
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}