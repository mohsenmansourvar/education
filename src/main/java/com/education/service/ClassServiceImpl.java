package com.education.service;

import com.education.domain.Class;
import com.education.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

    @Autowired
    private final ClassRepository classRepository;

    @Transactional
    public void save(Class aClass) {
        classRepository.save(aClass);
    }

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

    @Transactional
    public void delete(long id) {
        classRepository.deleteById(id);
    }

    public Class getById(long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No class by id"));
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }
}
