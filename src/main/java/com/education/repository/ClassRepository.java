package com.education.repository;

import com.education.domain.Class;

public interface ClassRepository {
    void save (Class room);

    Class getById(long id);
}
