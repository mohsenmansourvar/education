package com.education.repository;

import com.education.domain.Timetable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TimetableRepository {
    void save(Timetable timeTable);

    Timetable getById(long id);

    void delete(long id);

    void update(long id, Timetable newTimetable);

    List<Timetable> getAllTimetables();

    List<Timetable> getTimetablesByTeacherId(long teacherId);

    List<Timetable> getTimetablesByStudentId(long studentId);

    List<Timetable> getTimetablesByTeacherIds(List<Long> ids);

    List<Timetable> getTimetablesByTimeAndDate(LocalTime start, LocalTime end, LocalDate date);

    List<Timetable> getTimetablesByDate(LocalDate date);

    List<Timetable> getTimetablesWithoutTeacher();

    List<Timetable> getTimetableWithoutStudent();

}
