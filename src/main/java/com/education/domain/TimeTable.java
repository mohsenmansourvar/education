package com.education.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
public class TimeTable {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalTime from;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalTime to;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Teacher teacher;
    @ManyToMany
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeTable)) return false;
        TimeTable timeTable = (TimeTable) o;
        return Objects.equals(from, timeTable.from) &&
                Objects.equals(to, timeTable.to) &&
                Objects.equals(date, timeTable.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, date);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
