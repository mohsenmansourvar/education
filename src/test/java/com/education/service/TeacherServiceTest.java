package com.education.service;

import com.education.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void save() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Teacher teacherById = teacherService.getById(teacher.getId());

        assertNotNull(teacherById);
        assertEquals("Reza", teacherById.getFirstName());
        assertEquals("Ebrahimi", teacherById.getLastName());
        assertEquals("1122334455", teacherById.getNationalCode());
        assertEquals("Berlin", teacherById.getAddress());
        assertEquals("0049", teacherById.getTelephone());
    }

    @Test
    public void getById() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Teacher teacherById = teacherService.getById(teacher.getId());

        assertNotNull(teacherById);
        assertEquals("Reza", teacherById.getFirstName());
        assertEquals("Ebrahimi", teacherById.getLastName());
        assertEquals("1122334455", teacherById.getNationalCode());
        assertEquals("Berlin", teacherById.getAddress());
        assertEquals("0049", teacherById.getTelephone());
        assertEquals("IT", teacherById.getSpecialty());
    }

    @Test
    public void update() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        Teacher newTeacher = new Teacher();
        newTeacher.setNationalCode("1111111111");

        teacherService.update(teacher.getId(), newTeacher);

        Teacher teacherById = teacherService.getById(teacher.getId());

        assertNotNull(teacherById);
        assertEquals("Reza", teacherById.getFirstName());
        assertEquals("Ebrahimi", teacherById.getLastName());
        assertEquals("1111111111", teacherById.getNationalCode());
        assertEquals("Berlin", teacherById.getAddress());
        assertEquals("0049", teacherById.getTelephone());
        assertEquals("IT", teacherById.getSpecialty());
    }

    @Test
    public void delete() {
        Teacher teacher = SampleBuilder.teacher1();
        teacherService.save(teacher);

        teacherService.delete(teacher.getId());

        Teacher teacherById = teacherService.getById(teacher.getId());

        assertNull(teacherById);
    }
    @Test
    public void getAllTeachers(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCode("0000000000");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0049");
        teacher.setSpecialty("Programming");
        teacherService.save(teacher);

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Mary");
        teacher1.setLastName("Ebrahimi");
        teacher1.setNationalCode("1111111111");
        teacher1.setAddress("Istanbul");
        teacher1.setTelephone("0090");
        teacher1.setSpecialty("English");
        teacherService.save(teacher1);

        List<Teacher> allTeachers = teacherService.getAllTeachers();

        assertNotNull(allTeachers);
        assertEquals(2,allTeachers.size());
    }
}
