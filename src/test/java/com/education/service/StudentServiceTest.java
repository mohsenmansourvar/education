package com.education.service;

import com.education.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void save() {
        Student student = new Student();
        student.setName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCode("0000000000");
        studentService.save(student);
        Long studentId = student.getId();
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Liam", studentById.getName());
        assertEquals("Mansourvar", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("0000", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCode());
    }

    @Test
    public void delete() {
        Student student = new Student();
        student.setName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCode("0000000000");
        studentService.save(student);
        Long studentId = student.getId();
        studentService.delete(studentId);
        Student studentById = studentService.getById(studentId);

        assertNull(studentById);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCode("0000000000");
        studentService.save(student);
        Long studentId = student.getId();

        Student newStudent = new Student();
        newStudent.setName("Mary");
        newStudent.setLastName("Ebrahimi");

        studentService.update(studentId, newStudent);
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("0000", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCode());
    }

    @Test
    public void getById() {
        Student student = new Student();
        student.setName("Mary");
        student.setLastName("Ebrahimi");
        student.setAddress("Istanbul");
        student.setTelephone("1111");
        student.setNationalCode("1111111111");
        studentService.save(student);
        Long studentId = student.getId();
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("1111", studentById.getTelephone());
        assertEquals("1111111111", studentById.getNationalCode());
    }
}
