package com.education.service;

import com.education.domain.Teacher;

public interface TeacherService {
    void save(Teacher teacher);

    Teacher getById(long id);

    void update(long id, Teacher newTeacher);
}
