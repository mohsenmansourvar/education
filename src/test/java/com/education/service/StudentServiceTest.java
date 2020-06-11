package com.education.service;

import com.education.domain.Student;
import com.education.domain.StudentBuilder;
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
        Student student = new StudentBuilder()
                .firstName("Mary")
                .lastName("Ebrahimi")
                .nationalCode("5544332211")
                .studentNumber("231")
                .address("Adelaide")
                .telephone("0041")
                .build();

        studentService.save(student);

        Student studentById = studentService.getById(student.getId());

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getFirstName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("5544332211", studentById.getNationalCode());
        assertEquals("Adelaide", studentById.getAddress());
        assertEquals("231", studentById.getStudentNumber());
        assertEquals("0041", studentById.getTelephone());
    }

    @Test
    public void getAllStudents() {
        Student student1 = new StudentBuilder()
                .firstName("Mary")
                .lastName("Ebrahimi")
                .nationalCode("5544332211")
                .studentNumber("231")
                .address("Adelaide")
                .telephone("0041")
                .build();
        studentService.save(student1);

        Student student2 = new StudentBuilder()
                .firstName("Laim")
                .lastName("Mansourvar")
                .nationalCode("0000000000")
                .studentNumber("111")
                .address("Adelaide")
                .telephone("0049")
                .build();

        studentService.save(student2);

        List<Student> allStudents = studentService.getAllStudents();

        assertNotNull(allStudents);
        assertEquals(2, allStudents.size());
    }
}
