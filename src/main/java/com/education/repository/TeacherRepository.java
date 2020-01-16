package com.education.repository;

import com.education.domain.Teacher;

public interface TeacherRepository {
    void save(Teacher teacher);

    Teacher getById(long id);
}
