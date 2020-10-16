package com.education.repository;

import com.education.domain.Class;

import java.util.List;

public interface ClassRepository {
    void save(Class aClass);

    Class getById(long id);

    void delete(long id);

    void update(long id, Class newClass);

    List<Class> getAllRooms();
}
