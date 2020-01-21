package com.education.service;

import com.education.domain.Subject;
import com.education.repository.SubjectRepository;

public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;

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

    public void setSubjectRepository(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
}
