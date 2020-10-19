package com.education.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String studentNumber;
    private String address;
    private String telephone;
}
