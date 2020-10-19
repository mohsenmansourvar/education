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
        Student student = getById(id);

        if (newStudent.getFirstName() != null) {
            student.setFirstName(newStudent.getFirstName());
        }
        if (newStudent.getLastName() != null) {
            student.setLastName(newStudent.getLastName());
        }
        if (newStudent.getNationalCode() != null) {
            student.setNationalCode(newStudent.getNationalCode());
        }
        if (newStudent.getAddress() != null) {
            student.setAddress(newStudent.getAddress());
        }
        if (newStudent.getTelephone() != null) {
            student.setTelephone(newStudent.getTelephone());
        }
        if (newStudent.getStudentNumber() == null) {
            student.setStudentNumber(newStudent.getStudentNumber());
        }
        studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No student by id"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
