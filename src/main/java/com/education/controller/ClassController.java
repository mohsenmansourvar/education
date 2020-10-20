package com.education.controller;

import com.education.domain.Class;
import com.education.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClassController {

    private final ClassService classService;

    @PutMapping(value = "/class")
    public Class save(@RequestBody Class aClass) {
        return classService.save(aClass);
    }

    @PostMapping(value = "/class/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Class aClass) {
        classService.update(id, aClass);
    }

    @DeleteMapping(value = "/class/{id}")
    public void delete(@PathVariable("id") long id) {
        classService.delete(id);
    }

    @GetMapping(value = "/class/{id}")
    public Class getById(@PathVariable("id") long id) {
        return classService.getById(id);
    }

    @GetMapping(value = "/class")
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }
}
