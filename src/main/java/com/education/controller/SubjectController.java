package com.education.controller;

import com.education.domain.Subject;
import com.education.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubjectController {

    private SubjectService subjectService;

    @PutMapping(value = "/subject")
    public Subject save(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }

    @PostMapping(value = "/subject/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Subject newSubject) {
        subjectService.update(id, newSubject);
    }

    @DeleteMapping(value = "/subject/{id}")
    public void delete(@PathVariable("id") long id) {
        subjectService.delete(id);
    }

    @GetMapping(value = "/subject/{id}")
    public Subject getById(@PathVariable("id") long id) {
        return subjectService.getById(id);
    }

    @GetMapping(value = "/subject")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
