package com.education.service;

import com.education.domain.Student;
import com.education.domain.Teacher;
import com.education.domain.Timetable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class TimetableServiceTest {

    @Autowired
    private TimetableService timeTableService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

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

        assertEquals(3, timetablesByTeacherId.size());
    }

    @Test
    public void getTimetableByStudentId() {
        Student student = new Student();
        student.setFirstName("Mohsen");
        student.setLastName("Mansourvar");
        student.setNationalCode("1111111111");
        student.setStudentNumber("111");
        student.setAddress("Adelaide");
        student.setTelephone("0061");
        studentService.save(student);
        Long studentId = student.getId();

        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTable1.setStudent(student);
        timeTableService.save(timeTable1);


        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(10, 0));
        timetable2.setEnd(LocalTime.of(11, 30));
        timetable2.setDate(LocalDate.now());
        timetable2.setStudent(student);
        timeTableService.save(timetable2);


        Timetable timetable3 = new Timetable();
        timetable3.setStart(LocalTime.of(9, 0));
        timetable3.setEnd(LocalTime.of(10, 30));
        timetable3.setDate(LocalDate.now());
        timetable3.setStudent(student);
        timeTableService.save(timetable3);

        List<Timetable> timetablesByStudentId = timeTableService.getTimetablesByStudentId(studentId);

        Timetable t1 = timetablesByStudentId.get(0);
        Timetable t2 = timetablesByStudentId.get(1);
        Timetable t3 = timetablesByStudentId.get(2);


        LocalTime expectedStartTimeT1 = LocalTime.of(7, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(8, 30);

        LocalTime expectedStartTimeT2 = LocalTime.of(10, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(11, 30);

        LocalTime expectedStartTimeT3 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT3 = LocalTime.of(10, 30);

        assertNotNull(timetablesByStudentId);
        assertEquals(expectedStartTimeT1, t1.getStart());
        assertEquals(expectedEndTimeT1, t1.getEnd());
        assertEquals(LocalDate.now(), t1.getDate());
        assertEquals(expectedStartTimeT2, t2.getStart());
        assertEquals(expectedEndTimeT2, t2.getEnd());
        assertEquals(LocalDate.now(), t2.getDate());
        assertEquals(expectedStartTimeT3, t3.getStart());
        assertEquals(expectedEndTimeT3, t3.getEnd());
        assertEquals(LocalDate.now(), t3.getDate());
        assertEquals(3, timetablesByStudentId.size());
    }

    @Test
    public void getTimetablesByTeacherIds() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Reza");
        teacher1.setLastName("Ebrahimi");
        teacher1.setNationalCode("0000000000");
        teacher1.setAddress("Berlin");
        teacher1.setTelephone("0041");
        teacher1.setSpecialty("programmer");
        teacherService.save(teacher1);
        Long teacher1Id = teacher1.getId();

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Mary");
        teacher2.setLastName("Ebrahimi");
        teacher2.setNationalCode("1111111111");
        teacher2.setAddress("Adelaide");
        teacher2.setTelephone("0069");
        teacher2.setSpecialty("Teacher");
        teacherService.save(teacher2);
        Long teacher2Id = teacher2.getId();


        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTable1.setTeacher(teacher1);
        timeTableService.save(timeTable1);

        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(9, 0));
        timetable2.setEnd(LocalTime.of(10, 30));
        timetable2.setDate(LocalDate.now());
        timetable2.setTeacher(teacher1);
        timeTableService.save(timetable2);

        Timetable timetable3 = new Timetable();
        timetable3.setStart(LocalTime.of(11, 0));
        timetable3.setEnd(LocalTime.of(12, 30));
        timetable3.setDate(LocalDate.now());
        timetable3.setTeacher(teacher2);
        timeTableService.save(timetable3);

        Timetable timetable4 = new Timetable();
        timetable4.setStart(LocalTime.of(1, 0));
        timetable4.setEnd(LocalTime.of(2, 30));
        timetable4.setDate(LocalDate.now());
        timetable4.setTeacher(teacher2);
        timeTableService.save(timetable4);


        List<Long> ids = new ArrayList<>();
        ids.add(teacher1Id);
        ids.add(teacher2Id);

        List<Timetable> timetablesByTeacherIds = timeTableService.getTimetablesByTeacherIds(ids);
        Timetable t1 = timetablesByTeacherIds.get(0);
        Timetable t2 = timetablesByTeacherIds.get(1);
        Timetable t3 = timetablesByTeacherIds.get(2);
        Timetable t4 = timetablesByTeacherIds.get(3);

        LocalTime expectedStartTimeT1 = LocalTime.of(7, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(8, 30);
        LocalTime expectedStartTimeT2 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(10, 30);
        LocalTime expectedStartTimeT3 = LocalTime.of(11, 0);
        LocalTime expectedEndTimeT3 = LocalTime.of(12, 30);
        LocalTime expectedStartTimeT4 = LocalTime.of(1, 0);
        LocalTime expectedEndTimeT4 = LocalTime.of(2, 30);

        assertEquals(expectedEndTimeT1, t1.getEnd());
        assertEquals(expectedStartTimeT1, t1.getStart());
        assertEquals(LocalDate.now(), t1.getDate());
        assertEquals(expectedStartTimeT2, t2.getStart());
        assertEquals(expectedEndTimeT2, t2.getEnd());
        assertEquals(LocalDate.now(), t2.getDate());
        assertEquals(expectedStartTimeT3, t3.getStart());
        assertEquals(expectedEndTimeT3, t3.getEnd());
        assertEquals(LocalDate.now(), t3.getDate());
        assertEquals(expectedStartTimeT4, t4.getStart());
        assertEquals(expectedEndTimeT4, t4.getEnd());
        assertEquals(LocalDate.now(), t4.getDate());
        assertEquals(teacher1Id, t1.getTeacher().getId());
        assertEquals(teacher1Id, t2.getTeacher().getId());
        assertEquals(teacher2Id, t3.getTeacher().getId());
        assertEquals(teacher2Id, t4.getTeacher().getId());
    }
