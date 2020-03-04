package com.education.repository;

import com.education.domain.Timetable;

import java.util.List;

public interface TimetableRepository {
    void save(Timetable timeTable);

    Timetable getById(long id);

    void delete(long id);

    void update(long id, Timetable newTimetable);

    List<Timetable> getAllTimetables();

    List<Timetable> getTimetablesByTeacherId(long teacherId);
}
