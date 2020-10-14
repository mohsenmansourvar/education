package com.education.service;

import com.education.domain.Class;
import com.education.domain.*;
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
class TimetableServiceTest {

    @Autowired
    private TimetableService timeTableService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @Test
    void save() {
        Timetable timetable = SampleBuilder.timetable1();
        timeTableService.save(timetable);

        Timetable timeTableById = timeTableService.getById(timetable.getId());
        LocalTime expectedStart = LocalTime.of(7, 0);
        LocalTime expectedEnd = LocalTime.of(8, 30);
        assertNotNull(timeTableById);
        assertEquals(expectedStart, timeTableById.getStart());
        assertEquals(expectedEnd, timeTableById.getEnd());
        assertEquals(LocalDate.now(), timeTableById.getDate());
    }

    @Test
    void getById() {
        Timetable timetable = SampleBuilder.timetable1();
        timeTableService.save(timetable);

        Timetable timeTableById = timeTableService.getById(timetable.getId());
        LocalTime expectedStart = LocalTime.of(7, 0);
        LocalTime expectedEnd = LocalTime.of(8, 30);
        assertNotNull(timeTableById);
        assertEquals(expectedStart, timeTableById.getStart());
        assertEquals(expectedEnd, timeTableById.getEnd());
        assertEquals(LocalDate.now(), timeTableById.getDate());
    }

    @Test
    void delete() {
        Timetable timetable = SampleBuilder.timetable1();
        timeTableService.save(timetable);

        timeTableService.delete(timetable.getId());

        Timetable timeTableById = timeTableService.getById(timetable.getId());

        assertNull(timeTableById);
    }

    @Test
    void update() {
        Timetable timetable1 = Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .build();
        timeTableService.save(timetable1);

        Timetable timetable2 = Timetable.builder()
                .end(LocalTime.of(8, 45))
                .build();
        timeTableService.update(timetable1.getId(), timetable2);

        Timetable timetableById = timeTableService.getById(timetable1.getId());

        LocalTime expectedStart = LocalTime.of(7, 0);
        LocalTime expectedEnd = LocalTime.of(8, 45);
        assertNotNull(timetableById);
        assertEquals(expectedStart, timetableById.getStart());
        assertEquals(expectedEnd, timetableById.getEnd());
        assertEquals(LocalDate.now(), timetableById.getDate());
    }

    @Test
    void getAllTimetables() {
        Timetable timetable1 = SampleBuilder.timetable1();
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2();
        timeTableService.save(timetable2);

        List<Timetable> allTimetables = timeTableService.getAllTimetables();

        assertNotNull(allTimetables);
        assertEquals(2, allTimetables.size());
    }

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
    12- get an Id of teacher - -> teacherId
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
    @Test
    void getTimeTablesByTeacherId() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Timetable timetable1 = SampleBuilder.timetable1(teacher);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2();
        timeTableService.save(timetable2);
        timetable2.setTeacher(teacher);

        Timetable timetable3 = SampleBuilder.timetable3();
        timeTableService.save(timetable3);
        timetable3.setTeacher(teacher);

        List<Timetable> timetablesByTeacherId = timeTableService.getTimetablesByTeacherId(teacher.getId());

        Timetable t1 = timetablesByTeacherId.get(0);
        Timetable t2 = timetablesByTeacherId.get(1);
        Timetable t3 = timetablesByTeacherId.get(2);

