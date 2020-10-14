package com.education.repository;

import com.education.domain.Subject;

import java.util.List;

public interface SubjectRepository {
    void save(Subject subject);

    Subject getById(long id);

    void update(long id, Subject newSubject);

    void delete(long id);

    List<Subject>getAllSubjects();
}
