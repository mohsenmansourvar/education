package com.education.service;

import com.education.domain.Timetable;

public interface TimeTableService {
    void save (Timetable timeTable);

    Timetable getById(long id);
}