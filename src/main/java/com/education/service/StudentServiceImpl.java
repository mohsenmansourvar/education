package com.education.service;

import com.education.domain.Student;
import com.education.repository.StudentRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(long id, Student newStudent) {
        studentRepository.update(id, newStudent);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student getById(long id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }
}
