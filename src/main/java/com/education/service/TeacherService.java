package com.education.service;

import com.education.domain.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);

    void update(long id, Teacher newTeacher);

    void delete(long id);

    Teacher getById(long id);

    List<Teacher> getAllTeachers();

}
