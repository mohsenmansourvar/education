package com.education.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

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
