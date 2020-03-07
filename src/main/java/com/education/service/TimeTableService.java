package com.education.service;

import com.education.domain.Student;
import com.education.domain.Timetable;

import java.util.List;

public interface TimeTableService {
    void save(Timetable timeTable);

    Timetable getById(long id);

    void delete(long id);

    void update(long id, Timetable newTimetable);

    List<Timetable> getAllTimetables();

    List<Timetable> getTimetablesByTeacherId(long teacherId);

    List<Timetable> getTimetablesByStudentId(long studentId);


}