        LocalTime expectedStartTimeT1 = LocalTime.of(7, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(8, 30);

        LocalTime expectedStartTimeT2 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(10, 30);

        LocalTime expectedStartTimeT3 = LocalTime.of(11, 0);
        LocalTime expectedEndTimeT3 = LocalTime.of(12, 30);

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
    void getTimetablesByTeacherIds() {
        Teacher teacher1 = SampleBuilder.teacher1();
        teacherService.save(teacher1);

        Teacher teacher2 = SampleBuilder.teacher2();
        teacherService.save(teacher2);

        Timetable timetable1 = SampleBuilder.timetable1(teacher1);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(teacher1);
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3(teacher2);
        timeTableService.save(timetable3);

        Timetable timetable4 = SampleBuilder.timetable4(teacher2);
        timeTableService.save(timetable4);

        List<Long> ids = new ArrayList<>();
        ids.add(teacher1.getId());
        ids.add(teacher2.getId());

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
        LocalTime expectedStartTimeT4 = LocalTime.of(13, 0);
        LocalTime expectedEndTimeT4 = LocalTime.of(14, 30);

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
        assertEquals(teacher1.getId(), t1.getTeacher().getId());
        assertEquals(teacher1.getId(), t2.getTeacher().getId());
        assertEquals(teacher2.getId(), t3.getTeacher().getId());
        assertEquals(teacher2.getId(), t4.getTeacher().getId());
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
    void getTimetablesByTimeAndDate() {
        Timetable timetable1 = SampleBuilder.timetable1();
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2();
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3();
        timeTableService.save(timetable3);

        Timetable timetable4 = SampleBuilder.timetable4();
        timeTableService.save(timetable4);

        LocalTime expectedStartTimeT2 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(10, 30);
        LocalTime expectedStartTimeT3 = LocalTime.of(11, 0);
        LocalTime expectedEndTimeT3 = LocalTime.of(12, 30);

        List<Timetable> timetablesByTimeAndDate = timeTableService.getTimetablesByTimeAndDate(expectedStartTimeT2, expectedEndTimeT3, LocalDate.now());
        Timetable t2 = timetablesByTimeAndDate.get(0);
        Timetable t3 = timetablesByTimeAndDate.get(1);

        assertEquals(expectedStartTimeT2, t2.getStart());
        assertEquals(expectedEndTimeT2, t2.getEnd());
        assertEquals(expectedStartTimeT3, t3.getStart());
        assertEquals(expectedEndTimeT3, t3.getEnd());
    }

    @Test
    void getTimetablesByWrongTeacherIds() {
        Teacher teacher1 = SampleBuilder.teacher1();
        teacherService.save(teacher1);

        Timetable timetable1 = SampleBuilder.timetable1(teacher1);
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
    void getTimetableByDate() {
        Timetable timetable1 = SampleBuilder.timetable1();
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2();
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3();
        timeTableService.save(timetable3);

        List<Timetable> timetableByDate = timeTableService.getTimetablesByDate(LocalDate.now());

        assertNotNull(timetableByDate);
        assertEquals(LocalDate.now(), timetable1.getDate());
        assertEquals(LocalDate.now(), timetable2.getDate());
        assertEquals(LocalDate.now(), timetable3.getDate());
    }

    @Test
    void getTimetablesWithoutTeacher() {
        Teacher teacher1 = SampleBuilder.teacher1();
        teacherService.save(teacher1);

        Teacher teacher2 = SampleBuilder.teacher2();
        teacherService.save(teacher2);

        Timetable timetable1 = SampleBuilder.timetable1(teacher1);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(teacher1);
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3();
        timeTableService.save(timetable3);

        Timetable timetable4 = SampleBuilder.timetable4();
        timeTableService.save(timetable4);

        List<Timetable> timetablesWithoutTeacher = timeTableService.getTimetablesWithoutTeacher();

        assertEquals(2, timetablesWithoutTeacher.size());
    }

    @Test
    void getTimetableWithWrongStudentId() {
        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable);

        List<Timetable> timetablesByStudentId = timeTableService.getTimetablesByStudentId(-1L);

        assertEquals(0, timetablesByStudentId.size());
        assertTrue(timetablesByStudentId.isEmpty());
    }

    @Test
    void getTimetableWithWrongTeacherId() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Timetable timetable = SampleBuilder.timetable1(teacher);
        timeTableService.save(timetable);

        List<Timetable> timetablesByTeacherId = timeTableService.getTimetablesByTeacherId(-1L);

        assertTrue(timetablesByTeacherId.isEmpty());
        assertEquals(0, timetablesByTeacherId.size());
    }

    /*
    "given"
    1-create a student -->student1:Student
    2- set the fields of student1 and save
    3-create a student -->student2:Student
    4-set the fields of student2 and save
    5-create a timetable --> timetable1:timetable
    6- set the fields of timetable1 and also set student1 and student2
    7-create a timetable --> timetable2:timetable
    8-set the fields of timetable2 without any students
    9-create a timetable --> timetable3:timetable
    10- set the fields of timetable3 without any students
    11-create a timetable --> timetable4:timetable
    12-set the fields of timetable4 and also set student1 and student2
    "when"
    13-call the getTimetableWithoutStudent() method --> timetablesWithoutStudent:List<Timetable>
    "then"
    14-students field of the first cell of timetablesWithoutStudent should be null
    15-students field of the second cell of timetablesWithoutStudent should be null
    */
    @Test
    void getTimetableWithoutStudent() {
        Student student1 = SampleBuilder.student1();
        studentService.save(student1);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Timetable timetable1 = SampleBuilder.timetable1(students);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2();
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3();
        timeTableService.save(timetable3);

        Timetable timetable4 = SampleBuilder.timetable4(students);
        timeTableService.save(timetable4);

        List<Timetable> timetableWithoutStudent = timeTableService.getTimetableWithoutStudent();

        LocalTime expectedStartTimeT1 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(10, 30);

        LocalTime expectedStartTimeT2 = LocalTime.of(11, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(12, 30);

        assertEquals(2, timetableWithoutStudent.size());
        assertNull(timetableWithoutStudent.get(0).getStudents());
        assertNull(timetableWithoutStudent.get(1).getStudents());
        assertEquals(expectedStartTimeT1, timetableWithoutStudent.get(0).getStart());
        assertEquals(expectedEndTimeT1, timetableWithoutStudent.get(0).getEnd());
        assertEquals(expectedStartTimeT2, timetableWithoutStudent.get(1).getStart());
        assertEquals(expectedEndTimeT2, timetableWithoutStudent.get(1).getEnd());
    }
    /*
    1- add a student to the special timetable
     1-1 aya mohsen ba Id 10 be liste danesh amuzan timetabli ke ijad kardam ezafe shode ya na
    * */

    /*1- create Student -->student:Student //given
      2- set the fields of student
      3- save this student
      4- create a timetable -- > timetable --> Timetable
      5- set the fields of timetable
      6- save this timetable // given
      7- call addStudentToTimetable method // when
      8- read timetable by getById --> timetableById:Timetable //then
      9- read all student of this timetableById --> allStudents: List<Student>
      10- creat a empty variable kind of student--> trueStudent
      11- loop in the allStudents
       11-1 get one of the student -->expectedStudent
         11-1-1 if  Id expectedStudent == Id student
         11-1-2 put in the trueStudent
      12- if trueStudent == null
       12-1- throws an exception
      13- assert trueStudent by firstName and LastName and .....
     */
    @Test
    void addStudentToTimetable() {
        Student student1 = SampleBuilder.student1();
        studentService.save(student1);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(student1);
        allStudents.add(student2);

        Timetable timetable = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable);

        Student student3 = SampleBuilder.student3();
        studentService.save(student3);//"given"

        timeTableService.addStudentToTimetable(timetable.getId(), student3.getId()); //"when"
        Timetable timetableById = timeTableService.getById(timetable.getId());//"then"
        List<Student> students = timetableById.getStudents();

        Student expectedStudent = null;

        for (Student foundStudent : students) {
            if (foundStudent.getId().equals(student3.getId())) {
                expectedStudent = foundStudent;
            }
        }

        LocalTime expectedStartTimeT1 = LocalTime.of(7, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(8, 30);

        assertNotNull(expectedStudent);
        assertEquals(3, timetableById.getStudents().size());
        assertEquals(expectedStartTimeT1, timetable.getStart());
        assertEquals(expectedEndTimeT1, timetable.getEnd());
        assertEquals("Liam", expectedStudent.getFirstName());
        assertEquals("Mansourvar", expectedStudent.getLastName());
        assertEquals("0000000000", expectedStudent.getNationalCode());
        assertEquals("Adelaide", expectedStudent.getAddress());
        assertEquals("0041", expectedStudent.getTelephone()); //"then"
    }

    /*
    1- create and save a student -->student:Student
    2- create a list of student --> students:List<Student>
    3- add student to the list of students
    4- create a Timetable --> timetable1:Timetable
    5- set the fields of timetable and also set the students of timetable1
    6- create a Timetable --> timetable2:Timetable
    7- set the fields of timetable and also set the students of timetable2
    8- create a Timetable --> timetable3:Timetable
    9- set the fields of timetable and also set the students of timetable3
    10- call getTimetablesByStudentId method --> timetablesByStudentId
    11- get 3 cells of list of timetablesByStudentId
    12- assert timetablesByStudentId by date and start and end
    */
    @Test
    void getTimetablesByStudentId() {
        //given
        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable1 = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(allStudents);
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3(allStudents);
        timeTableService.save(timetable3);

        //when
        List<Timetable> timetablesByStudentId = timeTableService.getTimetablesByStudentId(student.getId());

        //then
        Timetable t1 = timetablesByStudentId.get(0);
        Timetable t2 = timetablesByStudentId.get(1);
        Timetable t3 = timetablesByStudentId.get(2);

        LocalTime expectedStartTimeT1 = LocalTime.of(7, 0);
        LocalTime expectedEndTimeT1 = LocalTime.of(8, 30);

        LocalTime expectedStartTimeT2 = LocalTime.of(9, 0);
        LocalTime expectedEndTimeT2 = LocalTime.of(10, 30);

        LocalTime expectedStartTimeT3 = LocalTime.of(11, 0);
        LocalTime expectedEndTimeT3 = LocalTime.of(12, 30);

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

    /*
    1- create a student -->student1:Student
    2- set the fields of student and save
    3- create a student --> student2:Student
    4- set the fields of student and save
    5- create a student --> student3:Student
    6- set the fields of student and save
    7- create a timetable -->timetable:Timetable
    8-set the fields of timetable and specially set these students and save
    9-call getAllStudentsTimetable method -->studentsTimetable:List<Student>
    10- assertion

    */
    @Test
    void getAllStudentsTimetable() {
        Student student1 = SampleBuilder.student1();
        studentService.save(student1);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        Student student3 = SampleBuilder.student3();
        studentService.save(student3);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable);

        List<Student> allStudentsTimetable = timeTableService.getAllStudentsTimetable(timetable.getId());
        Student st1 = allStudentsTimetable.get(0);

        assertNotNull(allStudentsTimetable);
        assertEquals("Mohsen", st1.getFirstName());
        assertEquals("Mansourvar", st1.getLastName());
        assertEquals("3322114455", st1.getNationalCode());
        assertEquals("123", st1.getStudentNumber());
        assertEquals("0041", st1.getTelephone());
        assertEquals("Adelaide", st1.getAddress());
        assertEquals(3, allStudentsTimetable.size());
    }

    @Test
    void registerStudentInTimetableWithoutConflict() {
        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable1 = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(allStudents);
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3(allStudents);
        timeTableService.save(timetable3);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        List<Student> students = new ArrayList<>();
        students.add(student2);

        Timetable timetable4 = SampleBuilder.timetable4(students);
        timeTableService.save(timetable4);

        timeTableService.addStudentToTimetable(timetable4.getId(), student.getId());

        /*List<Timetable> timetablesByStudentId = timeTableService.getTimetablesByStudentId(student.getId());
        Timetable t4 = timetablesByStudentId.get(0);
        List<Student> student1 = t4.getStudents();*/

        List<Student> allStudentsTimetable4 = timeTableService.getAllStudentsTimetable(timetable4.getId());

        LocalTime expectedStartTimetable4 = LocalTime.of(13, 0);
        LocalTime expectedEndTimetable4 = LocalTime.of(14, 30);

        assertNotNull(allStudentsTimetable4);
        assertEquals(2, allStudentsTimetable4.size());
        assertEquals(expectedStartTimetable4, timetable4.getStart());
        assertEquals(expectedEndTimetable4, timetable4.getEnd());
        /*assertEquals("Mohsen", student1.getFirstName());
        assertEquals("Mansourvar", student1.getLastName());
        assertEquals("123", student1.getStudentNumber());
        assertEquals("3322114455", student1.getNationalCode());
        assertEquals("0041", student1.getTelephone());
        assertEquals("Adelaide", student1.getAddress());*/
    }

    @Test
    void registerStudentInTimetableWithConflict() {
        //given
        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable1 = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(allStudents);
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3(allStudents);
        timeTableService.save(timetable3);

        Timetable timetable7 = SampleBuilder.timetable7();
        timeTableService.save(timetable7);
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            timeTableService.addStudentToTimetable(timetable7.getId(), student.getId());
        });
    }

