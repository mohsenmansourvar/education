package com.education.service;

import com.education.domain.Teacher;
import com.education.repository.TeacherRepository;

public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public void update(long id, Teacher newTeacher) {
        teacherRepository.update(id,newTeacher);
    }

    @Override
    public void delete(long id) {
        teacherRepository.delete(id);
    }

    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
}
