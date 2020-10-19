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
        Class class1 = SampleBuilder.class1();

        classService.save(class1);

        Class ClassById = classService.getById(class1.getId());

        assertNotNull(ClassById);
        assertEquals("111", ClassById.getClassNumber());
        assertEquals(20, ClassById.getCapacity());
    }

    @Test
    public void getById() {
        Class class1 = SampleBuilder.class1();

        classService.save(class1);

        Class classById = classService.getById(class1.getId());

        assertNotNull(classById);
        assertEquals("111", classById.getClassNumber());
        assertEquals(20, classById.getCapacity());
    }

    @Test
    public void delete() {
        Class class1 = SampleBuilder.class1();

        classService.save(class1);

        classService.delete(class1.getId());

        assertThrows(IllegalArgumentException.class, () -> classService.getById(class1.getId()));
    }

    @Test
    public void update() {
        Class class1 = SampleBuilder.class1();

        classService.save(class1);

        Class newClass = new Class();
        newClass.setClassNumber("231");

        classService.update(class1.getId(), newClass);

        Class classById = classService.getById(class1.getId());

        assertNotNull(classById);
        assertEquals("231", classById.getClassNumber());
        assertEquals(20, classById.getCapacity());
    }

    @Test
    public void getAllClasses() {
        Class class1 = SampleBuilder.class1();

        classService.save(class1);

        Class class2 = SampleBuilder.class2();

        classService.save(class2);

        List<Class> allClasses = classService.getAllClasses();

        assertNotNull(allClasses);
        assertEquals(2, allClasses.size());
    }
}
