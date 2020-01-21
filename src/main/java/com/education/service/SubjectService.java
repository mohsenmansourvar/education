package com.education.service;

import com.education.domain.Subject;

public interface SubjectService {
    void save(Subject subject);

    Subject getById(long id);
}
