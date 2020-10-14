package com.education.service;

import com.education.domain.Teacher;
import com.education.repository.TeacherRepository;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void update(long id, Teacher newTeacher) {
        teacherRepository.update(id, newTeacher);
    }

    @Override
    public void delete(long id) {
        teacherRepository.delete(id);
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }
}
