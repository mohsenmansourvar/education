package com.education.service;

import com.education.domain.Class;

public interface ClassService {
    void save(Class room);

    Class getById(long id);

    void delete(long id);
}
