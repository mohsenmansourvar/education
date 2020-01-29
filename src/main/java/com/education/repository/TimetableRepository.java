package com.education.repository;

import com.education.domain.Timetable;

public interface TimetableRepository {
    void save(Timetable timeTable);

    Timetable getById(long id);
}
