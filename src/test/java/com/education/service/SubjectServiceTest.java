package com.education.service;

import com.education.domain.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void update() {
        Subject subject = new Subject();
        subject.setName("Math");
        subject.setUnitNumber(2);
        subjectService.save(subject);
        Long subjectId = subject.getId();

        Subject newSubject = new Subject();
        newSubject.setUnitNumber(3);

        subjectService.update(subjectId, newSubject);

        Subject subjectById = subjectService.getById(subjectId);

        assertNotNull(subjectById);
        assertEquals("Math", subjectById.getName());
        assertEquals(3, subjectById.getUnitNumber());
    }

    @Test
    public void delete() {
        Subject subject = new Subject();
        subject.setName("Math");
        subject.setUnitNumber(2);
        subjectService.save(subject);

        subjectService.delete(subject.getId());

        assertThrows(IllegalArgumentException.class, () -> subjectService.getById(subject.getId()));
    }

    @Test
    public void getAllSubjects() {
        Subject subject = new Subject();
        subject.setName("Math");
        subject.setUnitNumber(3);
        subjectService.save(subject);

        Subject subject1 = new Subject();
        subject1.setName("English");
        subject1.setUnitNumber(2);
        subjectService.save(subject1);

        List<Subject> allSubjects = subjectService.getAllSubjects();

        assertEquals(2, allSubjects.size());
    }
}
