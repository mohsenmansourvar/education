package com.education.repository;

import com.education.domain.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);

    Student getById(long id);

    void delete(long id);

    void update(long id,Student newStudent);

    List<Student> getAllStudent();
}
