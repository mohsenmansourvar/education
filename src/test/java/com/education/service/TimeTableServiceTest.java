package com.education.service;

import com.education.domain.Teacher;
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
    @Autowired
    private TeacherService teacherService;

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

    @Test
    /*
    1- create an object of Teacher class --> teacher:Teacher
    2- set the parameters of teacher
    3- save this teacher
    4- create an object of timeTable class --> timeTable1:TimeTable
    5- set the parameters of timeTable1
    6- set the teacher in the timeTable1
    7- save this timeTable1
    8- create an object of timeTable class --> timeTable2: TimeTable
    9- set the parameter of timeTable2
    10- set the teacher in the timeTable2
    11 - save this timeTable2
    12- get an Id of teacher --> teacherId
    13- get timeTables by teacherId--> timeTables:List<TimeTable>

    Asserts :
    14-get the first timeTable of timeTables -->t1:TimeTable
    15- if t1 getStart  = 7 ?
    15- if t1 getEnd = 8:30 ?
    17- if t1 getDate = 6 ?

    18- get the second timeTable of timeTables -->t2:TimeTable
    15- if t1 getStart  = 8 ?
    15- if t1 getEnd = 89:30 ?
    17- if t1 getDate = 6 ?

    */
    public void getTimeTablesByTeacherId() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCode("00000000000");
        teacher.setSpecialty("Java Programmer");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0049");
        teacherService.save(teacher);
        Long teacherId = teacher.getId();


        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTable1.setTeacher(teacher);
        timeTableService.save(timeTable1);


        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(10, 0));
        timetable2.setEnd(LocalTime.of(11, 30));
        timetable2.setDate(LocalDate.now());
        timetable2.setTeacher(teacher);
        timeTableService.save(timetable2);



        Timetable timetable3 = new Timetable();
        timetable3.setStart(LocalTime.of(9, 0));
        timetable3.setEnd(LocalTime.of(10, 30));
        timetable3.setDate(LocalDate.now());

        timetable3.setTeacher(teacher);
        timeTableService.save(timetable3);


        List<Timetable> timetablesByTeacherId = timeTableService.getTimetablesByTeacherId(teacherId);

        Timetable t1 = timetablesByTeacherId.get(0);
        Timetable t2 = timetablesByTeacherId.get(1);
        Timetable t3 = timetablesByTeacherId.get(2);

        LocalTime expectedStartTimeT1 = LocalTime.of(7, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(8, 30);

        LocalTime expectedStartTimeT2 = LocalTime.of(10, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(11, 30);

        LocalTime expectedStartTimeT3 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT3 = LocalTime.of(10, 30);

        assertEquals(expectedStartTimeT1, t1.getStart());
        assertEquals(expectedEndTimeT1, t1.getEnd());
        assertEquals(LocalDate.now(), t1.getDate());
        assertEquals(expectedStartTimeT2, t2.getStart());
        assertEquals(expectedEndTimeT2, t2.getEnd());
        assertEquals(LocalDate.now(), t2.getDate());
        assertEquals(expectedStartTimeT3, t3.getStart());
        assertEquals(expectedEndTimeT3, t3.getEnd());
        assertEquals(LocalDate.now(), t3.getDate());

        assertEquals(3,timetablesByTeacherId.size());
    }
}