package com.education.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimetableBuilder {
    Timetable timetable = new Timetable();

    public TimetableBuilder start(LocalTime start) {
        timetable.setStart(start);
        return this;
    }

    public TimetableBuilder end(LocalTime end) {
        timetable.setEnd(end);
        return this;
    }

    public TimetableBuilder date(LocalDate date) {
        timetable.setDate(date);
        return this;
    }

    public TimetableBuilder capacity(int capacity) {
        timetable.setCapacity(capacity);
        return this;
    }

    public Timetable build() {
        return timetable;
    }
}
