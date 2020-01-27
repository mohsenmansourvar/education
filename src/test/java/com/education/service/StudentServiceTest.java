package com.education.service;

import com.education.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void save() {
        Student student = new Student();
        student.setFirstName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCode("0000000000");
        student.setStudentNumber("123");
        studentService.save(student);
        Long studentId = student.getId();
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Liam", studentById.getFirstName());
        assertEquals("Mansourvar", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("0000", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCode());
        assertEquals("123",studentById.getStudentNumber());
    }

    @Test
    public void delete() {
        Student student = new Student();
        student.setFirstName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCode("0000000000");
        student.setStudentNumber("111");
        studentService.save(student);
        Long studentId = student.getId();
        studentService.delete(studentId);
        Student studentById = studentService.getById(studentId);

        assertNull(studentById);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setFirstName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCode("0000000000");
        student.setStudentNumber("123");
        studentService.save(student);
        Long studentId = student.getId();

        Student newStudent = new Student();
        newStudent.setFirstName("Mary");
        newStudent.setLastName("Ebrahimi");

        studentService.update(studentId, newStudent);
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getFirstName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("0000", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCode());
        assertEquals("123",studentById.getStudentNumber());
    }

    @Test
    public void getById() {
        Student student = new Student();
        student.setFirstName("Mary");
        student.setLastName("Ebrahimi");
        student.setAddress("Istanbul");
        student.setTelephone("1111");
        student.setNationalCode("1111111111");
        student.setStudentNumber("123");
        studentService.save(student);
        Long studentId = student.getId();
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getFirstName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("1111", studentById.getTelephone());
        assertEquals("1111111111", studentById.getNationalCode());
        assertEquals("123",studentById.getStudentNumber());
    }

    @Test
    public void getAllStudents() {
        Student student = new Student();
        student.setFirstName("Mary");
        student.setLastName("Ebrahimi");
        student.setAddress("Istanbul");
        student.setTelephone("1111");
        student.setNationalCode("1111111111");
        student.setStudentNumber("123");
        studentService.save(student);

        Student student1 = new Student();
        student1.setFirstName("Liam");
        student1.setLastName("Mansourvar");
        student1.setAddress("Istanbul");
        student1.setTelephone("0000");
        student1.setNationalCode("0000000000");
        student1.setStudentNumber("321");
        studentService.save(student1);

        List<Student> allStudents = studentService.getAllStudents();

        assertNotNull(allStudents);
        assertEquals(2, allStudents.size());
    }
}
