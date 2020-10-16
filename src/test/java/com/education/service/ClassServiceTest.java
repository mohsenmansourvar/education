package com.education.service;

import com.education.domain.Class;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@Sql(executionPhase = AFTER_TEST_METHOD, value = "/sql/cleanup.sql")
@SpringBootTest
public class ClassServiceTest {

    @Autowired
    private ClassService classService;

    @Test
    public void save() {
        Class aClass = new Class();
        aClass.setClassNumber("125");
        aClass.setCapacity(45);
        classService.save(aClass);

        Class ClassById = classService.getById(aClass.getId());

        assertNotNull(ClassById);
        assertEquals("125", ClassById.getClassNumber());
        assertEquals(45, ClassById.getCapacity());
    }

    @Test
    public void getById() {
        Class aClass = new Class();
        aClass.setClassNumber("123");
        aClass.setCapacity(12);
        classService.save(aClass);

        Class classById = classService.getById(aClass.getId());

        assertNotNull(classById);
        assertEquals("123", classById.getClassNumber());
        assertEquals(12, classById.getCapacity());
    }

    @Test
    public void delete() {
        Class aClass = new Class();
        aClass.setClassNumber("111");
        aClass.setCapacity(20);
        classService.save(aClass);

        classService.delete(aClass.getId());

        assertThrows(IllegalArgumentException.class, () -> classService.getById(aClass.getId()));
    }

    @Test
    public void update() {
        Class aClass = new Class();
        aClass.setClassNumber("111");
        aClass.setCapacity(20);
        classService.save(aClass);

        Class newClass = new Class();
        newClass.setClassNumber("231");

        classService.update(aClass.getId(), newClass);

        Class classById = classService.getById(aClass.getId());

        assertNotNull(classById);
        assertEquals("231", classById.getClassNumber());
        assertEquals(20, classById.getCapacity());
    }

    @Test
    public void getAllClasses() {
        Class aClass = new Class();
        aClass.setClassNumber("111");
        aClass.setCapacity(20);
        classService.save(aClass);

        Class aClass1 = new Class();
        aClass1.setClassNumber("222");
        aClass1.setCapacity(30);
        classService.save(aClass1);

        List<Class> allClasses = classService.getAllClasses();

        assertNotNull(allClasses);
        assertEquals(2, allClasses.size());
    }
}
