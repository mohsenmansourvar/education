package com.education.service;

import com.education.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void save() {
        Teacher teacher = new Teacher();
        teacher.setName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCode("0000000000");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0049");
        teacherService.save(teacher);
        Long teacherId = teacher.getId();

        Teacher teacherById = teacherService.getById(teacherId);

        assertNotNull(teacherById);
        assertEquals("Reza", teacherById.getName());
        assertEquals("Ebrahimi", teacherById.getLastName());
        assertEquals("0000000000", teacherById.getNationalCode());
        assertEquals("Berlin", teacherById.getAddress());
        assertEquals("0049", teacherById.getTelephone());
    }

    @Test
    public void getById() {
        Teacher teacher = new Teacher();
        teacher.setName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCode("0000000000");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0049");
        teacher.setSpecialty("mathematics");
        teacherService.save(teacher);
        Long teacherId = teacher.getId();

        Teacher teacherById = teacherService.getById(teacherId);

        assertNotNull(teacherById);
        assertEquals("Reza", teacherById.getName());
        assertEquals("Ebrahimi", teacherById.getLastName());
        assertEquals("0000000000", teacherById.getNationalCode());
        assertEquals("Berlin", teacherById.getAddress());
        assertEquals("0049", teacherById.getTelephone());
        assertEquals("mathematics", teacherById.getSpecialty());
    }

    @Test
    public void update() {
        Teacher teacher = new Teacher();
        teacher.setName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCode("0000000000");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0049");
        teacher.setSpecialty("mathematics");
        teacherService.save(teacher);
        Long teacherId = teacher.getId();

        Teacher newTeacher = new Teacher();
        newTeacher.setNationalCode("1111111111");

        teacherService.update(teacherId, newTeacher);

        Teacher teacherById = teacherService.getById(teacherId);

        assertNotNull(teacherById);
        assertEquals("Reza", teacherById.getName());
        assertEquals("Ebrahimi", teacherById.getLastName());
        assertEquals("1111111111", teacherById.getNationalCode());
        assertEquals("Berlin", teacherById.getAddress());
        assertEquals("0049", teacherById.getTelephone());
        assertEquals("mathematics", teacherById.getSpecialty());
    }

    @Test
    public void delete() {
        Teacher teacher = new Teacher();
        teacher.setName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCode("0000000000");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0049");
        teacher.setSpecialty("mathematics");
        teacherService.save(teacher);
        Long teacherId = teacher.getId();

        teacherService.delete(teacherId);

        Teacher teacherById = teacherService.getById(teacherId);

        assertNull(teacherById);
    }
}
