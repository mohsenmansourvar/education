package com.education.service;

import com.education.domain.Class;
import com.education.repository.ClassRepository;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void save(Class aClass) {
        classRepository.save(aClass);
    }

    @Override
    public Class getById(long id) {
        return classRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        classRepository.delete(id);
    }

    @Override
    public void update(long id, Class newRoom) {
        classRepository.update(id, newRoom);
    }

    @Override
    public List<Class> getAllRooms() {
        return classRepository.getAllRooms();
    }
}
