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

    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
}
