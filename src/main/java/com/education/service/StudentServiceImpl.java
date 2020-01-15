package com.education.service;

import com.education.domain.Student;
import com.education.repository.StudentRepository;
import com.education.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

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
}
