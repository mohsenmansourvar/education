package com.education.controller;

import com.education.domain.Student;
import com.education.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PutMapping(value = "/student")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PostMapping(value = "/student/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Student newStudent) {
        studentService.update(id, newStudent);
    }

    @DeleteMapping(value = "/student/{id}")
    public void delete(@PathVariable("id") long id) {
        studentService.delete(id);
    }

    @GetMapping(value = "/student/{id}")
    public Student getById(@PathVariable("id") long id) {
        return studentService.getById(id);
    }

    @GetMapping(value = "/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
