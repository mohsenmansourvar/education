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

        assertThrows(IllegalArgumentException.class, () -> teacherService.getById(teacher.getId()));
    }

    @Test
    public void getAllTeachers() {
        Teacher teacher1 = SampleBuilder.teacher1();

        teacherService.save(teacher1);

        Teacher teacher2 = SampleBuilder.teacher2(); // TeacherBuilder

        teacherService.save(teacher2);

        List<Teacher> allTeachers = teacherService.getAllTeachers();

        assertNotNull(allTeachers);
        assertEquals(2, allTeachers.size());
    }
}
