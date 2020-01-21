package com.education.service;

import com.education.domain.Subject;
import com.education.repository.SubjectRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.getAllSubjects();
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public Subject getById(long id) {
        return subjectRepository.getById(id);
    }

    @Override
    public void update(long id, Subject newSubject) {
        subjectRepository.update(id,newSubject);
    }

    @Override
    public void delete(long id) {
        subjectRepository.delete(id);
    }

    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
}
