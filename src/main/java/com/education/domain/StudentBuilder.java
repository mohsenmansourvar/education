package com.education.domain;

public class StudentBuilder {
    Student student = new Student();

    public StudentBuilder firstName(String firstName) {
        student.setFirstName(firstName);
        return this;
    }

    public StudentBuilder lastName(String lastName) {
        student.setLastName(lastName);
        return this;
    }

    public StudentBuilder nationalCode(String nationalCode) {
        student.setNationalCode(nationalCode);
        return this;
    }

    public StudentBuilder studentNumber(String studentNumber) {
        student.setStudentNumber(studentNumber);
        return this;
    }

    public StudentBuilder address(String address) {
        student.setAddress(address);
        return this;
    }

    public StudentBuilder telephone(String telephone) {
        student.setTelephone(telephone);
        return this;
    }

    public Student build() {
        return student;
    }
}
