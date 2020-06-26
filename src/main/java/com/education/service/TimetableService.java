package com.education.service;

import com.education.domain.Student;
import com.education.domain.Timetable;
import com.education.domain.TimetableStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TimetableService {
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

    void addStudentToTimetable(long timetableId, long studentId);

    List<Student> getAllStudentsTimetable(long id);

    List<Timetable> getTimetablesByStatus(TimetableStatus status);

    Timetable activeTimetableStatus(long id);
}
