package com.education.service;

import com.education.domain.Student;
import com.education.domain.Teacher;
import com.education.domain.Timetable;

import java.time.LocalDate;
import java.time.LocalTime;

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
        student2.setFirstName("Liam");
        student2.setLastName("Mansourvar");
        student2.setNationalCode("0000000000");
        student2.setStudentNumber("321");
        student2.setAddress("Adelaide");
        student2.setTelephone("0041");
        return student2;
    }

    public static Student student3() {
        Student student3 = new Student();
        student3.setFirstName("Mary");
        student3.setLastName("Ebrahimi");
        student3.setNationalCode("5544332211");
        student3.setStudentNumber("231");
        student3.setAddress("Adelaide");
        student3.setTelephone("0041");
        return student3;
    }

    public static Timetable timetable1() {
        Timetable timetable1 = new Timetable();
        timetable1.setStart(LocalTime.of(7, 0));
        timetable1.setEnd(LocalTime.of(8, 30));
        timetable1.setDate(LocalDate.now());
        timetable1.setCapacity(5);
        return timetable1;
    }

    public static Timetable timetable2() {
        Timetable timetable2 = new Timetable();
        timetable2.setStart(LocalTime.of(9, 0));
        timetable2.setEnd(LocalTime.of(10, 30));
        timetable2.setDate(LocalDate.now());
        timetable2.setCapacity(5);
        return timetable2;
    }

    public static Timetable timetable3() {
        Timetable timetable3 = new Timetable();
        timetable3.setStart(LocalTime.of(11, 0));
        timetable3.setEnd(LocalTime.of(12, 30));
        timetable3.setDate(LocalDate.now());
        timetable3.setCapacity(5);
        return timetable3;
    }

    public static Timetable timetable4() {
        Timetable timetable4 = new Timetable();
        timetable4.setStart(LocalTime.of(13, 0));
        timetable4.setEnd(LocalTime.of(14, 30));
        timetable4.setDate(LocalDate.now());
        timetable4.setCapacity(5);
        return timetable4;
    }

    public static Timetable timetable5() {
        Timetable timetable5 = new Timetable();
        timetable5.setStart(LocalTime.of(7, 0));
        timetable5.setEnd(LocalTime.of(8, 30));
        timetable5.setDate(LocalDate.now().plusDays(1));
        timetable5.setCapacity(5);
        return timetable5;
    }

    public static Timetable timetable6() {
        Timetable timetable6 = new Timetable();
        timetable6.setStart(LocalTime.of(7, 0));
        timetable6.setEnd(LocalTime.of(8, 30));
        timetable6.setDate(LocalDate.now());
        timetable6.setCapacity(5);
        return timetable6;
    }
}