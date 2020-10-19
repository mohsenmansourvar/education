package com.education.service;

import com.education.domain.Teacher;
import com.education.repository.TeacherRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void update(long id, Teacher newTeacher) {
        Teacher teacher = getById(id);

        if (newTeacher.getFirstName() != null) {
            teacher.setFirstName(newTeacher.getFirstName());
        }
        if (newTeacher.getLastName() != null) {
            teacher.setLastName(newTeacher.getLastName());
        }
        if (newTeacher.getNationalCode() != null) {
            teacher.setNationalCode(newTeacher.getNationalCode());
        }
        if (newTeacher.getSpecialty() != null) {
            teacher.setSpecialty(newTeacher.getSpecialty());
        }
        if (newTeacher.getAddress() != null) {
            teacher.setAddress(newTeacher.getAddress());
        }
        if (newTeacher.getTelephone() != null) {
            teacher.setTelephone(newTeacher.getTelephone());
        }
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Teacher by id"));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