    @Test
    void registerStudentInTimetableWithExactSameStartAndEnd() {
        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable1 = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(allStudents);
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3(allStudents);
        timeTableService.save(timetable3);

        Timetable timetable6 = SampleBuilder.timetable6();
        timeTableService.save(timetable6);

        assertThrows(IllegalArgumentException.class, () -> {
            timeTableService.addStudentToTimetable(timetable6.getId(), student.getId());
        });
    }

    @Test
    void registerStudentInTimetableWithExactSameStartAndEndWithDifferentDate() {
        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable1 = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(allStudents);
        timeTableService.save(timetable2);

        Timetable timetable5 = SampleBuilder.timetable5(allStudents);
        timeTableService.save(timetable5);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        List<Student> students = new ArrayList<>();
        students.add(student2);

        Timetable timetable4 = SampleBuilder.timetable4(students);
        timeTableService.save(timetable4);

        timeTableService.addStudentToTimetable(timetable4.getId(), student.getId());

        /*List<Timetable> timetablesByStudentId = timeTableService.getTimetablesByStudentId(student.getId());
        Timetable t4 = timetablesByStudentId.get(0);
        Student student1 = t4.getStudents().get(1);*/

        List<Student> allStudentsTimetable4 = timeTableService.getAllStudentsTimetable(timetable4.getId());

        LocalTime expectedStartTimetable4 = LocalTime.of(13, 0);
        LocalTime expectedEndTimetable4 = LocalTime.of(14, 30);

        assertNotNull(allStudentsTimetable4);
        assertEquals(2, allStudentsTimetable4.size());
        assertEquals(expectedStartTimetable4, timetable4.getStart());
        assertEquals(expectedEndTimetable4, timetable4.getEnd());
        /*assertEquals("Mohsen", student1.getFirstName());
        assertEquals("Mansourvar", student1.getLastName());
        assertEquals("123", student1.getStudentNumber());
        assertEquals("3322114455", student1.getNationalCode());
        assertEquals("0041", student1.getTelephone());
        assertEquals("Adelaide", student1.getAddress());*/
    }

