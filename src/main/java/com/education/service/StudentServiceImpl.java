package com.education.service;

import com.education.domain.Student;
import com.education.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getById(long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }

    @Override
    public void update(long id, Student newStudent) {
        studentRepository.update(id, newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }
}
