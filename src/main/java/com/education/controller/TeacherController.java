package com.education.controller;

import com.education.domain.Teacher;
import com.education.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

    @PutMapping(value = "/teacher")
    public Teacher save(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @PostMapping(value = "/teacher/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Teacher newTeacher) {
        teacherService.update(id, newTeacher);
    }

    @DeleteMapping(value = "/teacher/{id}")
    public void delete(@PathVariable("id") long id) {
        teacherService.delete(id);
    }

    @GetMapping(value = "/teacher/{id}")
    public Teacher getById(@PathVariable("id") long id) {
        return teacherService.getById(id);
    }

    @GetMapping(value = "/teacher")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeachers();
    }
}