/*

t1 = 7 - 8
t2 = 8 - 9
t3 = 9 - 10
t4 = 10 - 11

s = 8
e = 10
timetable.start >= s
timetable.end <= e


* */

    @Test
    public void getTimetablesByTimeAndDate() {
        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTableService.save(timeTable1);

        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(9, 0));
        timetable2.setEnd(LocalTime.of(10, 30));
        timetable2.setDate(LocalDate.now());
        timeTableService.save(timetable2);

        Timetable timetable3 = new Timetable();
        timetable3.setStart(LocalTime.of(11, 0));
        timetable3.setEnd(LocalTime.of(12, 30));
        timetable3.setDate(LocalDate.now());
        timeTableService.save(timetable3);

        Timetable timetable4 = new Timetable();
        timetable4.setStart(LocalTime.of(13, 0));
        timetable4.setEnd(LocalTime.of(14, 30));
        timetable4.setDate(LocalDate.now());
        timeTableService.save(timetable4);

        LocalTime expectedStartTimeT1 = LocalTime.of(7, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(8, 30);
        LocalTime expectedStartTimeT2 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(10, 30);
        LocalTime expectedStartTimeT3 = LocalTime.of(11, 0);
        LocalTime expectedEndTimeT3 = LocalTime.of(12, 30);
        LocalTime expectedStartTimeT4 = LocalTime.of(13, 0);
        LocalTime expectedEndTimeT4 = LocalTime.of(14, 30);

        List<Timetable> timetablesByTimeAndDate = timeTableService.getTimetablesByTimeAndDate(expectedStartTimeT2, expectedEndTimeT3, LocalDate.now());
        Timetable t2 = timetablesByTimeAndDate.get(0);
        Timetable t3 = timetablesByTimeAndDate.get(1);


        assertEquals(expectedStartTimeT2, t2.getStart());
        assertEquals(expectedEndTimeT2, t2.getEnd());
        assertEquals(expectedStartTimeT3, t3.getStart());
        assertEquals(expectedEndTimeT3, t3.getEnd());
    }

    @Test
    public void getTimetableByDate() {
        Timetable timetable1 = new Timetable();
        timetable1.setStart(LocalTime.of(7, 0));
        timetable1.setEnd(LocalTime.of(8, 30));
        timetable1.setDate(LocalDate.now());
        timeTableService.save(timetable1);

        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(9, 0));
        timetable2.setEnd(LocalTime.of(10, 30));
        timetable2.setDate(LocalDate.now());
        timeTableService.save(timetable2);

        Timetable timetable3 = new Timetable();
        timetable3.setStart(LocalTime.of(11, 0));
        timetable3.setEnd(LocalTime.of(12, 30));
        timetable3.setDate(LocalDate.now());
        timeTableService.save(timetable3);

        List<Timetable> timetableByDate = timeTableService.getTimetablesByDate(LocalDate.now());

        assertNotNull(timetableByDate);
        assertEquals(LocalDate.now(), timetable1.getDate());
        assertEquals(LocalDate.now(), timetable2.getDate());
        assertEquals(LocalDate.now(), timetable3.getDate());
    }

    @Test
    public void getTimetablesByWrongTeacherIds() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Reza");
        teacher1.setLastName("Ebrahimi");
        teacher1.setNationalCode("00000000000");
        teacher1.setSpecialty("Java Programmer");
        teacher1.setAddress("Berlin");
        teacher1.setTelephone("0049");
        teacherService.save(teacher1);

        Timetable timetable1 = new Timetable();
        timetable1.setStart(LocalTime.of(7, 0));
        timetable1.setEnd(LocalTime.of(8, 30));
        timetable1.setDate(LocalDate.now());
        timetable1.setTeacher(teacher1);
        timeTableService.save(timetable1);

        List<Long> ids = new ArrayList<>();
        ids.add(-1L);
        ids.add(-2L);

        List<Timetable> timetablesByTeacherIds = timeTableService.getTimetablesByTeacherIds(ids);

        assertNotNull(timetablesByTeacherIds);
        assertTrue(timetablesByTeacherIds.isEmpty());
        assertEquals(0, timetablesByTeacherIds.size());
    }

    @Test
    public void getTimetablesWithoutTeacher() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Reza");
        teacher1.setLastName("Ebrahimi");
        teacher1.setNationalCode("0000000000");
        teacher1.setAddress("Berlin");
        teacher1.setTelephone("0041");
        teacher1.setSpecialty("programmer");
        teacherService.save(teacher1);
        Long teacher1Id = teacher1.getId();


        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Mary");
        teacher2.setLastName("Ebrahimi");
        teacher2.setNationalCode("1111111111");
        teacher2.setAddress("Adelaide");
        teacher2.setTelephone("0069");
        teacher2.setSpecialty("Teacher");
        teacherService.save(teacher2);
        Long teacher2Id = teacher2.getId();


        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTable1.setTeacher(teacher1);
        timeTableService.save(timeTable1);

        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(9, 0));
        timetable2.setEnd(LocalTime.of(10, 30));
        timetable2.setDate(LocalDate.now());
        timetable2.setTeacher(teacher1);
        timeTableService.save(timetable2);

        Timetable timetable3 = new Timetable();
        timetable3.setStart(LocalTime.of(11, 0));
        timetable3.setEnd(LocalTime.of(12, 30));
        timetable3.setDate(LocalDate.now());
        timeTableService.save(timetable3);

        Timetable timetable4 = new Timetable();
        timetable4.setStart(LocalTime.of(1, 0));
        timetable4.setEnd(LocalTime.of(2, 30));
        timetable4.setDate(LocalDate.now());
        timeTableService.save(timetable4);


        List<Timetable> timetablesWithoutTeacher = timeTableService.getTimetablesWithoutTeacher();
        Timetable t3 = timetablesWithoutTeacher.get(0);
        Timetable t4 = timetablesWithoutTeacher.get(1);

        assertEquals(2, timetablesWithoutTeacher.size());
    }

    @Test
    public void getTimetableWithWrongStudentId() {
        Student student = new Student();
        student.setFirstName("Mohsen");
        student.setLastName("Mansourvar");
        student.setStudentNumber("001");
        student.setNationalCode("1111111111");
        student.setAddress("Adelaide");
        student.setTelephone("1111");
        studentService.save(student);

        Timetable timeTable1 = new Timetable();
        timeTable1.setStart(LocalTime.of(7, 0));
        timeTable1.setEnd(LocalTime.of(8, 30));
        timeTable1.setDate(LocalDate.now());
        timeTable1.setStudent(student);
        timeTableService.save(timeTable1);

        List<Timetable> timetablesByStudentId = timeTableService.getTimetablesByStudentId(-1L);

        assertEquals(0, timetablesByStudentId.size());
        assertTrue(timetablesByStudentId.isEmpty());
    }

    @Test
    public void getTimetableWithWrongTeacherId() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCode("0000000000");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0041");
        teacher.setSpecialty("programmer");
        teacherService.save(teacher);

        Timetable timetable = new Timetable();
        timetable.setStart(LocalTime.of(7, 0));
        timetable.setEnd(LocalTime.of(8, 30));
        timetable.setDate(LocalDate.now());
        timetable.setTeacher(teacher);
        timeTableService.save(timetable);

        List<Timetable> timetablesByTeacherId = timeTableService.getTimetablesByTeacherId(-1L);

        assertTrue(timetablesByTeacherId.isEmpty());
        assertEquals(0, timetablesByTeacherId.size());
    }
}
