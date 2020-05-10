package com.education.service;

import com.education.domain.Student;
import com.education.domain.Timetable;
import com.education.repository.TimetableRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimetableServiceImpl implements TimetableService {
    private TimetableRepository timeTableRepository;
    private StudentService studentService;

    @Override
    public void save(Timetable timeTable) {
        timeTableRepository.save(timeTable);
    }

    @Override
    public Timetable getById(long id) {
        return timeTableRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        timeTableRepository.delete(id);
    }

    @Override
    public void update(long id, Timetable newTimetable) {
        timeTableRepository.update(id, newTimetable);
    }

    @Override
    public List<Timetable> getAllTimetables() {
        return timeTableRepository.getAllTimetables();
    }

    @Override
    public List<Timetable> getTimetablesByTeacherId(long teacherId) {
        return timeTableRepository.getTimetablesByTeacherId(teacherId);
    }

    @Override
    public List<Timetable> getTimetablesByStudentId(long studentId) {
        return timeTableRepository.getTimetablesByStudentId(studentId);
    }

    @Override
    public List<Timetable> getTimetablesByTeacherIds(List<Long> ids) {
        if (ids == null) {
            throw new IllegalArgumentException("Ids cannot be null");
        }
        return timeTableRepository.getTimetablesByTeacherIds(ids);
    }

    @Override
    public List<Timetable> getTimetablesByTimeAndDate(LocalTime start, LocalTime end, LocalDate date) {
        return timeTableRepository.getTimetablesByTimeAndDate(start, end, date);
    }

    @Override
    public List<Timetable> getTimetablesByDate(LocalDate date) {
        return timeTableRepository.getTimetablesByDate(date);
    }

    /*
    1- accept one parameter --> ids:List<Long>
    2- read all Timetable --> allTimetables:List<Timetable>
    3- creat List of Timetable -->timetablesWithoutTeacher:List<Timetable> -- > value= null
    4- loop in the allTimetables
      4-1 get one timetable of timetables --> timetable:Timetable
      4-2 if in the timetable teacher didnt set / 1 =/,
       4-2-1 put in the  timetablesWithTeacher
    5- return timetablesWithTeacher

    */
    @Override
    public List<Timetable> getTimetablesWithoutTeacher() {
        return timeTableRepository.getTimetablesWithoutTeacher();
    }

    @Override
    public List<Timetable> getTimetableWithoutStudent() {
        return timeTableRepository.getTimetableWithoutStudent();
    }

    /*
     * 1-accept two parameters --> timetableId,studentId:long
     * 2-read timetable base on id -->timetable:timetable
     * 3-read all students of timetable -->allStudents:List<Students>
     * 3-read a student by getById -->student: Student
     * 4-add studentId to this List
     * 6-set student to the timetable
     * 7- save this timetable
     from Timetable ti join ti.students tis where tis.id =:studentId
        */
    @Override
    public void addStudentToTimetable(long timetableId, long studentId) {
        Timetable timetable = getById(timetableId);
        Student student = studentService.getById(studentId);
        List<Student> students = timetable.getStudents();
        students.add(student);
        timetable.setStudents(students);
        timeTableRepository.save(timetable);
    }

    public void setTimeTableRepository(TimetableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
