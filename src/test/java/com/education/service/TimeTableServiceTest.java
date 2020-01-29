package com.education.service;

import com.education.domain.Timetable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class TimeTableServiceTest {
    @Autowired
    private TimeTableService timeTableService;

    @Test
    public void save() {
        Timetable timeTable = new Timetable();
        timeTable.setStart(LocalTime.of(8, 0));
        timeTable.setEnd(LocalTime.of(9, 30));
        timeTable.setDate(LocalDate.now());
        timeTableService.save(timeTable);
        Long timeTableId = timeTable.getId();

        Timetable timeTableById = timeTableService.getById(timeTableId);
        LocalTime expectedStart = LocalTime.of(8, 0);
        LocalTime expectedEnd = LocalTime.of(9, 30);
        assertNotNull(timeTableById);
        assertEquals(expectedStart, timeTableById.getStart());
        assertEquals(expectedEnd, timeTableById.getEnd());
        assertEquals(LocalDate.now(), timeTableById.getDate());
    }
    @Test
    public void getById() {
        Timetable timeTable = new Timetable();
        timeTable.setStart(LocalTime.of(9, 0));
        timeTable.setEnd(LocalTime.of(10, 30));
        timeTable.setDate(LocalDate.now());
        timeTableService.save(timeTable);
        Long timeTableId = timeTable.getId();

        Timetable timeTableById = timeTableService.getById(timeTableId);
        LocalTime expectedStart = LocalTime.of(9, 0);
        LocalTime expectedEnd = LocalTime.of(10, 30);
        assertNotNull(timeTableById);
        assertEquals(expectedStart, timeTableById.getStart());
        assertEquals(expectedEnd, timeTableById.getEnd());
        assertEquals(LocalDate.now(), timeTableById.getDate());
    }
}
