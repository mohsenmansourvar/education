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
        Student student = SampleBuilder.student3();
        studentService.save(student);
        Student studentById = studentService.getById(student.getId());

        assertNotNull(studentById);
        assertEquals("Liam", studentById.getFirstName());
        assertEquals("Mansourvar", studentById.getLastName());
        assertEquals("Adelaide", studentById.getAddress());
        assertEquals("0041", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCode());
        assertEquals("321", studentById.getStudentNumber());
    }

    @Test
    public void delete() {
        Student student = SampleBuilder.student3();
        studentService.save(student);
        studentService.delete(student.getId());
        Student studentById = studentService.getById(student.getId());

        assertNull(studentById);
    }

    @Test
    public void update() {
        Student student1 = SampleBuilder.student3();
        studentService.save(student1);

        Student newStudent = new Student();
        newStudent.setFirstName("Mary");
        newStudent.setLastName("Ebrahimi");

        studentService.update(student1.getId(), newStudent);
        Student studentById = studentService.getById(student1.getId());

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getFirstName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("Adelaide", studentById.getAddress());
        assertEquals("0041", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCode());
        assertEquals("321", studentById.getStudentNumber());
    }

    @Test
    public void getById() {
        Student student = SampleBuilder.student2();
        studentService.save(student);
        Long studentId = student.getId();
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getFirstName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("Adelaide", studentById.getAddress());
        assertEquals("0041", studentById.getTelephone());
        assertEquals("5544332211", studentById.getNationalCode());
        assertEquals("231", studentById.getStudentNumber());
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
