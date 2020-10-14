package com.education.repository;

import com.education.domain.Teacher;

import java.util.List;

public interface TeacherRepository {

    void save(Teacher teacher);

    void update(long id, Teacher newTeacher);

    void delete(long id);

    Teacher getById(long id);

    List<Teacher> getAllTeachers();
}
