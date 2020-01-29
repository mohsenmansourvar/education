package com.education.service;

import com.education.domain.Timetable;
import com.education.repository.TimetableRepository;

public class TimeTableServiceImpl implements TimeTableService {
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

    public void setTimeTableRepository(TimetableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }
}
