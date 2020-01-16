package com.education.domain;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String nationalCod;
    private String address;
    private String telephone;
    private String Specialty;
    @ManyToOne
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCod() {
        return nationalCod;
    }

    public void setNationalCod(String nationalCod) {
        this.nationalCod = nationalCod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
