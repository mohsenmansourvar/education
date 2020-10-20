package com.education.repository;

import com.education.domain.Student;
import com.education.domain.Teacher;
import com.education.domain.Timetable;
import com.education.domain.TimetableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    List<Timetable> findByTeacherId(long teacherId);

    @Query("select ti from Timetable ti join ti.students s where s.id = :studentId")
    List<Timetable> findTimetablesByStudentId(@Param("studentId") long studentId);

    @Query("from Timetable ti where ti.teacher.id in (:ids)")
    List<Timetable> findTimetablesByTeacherIds(@Param("ids") List<Long> ids);

    @Query("from Timetable ti where ti.start >= :start And ti.end<= :end And ti.date = :date ")
    List<Timetable> findTimetablesByTimeAndDate(@Param("start") LocalTime start, @Param("end") LocalTime end, @Param("date") LocalDate date);

    List<Timetable> findTimetablesByDate(LocalDate date);

    @Query("from Timetable where teacher is null")
    List<Timetable> findTimetablesWithoutTeacher();

    @Query("select ti from Timetable ti  left join ti.students st where st.id is null")
    List<Timetable> findTimetableWithoutStudent();

    List<Timetable> findTimetablesByStatus(TimetableStatus status);

    @Query("select st from Timetable ti join ti.students st where ti.id = :id")
    List<Student> findAllStudentsTimetable(@Param("id") long id);
}