    @Test
    void getTimetablesByStatus() {
        Timetable timetable1 = SampleBuilder.timetable1();
        timetable1.setStatus(TimetableStatus.ACTIVE);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2();
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3();
        timetable3.setStatus(TimetableStatus.ACTIVE);
        timeTableService.save(timetable3);

        List<Timetable> timetablesByStatus = timeTableService.getTimetablesByStatus(TimetableStatus.ACTIVE);

        assertNotNull(timetablesByStatus);
        assertEquals(2, timetablesByStatus.size());
    }

    @Test
    void activeTimetableStatus() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable = SampleBuilder.timetable1(teacher, allStudents, room1);
        timeTableService.save(timetable);

        timeTableService.activeTimetableStatus(timetable.getId());

        Timetable timetableById = timeTableService.getById(timetable.getId());

        assertNotNull(timetableById);
        assertEquals(TimetableStatus.ACTIVE, timetableById.getStatus());
    }

    @Test
    void deactivateTimetableStatus() {
        Timetable timetable = SampleBuilder.timetable1();
        timeTableService.save(timetable);

        timeTableService.deactivateTimetableStatus(timetable.getId());
        Timetable timetableById = timeTableService.getById(timetable.getId());

        assertNotNull(timetableById);
        assertEquals(TimetableStatus.INACTIVE, timetableById.getStatus());
    }

    @Test
    public void activeTimetableWithClass() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable = SampleBuilder.timetable1(teacher, allStudents, room1);
        timeTableService.save(timetable);

        timeTableService.activeTimetableStatus(timetable.getId());

        Timetable timetableById = timeTableService.getById(timetable.getId());

        assertNotNull(timetableById);
        assertEquals(TimetableStatus.ACTIVE, timetableById.getStatus());
    }

    @Test
    void activeTimetableWithStudent() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable = SampleBuilder.timetable1(teacher, allStudents, room1);
        timeTableService.save(timetable);

        timeTableService.activeTimetableStatus(timetable.getId());

        Timetable timetableById = timeTableService.getById(timetable.getId());

        assertNotNull(timetableById);
        assertEquals(TimetableStatus.ACTIVE, timetableById.getStatus());
    }

    @Test
    void inactiveTimetableCanBeIgnoredToCompareWithAnotherTimetables() {
        Teacher teacher1 = SampleBuilder.teacher1();
        teacherService.save(teacher1);

        Student student1 = SampleBuilder.student1();
        studentService.save(student1);

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(student1);

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Timetable timetable1 = SampleBuilder.timetable1(teacher1, allStudents, room1);
        timeTableService.save(timetable1);

        timeTableService.deactivateTimetableStatus(timetable1.getId());

        Teacher teacher2 = SampleBuilder.teacher2();
        teacherService.save(teacher2);

        Class room2 = SampleBuilder.room2();
        classService.save(room2);

        Timetable timetable2 = SampleBuilder.timetable2(teacher2, allStudents, room2);
        timeTableService.save(timetable2);

        timeTableService.activeTimetableStatus(timetable2.getId());

        Teacher teacher3 = SampleBuilder.teacher2();
        teacherService.save(teacher3);

        Class room3 = SampleBuilder.room3();
        classService.save(room3);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        Timetable timetable6 = SampleBuilder.timetable6(teacher3, allStudents, room3);

        timeTableService.save(timetable6);

        timeTableService.addStudentToTimetable(timetable6.getId(), student2.getId());

        timeTableService.activeTimetableStatus(timetable6.getId());

        List<Timetable> timetablesByStudentId = timeTableService.getTimetablesByStudentId(student1.getId());
        Timetable t3 = timetablesByStudentId.get(0);

        assertNotNull(timetablesByStudentId);
        assertEquals(LocalTime.of(7, 0), t3.getStart());
        assertEquals(LocalTime.of(8, 30), t3.getEnd());
        assertEquals(LocalDate.now(), t3.getDate());
        assertEquals(3, timetablesByStudentId.size());
    }

    @Test
    void activeTimetableCannotActivateAgain() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable = SampleBuilder.timetable1(teacher, allStudents, room1);
        timetable.setStatus(TimetableStatus.ACTIVE);
        timeTableService.save(timetable);

        assertThrows(IllegalArgumentException.class, () -> {
            timeTableService.activeTimetableStatus(timetable.getId());
        });
    }

    @Test
    void inactiveTimetableCannotBeDeactivatedAgain() {
        Timetable timetable = SampleBuilder.timetable1();
        timetable.setStatus(TimetableStatus.INACTIVE);

        timeTableService.save(timetable);

        assertThrows(IllegalArgumentException.class, () -> {
            timeTableService.deactivateTimetableStatus(timetable.getId());
        });
    }

    @Test
    void startTimetable() {
        Teacher teacher1 = SampleBuilder.teacher1();
        teacherService.save(teacher1);

        Student student1 = SampleBuilder.student1();
        studentService.save(student1);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        Student student3 = SampleBuilder.student3();
        studentService.save(student3);

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Timetable timetable1 = SampleBuilder.timetable1(teacher1, allStudents, room1);
        timeTableService.save(timetable1);

        timeTableService.activeTimetableStatus(timetable1.getId());

        timeTableService.startTimetable(timetable1.getId());

        Timetable timetableById = timeTableService.getById(timetable1.getId());

        assertNotNull(timetableById);
        assertEquals(TimetableStatus.STARTED, timetableById.getStatus());
    }

    @Test
    void timetableCannotStartWithLessThanMinimumStudents() {
        Teacher teacher1 = SampleBuilder.teacher1();
        teacherService.save(teacher1);

        Student student1 = SampleBuilder.student1();
        studentService.save(student1);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        Student student3 = SampleBuilder.student3();
        studentService.save(student3);

        List<Student> allStudents = studentService.getAllStudents();

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Timetable timetable1 = SampleBuilder.timetable1(teacher1, allStudents, room1);
        timeTableService.save(timetable1);

        timeTableService.activeTimetableStatus(timetable1.getId());

        timeTableService.startTimetable(timetable1.getId());

        Timetable timetableById = timeTableService.getById(timetable1.getId());

        assertNotNull(timetableById);
        assertEquals(TimetableStatus.STARTED, timetableById.getStatus());
    }

    @Test
    void timetableCannotStartWithMoreThanMaximumStudents() {
        Teacher teacher1 = SampleBuilder.teacher1();
        teacherService.save(teacher1);

        Student student1 = SampleBuilder.student1();
        studentService.save(student1);

        Student student2 = SampleBuilder.student2();
        studentService.save(student2);

        Student student3 = SampleBuilder.student3();
        studentService.save(student3);

        List<Student> allStudents = studentService.getAllStudents();

        Class room1 = SampleBuilder.room1();
        classService.save(room1);

        Timetable timetable1 = SampleBuilder.timetable1(teacher1, allStudents, room1);
        timeTableService.save(timetable1);

        timeTableService.activeTimetableStatus(timetable1.getId());

        timeTableService.startTimetable(timetable1.getId());

        Timetable timetableById = timeTableService.getById(timetable1.getId());

        assertNotNull(timetableById);
        assertEquals(TimetableStatus.STARTED, timetableById.getStatus());
    }

    @Test
    void registerStudentInTimetableInStartStatus() {
        Student student = SampleBuilder.student1();
        studentService.save(student);

        List<Student> allStudents = studentService.getAllStudents();

        Timetable timetable1 = SampleBuilder.timetable1(allStudents);
        timeTableService.save(timetable1);

        Timetable timetable2 = SampleBuilder.timetable2(allStudents);
        timeTableService.save(timetable2);

        Timetable timetable3 = SampleBuilder.timetable3(allStudents);
        timeTableService.save(timetable3);

        Timetable timetable4 = SampleBuilder.timetable4(allStudents);
        timetable4.setStatus(TimetableStatus.STARTED);
        timeTableService.save(timetable4);

        assertThrows(IllegalArgumentException.class, () -> {
            timeTableService.addStudentToTimetable(timetable4.getId(), student.getId());
        });
    }
}
