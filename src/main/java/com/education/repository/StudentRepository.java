package com.education.repository;

import com.education.domain.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);

    void update(long id, Student newStudent);

    void delete(long id);

    Student getById(long id);

    List<Student> getAllStudent();
}
