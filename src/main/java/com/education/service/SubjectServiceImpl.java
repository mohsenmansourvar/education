package com.education.service;

import com.education.domain.Subject;
import com.education.repository.SubjectRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void update(long id, Subject newSubject) {
        subjectRepository.update(id, newSubject);
    }

    @Override
    public void delete(long id) {
        subjectRepository.delete(id);
    }

    @Override
    public Subject getById(long id) {
        return subjectRepository.getById(id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.getAllSubjects();
    }
}
