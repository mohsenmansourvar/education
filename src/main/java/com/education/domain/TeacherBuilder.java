package com.education.domain;

public class TeacherBuilder {
    Teacher teacher = new Teacher();

    public TeacherBuilder firstName(String firstName) {
        teacher.setFirstName(firstName);
        return this;
    }

    public TeacherBuilder lastName(String lastName) {
        teacher.setLastName(lastName);
        return this;
    }

    public TeacherBuilder nationalCode(String nationalCode) {
        teacher.setNationalCode(nationalCode);
        return this;
    }

    public TeacherBuilder specialty(String specialty) {
        teacher.setSpecialty(specialty);
        return this;
    }

    public TeacherBuilder address(String address) {
        teacher.setAddress(address);
        return this;
    }

    public TeacherBuilder telephone(String telephone) {
        teacher.setTelephone(telephone);
        return this;
    }

    public Teacher build() {
        return teacher;
    }
}
