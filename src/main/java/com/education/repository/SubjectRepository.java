package com.education.repository;

import com.education.domain.Subject;

import java.util.List;

public interface SubjectRepository {
    void save(Subject subject);

    void update(long id, Subject newSubject);

    void delete(long id);

    Subject getById(long id);

    List<Subject> getAllSubjects();
}
