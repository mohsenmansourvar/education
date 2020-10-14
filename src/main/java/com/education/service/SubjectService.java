package com.education.service;

import com.education.domain.Subject;

import java.util.ArrayList;
import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();

    void save(Subject subject);

    Subject getById(long id);

    void update(long id, Subject newSubject);

    void delete(long id);
}
