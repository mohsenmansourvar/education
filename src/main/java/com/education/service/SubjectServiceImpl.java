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
        Subject subject = getById(id);

        if (newSubject.getName() != null) {
            subject.setName(newSubject.getName());
        }
        if (newSubject.getUnitNumber() != 0) {
            subject.setUnitNumber(newSubject.getUnitNumber());
        }
        subjectRepository.save(subject);
    }

    @Override
    public void delete(long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject getById(long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Subject by id"));
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
