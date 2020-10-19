package com.education.service;

import com.education.domain.Class;
import com.education.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    @Override
    @Transactional
    public Class save(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    @Transactional
    public void update(long id, Class newClass) {
        Class aClass = getById(id);
        if (newClass.getClassNumber() != null) {
            aClass.setClassNumber(newClass.getClassNumber());
        }
        if (newClass.getCapacity() != 0) {
            aClass.setCapacity(newClass.getCapacity());
        }
        classRepository.save(aClass);
    }

    @Override
    @Transactional
    public void delete(long id) {
        classRepository.deleteById(id);
    }

    @Override
    public Class getById(long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No class by id"));
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }
}
