package com.education.service;

import com.education.domain.Class;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
@Sql(executionPhase = AFTER_TEST_METHOD, value = "/sql/cleanup.sql")
class ClassServiceTest {

    @Autowired
    private ClassService classService;

    @Test
    void save() {
        Class aClass = new Class();
        aClass.setClassNumber("125");
        aClass.setCapacity(45);
        classService.save(aClass);

        Class classById = classService.getById(aClass.getId());

        assertNotNull(classById);
        assertEquals("125", classById.getClassNumber());
        assertEquals(45, classById.getCapacity());
    }

    @Test
    void getById() {
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
    void delete() {
        Class aClass = new Class();
        aClass.setClassNumber("111");
        aClass.setCapacity(20);
        classService.save(aClass);

        classService.delete(aClass.getId());

        assertThrows(IllegalArgumentException.class, () -> classService.getById(aClass.getId()));
    }

    @Test
    void update() {
        Class aClass = new Class();
        aClass.setClassNumber("111");
        aClass.setCapacity(20);
        classService.save(aClass);
        Long roomId = aClass.getId();

        Class aClass1 = new Class();
        aClass1.setClassNumber("231");

        classService.update(roomId, aClass1);

        Class classById = classService.getById(roomId);

        assertNotNull(classById);
        assertEquals("231", classById.getClassNumber());
        assertEquals(20, classById.getCapacity());
    }

    @Test
    void getAllClasses() {
        Class aClass1 = new Class();
        aClass1.setClassNumber("111");
        aClass1.setCapacity(20);
        classService.save(aClass1);

        Class aClass2 = new Class();
        aClass2.setClassNumber("222");
        aClass2.setCapacity(30);
        classService.save(aClass2);

        List<Class> allClasses = classService.getAllClasses();

        assertNotNull(allClasses);
        assertEquals(2, allClasses.size());
    }
}
