package com.education.service;

import com.education.domain.Class;
import com.education.repository.ClassRepository;

public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;

    @Override
    public void save(Class room) {
        classRepository.save(room);
    }

    @Override
    public Class getById(long id) {
        return classRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        classRepository.delete(id);
    }

    public void setClassRepository(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
}
