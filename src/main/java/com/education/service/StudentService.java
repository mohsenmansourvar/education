package com.education.service;

import com.education.domain.Student;

public interface StudentService {
    void save(Student student);

    Student getById(long id);
    
    void delete (long id);
}
