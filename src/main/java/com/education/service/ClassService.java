package com.education.service;

import com.education.domain.Class;

import java.util.List;

public interface ClassService {
    void save(Class aClass);

    Class getById(long id);

    void delete(long id);

    void update(long id, Class newRoom);

    List<Class> getAllRooms();
}
