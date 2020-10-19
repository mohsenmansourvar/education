package com.education.service;

import com.education.domain.Class;
import com.education.domain.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SampleBuilder {

    public static Teacher teacher1() {
        return Teacher.builder()
                .firstName("Reza")
                .lastName("Ebrahimi")
                .nationalCode("1122334455")
                .specialty("IT")
                .address("Berlin")
                .telephone("0049")
                .build();

    }

    public static Teacher teacher2() {
        return Teacher.builder()
                .firstName("MAry")
                .lastName("Ebrahimi")
                .nationalCode("5544332211")
                .specialty("English Language")
                .address("Adelaide")
                .telephone("0041")
                .build();
    }

    public static Student student1() {
        return Student.builder()
                .firstName("Mohsen")
                .lastName("Mansourvar")
                .nationalCode("3322114455")
                .studentNumber("123")
                .address("Adelaide")
                .telephone("0041")
                .build();
    }

    public static Student student2() {
        return Student.builder()
                .firstName("Mary")
                .lastName("Ebrahimi")
                .nationalCode("5544332211")
                .studentNumber("231")
                .address("Adelaide")
                .telephone("0041")
                .build();
    }

    public static Student student3() {
        return Student.builder()
                .firstName("Liam")
                .lastName("Mansourvar")
                .nationalCode("0000000000")
                .studentNumber("321")
                .address("Adelaide")
                .telephone("0041")
                .build();
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

    public static Class class1() {
        return Class.builder()
                .classNumber("111")
                .capacity(20)
                .build();
    }

    public static Class class2() {
        return Class.builder()
                .classNumber("222")
                .capacity(20)
                .build();
    }

    public static Class class3() {
        return Class.builder()
                .classNumber("333")
                .capacity(20)
                .build();
    }
}