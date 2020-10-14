package com.education.repository;

import com.education.domain.Student;
import com.education.domain.Timetable;
import com.education.domain.TimetableStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
public class TimetableRepositoryImpl implements TimetableRepository {
    private SessionFactory sessionFactory;

    @Override
    public void save(Timetable timeTable) {
        Session session = sessionFactory.getCurrentSession();
        session.save(timeTable);
    }

    @Transactional(readOnly = true)
    @Override
    public Timetable getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable where id= :id", Timetable.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Timetable timetable = getById(id);
        session.delete(timetable);
    }

    @Override
    public void update(long id, Timetable newTimetable) {
        Session session = sessionFactory.getCurrentSession();
        Timetable timetable = getById(id);
        if (newTimetable.getStart() != null) {
            timetable.setStart(newTimetable.getStart());
        }
        if (newTimetable.getEnd() != null) {
            timetable.setEnd(newTimetable.getEnd());
        }
        if (newTimetable.getDate() != null) {
            timetable.setDate(newTimetable.getDate());
        }
        if (newTimetable.getStudents() != null) {
            timetable.setStudents(newTimetable.getStudents());
        }
        if (newTimetable.getMaxStudents() != 0) {
            timetable.setMaxStudents(newTimetable.getMaxStudents());
        }
        if (newTimetable.getSubject() != null) {
            timetable.setSubject(newTimetable.getSubject());
        }
        if (newTimetable.getTeacher() != null) {
            timetable.setTeacher(newTimetable.getTeacher());
        }
        if (newTimetable.getStatus() != null) {
            timetable.setStatus(newTimetable.getStatus());
        }
        session.update(timetable);
    }

    @Override
    public List<Timetable> getAllTimetables() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable ", Timetable.class)
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Timetable> getTimetablesByTeacherId(long teacherId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable ti where ti.teacher.id= :id", Timetable.class)
                .setParameter("id", teacherId)
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Timetable> getTimetablesByStudentId(long studentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select ti from Timetable ti join ti.students s where s.id = :studentId", Timetable.class)
                .setParameter("studentId", studentId)
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Timetable> getTimetablesByTeacherIds(List<Long> ids) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable ti where ti.teacher.id in (:ids)", Timetable.class)
                .setParameter("ids", ids)
                .list();
    }

    @Override
    public List<Timetable> getTimetablesByTimeAndDate(LocalTime start, LocalTime end, LocalDate date) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable ti where ti.start >= :start And ti.end<= :end And ti.date = :date ", Timetable.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .setParameter("date", date)
                .list();
    }

    @Override
    public List<Timetable> getTimetablesByDate(LocalDate date) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable where date = :date", Timetable.class)
                .setParameter("date", date)
                .list();
    }

    @Override
    public List<Timetable> getTimetablesWithoutTeacher() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable where teacher is null ", Timetable.class)
                .list();
    }

    @Override
    public List<Timetable> getTimetableWithoutStudent() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select ti from Timetable ti  left join ti.students st where st.id is null", Timetable.class)
                .list();
    }

    @Override
    public List<Student> getAllStudentsTimetable(long id) {
        Session session = sessionFactory.getCurrentSession();
        //"select  s.id , s.name , s.last name from timetable t join student_timetable st on t.id = st.timetableId join Student s on s.id = st.studentId
        return session.createQuery("select st from Timetable ti join ti.students st where ti.id = :id", Student.class)
                .setParameter("id", id)
                .list();
    }

    @Override
    public List<Timetable> getTimetablesByStatus(TimetableStatus status) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable where status = :status ", Timetable.class)
                .setParameter("status", status)
                .list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
