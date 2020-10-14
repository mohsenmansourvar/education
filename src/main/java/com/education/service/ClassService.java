package com.education.service;

import com.education.domain.Class;

import java.util.List;

public interface ClassService {

    void save(Class aClass);

    void update(long id, Class newRoom);

    void delete(long id);

    Class getById(long id);

    List<Class> getAllClasses();
}
