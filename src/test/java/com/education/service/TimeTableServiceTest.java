package com.education.service;

import com.education.domain.Timetable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void delete() {
        Timetable timeTable = new Timetable();
        timeTable.setStart(LocalTime.of(10, 0));
        timeTable.setEnd(LocalTime.of(11, 30));
        timeTable.setDate(LocalDate.now());
        timeTableService.save(timeTable);
        Long timeTableId = timeTable.getId();

        timeTableService.delete(timeTableId);

        Timetable timeTableById = timeTableService.getById(timeTableId);

        assertNull(timeTableById);
    }

    @Test
    public void update() {
        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTableService.save(timeTable1);
        Long timeTableId = timeTable1.getId();

        Timetable timetable2 = new Timetable();
        timetable2.setEnd(LocalTime.of(8, 45));

        timeTableService.update(timeTableId, timetable2);

        Timetable timetableById = timeTableService.getById(timeTableId);

        LocalTime expectedStart = LocalTime.of(7, 0);
        LocalTime expectedEnd = LocalTime.of(8, 45);
        assertNotNull(timetableById);
        assertEquals(expectedStart, timetableById.getStart());
        assertEquals(expectedEnd, timetableById.getEnd());
        assertEquals(LocalDate.now(), timetableById.getDate());
    }

    @Test
    public void getAllTimetables() {
        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTableService.save(timeTable1);

        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(10, 0));
        timetable2.setEnd(LocalTime.of(11, 30));
        timetable2.setDate(LocalDate.now());
        timeTableService.save(timetable2);

        List<Timetable> allTimetables = timeTableService.getAllTimetables();

        assertNotNull(allTimetables);
        assertEquals(2, allTimetables.size());
    }
}
