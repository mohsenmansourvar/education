package com.education.service;

import com.education.domain.Timetable;
import com.education.repository.TimetableRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TimetableServiceImpl implements TimetableService {
    private TimetableRepository timeTableRepository;

    @Override
    public void save(Timetable timeTable) {
        timeTableRepository.save(timeTable);
    }

    @Override
    public Timetable getById(long id) {
        return timeTableRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        timeTableRepository.delete(id);
    }

    @Override
    public void update(long id, Timetable newTimetable) {
        timeTableRepository.update(id, newTimetable);
    }

    @Override
    public List<Timetable> getAllTimetables() {
        return timeTableRepository.getAllTimetables();
    }

    @Override
    public List<Timetable> getTimetablesByTeacherId(long teacherId) {
        return timeTableRepository.getTimetablesByTeacherId(teacherId);
    }

    @Override
    public List<Timetable> getTimetablesByStudentId(long studentId) {
        return timeTableRepository.getTimetablesByStudentId(studentId);
    }

    @Override
    public List<Timetable> getTimetablesByTeacherIds(List<Long> ids) {
        if (ids == null) {
            throw new IllegalArgumentException("Ids cannot be null");
        }
        return timeTableRepository.getTimetablesByTeacherIds(ids);
    }

    @Override
    public List<Timetable> getTimetablesByTimeAndDate(LocalTime start, LocalTime end, LocalDate date) {
        return timeTableRepository.getTimetablesByTimeAndDate(start, end, date);
    }

    public void setTimeTableRepository(TimetableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }
}
