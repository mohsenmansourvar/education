package com.education.service;

import com.education.domain.*;
import com.education.domain.Class;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class SampleBuilder {
    public static Teacher teacher1() {
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Reza");
        teacher1.setLastName("Ebrahimi");
        teacher1.setNationalCode("1122334455");
        teacher1.setSpecialty("IT");
        teacher1.setAddress("Berlin");
        teacher1.setTelephone("0049");
        return teacher1;
    }

    public static Teacher teacher2() {
        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("MAry");
        teacher2.setLastName("Ebrahimi");
        teacher2.setNationalCode("5544332211");
        teacher2.setSpecialty("English Language");
        teacher2.setAddress("Adelaide");
        teacher2.setTelephone("0041");
        return teacher2;
    }

    public static Student student1() {
        Student student1 = new Student();
        student1.setFirstName("Mohsen");
        student1.setLastName("Mansourvar");
        student1.setNationalCode("3322114455");
        student1.setStudentNumber("123");
        student1.setAddress("Adelaide");
        student1.setTelephone("0041");
        return student1;
    }

    public static Student student2() {
        Student student2 = new Student();
        student2.setFirstName("Mary");
        student2.setLastName("Ebrahimi");
        student2.setNationalCode("5544332211");
        student2.setStudentNumber("231");
        student2.setAddress("Adelaide");
        student2.setTelephone("0041");
        return student2;
    }

    public static Student student3() {
        Student student3 = new Student();
        student3.setFirstName("Liam");
        student3.setLastName("Mansourvar");
        student3.setNationalCode("0000000000");
        student3.setStudentNumber("321");
        student3.setAddress("Adelaide");
        student3.setTelephone("0041");
        return student3;
    }

    public static Timetable timetable1() {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable1(Teacher teacher) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable1(List<Student> students) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .students(students)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable1(Class room) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable1(Teacher teacher, List<Student> students, Class room) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .students(students)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable2() {
        return Timetable.builder()
                .start(LocalTime.of(9, 0))
                .end(LocalTime.of(10, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable2(Teacher teacher) {
        return Timetable.builder()
                .start(LocalTime.of(9, 0))
                .end(LocalTime.of(10, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable2(List<Student> students) {
        return Timetable.builder()
                .start(LocalTime.of(9, 0))
                .end(LocalTime.of(10, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .students(students)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable2(Class room) {
        return Timetable.builder()
                .start(LocalTime.of(9, 0))
                .end(LocalTime.of(10, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable2(Teacher teacher, List<Student> students, Class room) {
        return Timetable.builder()
                .start(LocalTime.of(9, 0))
                .end(LocalTime.of(10, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .students(students)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable3() {
        return Timetable.builder()
                .start(LocalTime.of(11, 0))
                .end(LocalTime.of(12, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable3(Teacher teacher) {
        return Timetable.builder()
                .start(LocalTime.of(11, 0))
                .end(LocalTime.of(12, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable3(List<Student> students) {
        return Timetable.builder()
                .start(LocalTime.of(11, 0))
                .end(LocalTime.of(12, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .students(students)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable3(Class room) {
        return Timetable.builder()
                .start(LocalTime.of(11, 0))
                .end(LocalTime.of(12, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable3(Teacher teacher, List<Student> students, Class room) {
        return Timetable.builder()
                .start(LocalTime.of(11, 0))
                .end(LocalTime.of(12, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .students(students)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable4() {
        return Timetable.builder()
                .start(LocalTime.of(13, 0))
                .end(LocalTime.of(14, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable4(Teacher teacher) {
        return Timetable.builder()
                .start(LocalTime.of(13, 0))
                .end(LocalTime.of(14, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable4(List<Student> students) {
        return Timetable.builder()
                .start(LocalTime.of(13, 0))
                .end(LocalTime.of(14, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .students(students)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable4(Class room) {
        return Timetable.builder()
                .start(LocalTime.of(13, 0))
                .end(LocalTime.of(14, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable4(Teacher teacher, List<Student> students, Class room) {
        return Timetable.builder()
                .start(LocalTime.of(13, 0))
                .end(LocalTime.of(14, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .students(students)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable5() {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now().plusDays(1))
                .minStudents(3)
                .maxStudents(5)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable5(Teacher teacher) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now().plusDays(1))
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable5(List<Student> students) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now().plusDays(1))
                .minStudents(3)
                .maxStudents(5)
                .students(students)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable5(Class room) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now().plusDays(1))
                .minStudents(3)
                .maxStudents(5)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable5(Teacher teacher, List<Student> students, Class room) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now().plusDays(1))
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .students(students)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable6() {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable6(Teacher teacher) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable6(List<Student> students) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .students(students)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable6(Class room) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable6(Teacher teacher, List<Student> students, Class room) {
        return Timetable.builder()
                .start(LocalTime.of(7, 0))
                .end(LocalTime.of(8, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .students(students)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable7() {
        return Timetable.builder()
                .start(LocalTime.of(6, 0))
                .end(LocalTime.of(7, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable7(Teacher teacher) {
        return Timetable.builder()
                .start(LocalTime.of(6, 0))
                .end(LocalTime.of(7, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable7(List<Student> students) {
        return Timetable.builder()
                .start(LocalTime.of(6, 0))
                .end(LocalTime.of(7, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .students(students)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable7(Class room) {
        return Timetable.builder()
                .start(LocalTime.of(6, 0))
                .end(LocalTime.of(7, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Timetable timetable7(Teacher teacher, List<Student> students, Class room) {
        return Timetable.builder()
                .start(LocalTime.of(6, 0))
                .end(LocalTime.of(7, 30))
                .date(LocalDate.now())
                .minStudents(3)
                .maxStudents(5)
                .teacher(teacher)
                .students(students)
                .room(room)
                .status(TimetableStatus.IN_PROGRESS)
                .build();
    }

    public static Class room1() {
        Class room1 = new Class();
        room1.setClassNumber("111");
        room1.setCapacity(20);
        return room1;
    }

    public static Class room2() {
        Class room2 = new Class();
        room2.setClassNumber("222");
        room2.setCapacity(20);
        return room2;
    }

    public static Class room3() {
        Class room3 = new Class();
        room3.setClassNumber("222");
        room3.setCapacity(20);
        return room3;
    }
}