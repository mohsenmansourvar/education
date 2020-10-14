package com.education.service;

import com.education.domain.Student;
import com.education.domain.Timetable;
import com.education.domain.TimetableStatus;
import com.education.repository.TimetableRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TimetableServiceImpl implements TimetableService {
    private final TimetableRepository timeTableRepository;
    private final StudentService studentService;

    public TimetableServiceImpl(TimetableRepository timeTableRepository, StudentService studentService) {
        this.timeTableRepository = timeTableRepository;
        this.studentService = studentService;
    }

    @Override
    public void save(Timetable timetable) {
        isTimetableCapacityNegative(timetable);
        timeTableRepository.save(timetable);
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
     * 1-read timetable base on id -->timetable:timetable
     * 2-read all of timetables of this student --> timetablesByStudentId:List<Timetable>
     * 3-loop in the timetablesByStudentId --> timetables
     *  3-1- if the date of timetable equals of date of timetables
     *    3-1-1 if Start timetable is before end of timetables and start of timetable is  after start of timetables or
     *          end of timetable is before end of timetables and end of timetable is after start of timetables
     *      3-1-1-1 throws an exception
     *    3-1-2 else if start of timetable is equal of start of timetables
     *      3-1-2-1 throws an exception END IF
     *
     * 4-if the size of students in timetable is bigger than capacity of timetable
     *  4-1- throws an exception
     * 5-read all students of timetable -->allStudents:List<Students>
     * 6-read a student by getById -->student: Student
     * 7-add studentId to this List
     * 8-set student to the timetable
     * 9-save this timetable
     */
    @Override
    public void addStudentToTimetable(long timetableId, long studentId) {
        Timetable target = getById(timetableId);
        validateStartAndEndOfTimetableWithOtherTimetables(studentId, target);
        validateTargetTimetableCapacity(target);
        addStudentToTargetTimetable(studentId, target);
        timeTableRepository.save(target);
    }

    public void validateStartAndEndOfTimetableWithOtherTimetables(Long studentId, Timetable target) {
        List<Timetable> timetablesByStudentId = getTimetablesByStudentId(studentId);

        for (Timetable timetable : timetablesByStudentId) {
            if (timetable.getStatus().equals(TimetableStatus.INACTIVE)) {
                continue;
            }
            if (target.getDate().equals(timetable.getDate())) {

                boolean startOfTargetBetweenATimetable = target.getStart().isBefore(timetable.getEnd()) && target.getStart().isAfter(timetable.getStart());
                boolean endOfTargetBetweenAnotherATimetable = target.getEnd().isAfter(timetable.getStart()) && target.getEnd().isBefore(timetable.getEnd());

                if (startOfTargetBetweenATimetable || endOfTargetBetweenAnotherATimetable) {
                    throw new IllegalArgumentException("This target has conflict with other timetable");
                } else if (target.getStart().equals(timetable.getStart())) {
                    throw new IllegalArgumentException("there is exactly the same target");
                }
            }
        }
    }


    public void validateTargetTimetableCapacity(Timetable target) {
        boolean isCapacityFull = target.getStudents().size() > target.getMaxStudents();

        if (isCapacityFull) {
            throw new IllegalArgumentException("The capacity of timetable is full");
        }
    }

    public void addStudentToTargetTimetable(Long studentId, Timetable target) {
        if (target.getStatus().equals(TimetableStatus.STARTED)) {
            throw new IllegalArgumentException("In this status, student can not be added to the timetable");
        }
        Student student = studentService.getById(studentId);
        List<Student> students = target.getStudents();
        students.add(student);
        target.setStudents(students);
    }

    @Override
    public List<Student> getAllStudentsTimetable(long id) {
        return timeTableRepository.getAllStudentsTimetable(id);
    }

    @Override
    public List<Timetable> getTimetablesByStatus(TimetableStatus status) {
        return timeTableRepository.getTimetablesByStatus(status);
    }

    @Override
    public void activeTimetableStatus(long id) {
        Timetable timetable = getById(id);
        validateStatusTimetableNotToBeActivateBefore(timetable);
        checkFillingTeacherField(timetable);
        checkFillingClassField(timetable);
        checkFillingStudentField(timetable);
        timetable.setStatus(TimetableStatus.ACTIVE);
        timeTableRepository.update(timetable.getId(), timetable);
    }

    public void validateStatusTimetableNotToBeActivateBefore(Timetable timetable) {

        if (timetable.getStatus().equals(TimetableStatus.ACTIVE)) {
            throw new IllegalArgumentException("Active timetable cannot be Activated again");
        }
    }


    public void checkFillingTeacherField(Timetable timetable) {
        if (timetable.getTeacher() == null) {
            throw new IllegalArgumentException("Cannot activate a timetable without a teacher");
        }
    }

    public void checkFillingClassField(Timetable timetable) {
        if (timetable.getRoom() == null) {
            throw new IllegalArgumentException("Cannot activate a timetable without a class");
        }
    }

    public void checkFillingStudentField(Timetable timetable) {
        if (timetable.getStudents().isEmpty()) {
            throw new IllegalArgumentException("Cannot activate a timetable without a student");
        }
    }

    @Override
    public void deactivateTimetableStatus(long id) {
        Timetable timetable = getById(id);
        if (timetable.getStatus().equals(TimetableStatus.INACTIVE)) {
            throw new IllegalArgumentException("An inactive timetable cannot be deactivated again");
        }
        timetable.setStatus(TimetableStatus.INACTIVE);
        timeTableRepository.update(timetable.getId(), timetable);
    }

    @Override
    public void startTimetable(long id) {
        Timetable timetable = getById(id);
        if (!timetable.getStatus().equals(TimetableStatus.ACTIVE)) {
            throw new IllegalArgumentException("Only active timetables can be started");
        }
        if (timetable.getStudents().size() < timetable.getMinStudents()) {
            throw new IllegalArgumentException("The number of students can not be less than the minimum number");
        }
        if (timetable.getStudents().size() > timetable.getMaxStudents()) {
            throw new IllegalArgumentException("The number of students can not be more than the maximum number");
        }
        timetable.setStatus(TimetableStatus.STARTED);
        timeTableRepository.update(timetable.getId(), timetable);
    }

    public void isTimetableCapacityNegative(Timetable timetable) {
        if (timetable.getMaxStudents() <= 0) {
            throw new IllegalArgumentException("The field of capacity should be full");
        }
    }
}
