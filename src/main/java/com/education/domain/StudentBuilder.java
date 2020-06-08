package com.education.domain;

public class StudentBuilder {
    Student student = new Student();

    public StudentBuilder firstName(String firstName) {
        student.setFirstName(firstName);
        return this;
    }

    public StudentBuilder lastName(String lastName) {
        student.setFirstName(lastName);
        return this;
    }

    public StudentBuilder nationalCode(String nationalCode) {
        student.setFirstName(nationalCode);
        return this;
    }

    public StudentBuilder studentNumber(String studentNumber) {
        student.setFirstName(studentNumber);
        return this;
    }

    public StudentBuilder address(String address) {
        student.setFirstName(address);
        return this;
    }

    public StudentBuilder telephone(String telephone) {
        student.setFirstName(telephone);
        return this;
    }

    public Student build() {
        return student;
    }
}
