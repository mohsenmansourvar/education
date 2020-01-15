package com.education.repository;

import com.education.domain.Student;

public interface StudentRepository {
    void save(Student student);

    Student getById(long id);

    void delete(long id);

    void update(long id,Student newStudent);
}
