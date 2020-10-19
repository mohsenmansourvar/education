package com.education.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Timetable {
    @Id
    @GeneratedValue
    private Long id;
    private LocalTime start;
    private LocalTime end;
    private LocalDate date;
    private int minStudents;
    private int maxStudents;
    private TimetableStatus status = TimetableStatus.IN_PROGRESS;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Teacher teacher;
    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @OneToOne
    private Class room;

}
