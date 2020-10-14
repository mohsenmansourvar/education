package com.education.service;

import com.education.domain.Teacher;

import java.util.List;

public interface TeacherService {
    void save(Teacher teacher);

    Teacher getById(long id);

    void update(long id, Teacher newTeacher);

    void delete(long id);

    List<Teacher> getAllTeachers();
}
