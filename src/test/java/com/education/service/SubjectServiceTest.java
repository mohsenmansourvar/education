package com.education.service;

import com.education.domain.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;

    @Test
    public void save() {
        Subject subject = new Subject();
        subject.setName("Math");
        subject.setUnitNumber(3);
        subjectService.save(subject);
        Long subjectId = subject.getId();

        Subject subjectById = subjectService.getById(subjectId);

        assertNotNull(subjectById);
        assertEquals("Math", subjectById.getName());
        assertEquals(3, subjectById.getUnitNumber());
    }

    @Test
    public void getById() {
        Subject subject = new Subject();
        subject.setName("English");
        subject.setUnitNumber(2);
        subjectService.save(subject);
        Long subjectId = subject.getId();

        Subject subjectById = subjectService.getById(subjectId);

        assertNotNull(subjectById);
        assertEquals("English", subjectById.getName());
        assertEquals(2, subjectById.getUnitNumber());
    }
}
