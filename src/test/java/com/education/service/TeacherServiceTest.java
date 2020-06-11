package com.education.service;

import com.education.domain.Teacher;
import com.education.domain.TeacherBuilder;
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
        Teacher teacher1 =new TeacherBuilder()
                .firstName("Reza")
                .lastName("Ebrahimi")
                .nationalCode("1122334455")
                .specialty("IT")
                .address("Berlin")
                .telephone("0049")
                .build();

        teacherService.save(teacher1);

        Teacher teacher2 =new TeacherBuilder()
                .firstName("Mary")
                .lastName("Ebrahimi")
                .nationalCode("5544332211")
                .specialty("English language")
                .address("Adelaide")
                .telephone("0041")
                .build();
        teacherService.save(teacher2);

        List<Teacher> allTeachers = teacherService.getAllTeachers();

        assertNotNull(allTeachers);
        assertEquals(2,allTeachers.size());
    }
}
