package com.education.controller;

import com.education.domain.Student;
import com.education.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student/{id}")
    public Student getById(@PathVariable long id) {

        return studentService.getById(id);
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
