package com.education.repository;

import com.education.domain.Timetable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TimeTableRepositoryImpl implements TimetableRepository {
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
        if (newTimetable.getSubject() != null) {
            timetable.setSubject(newTimetable.getSubject());
        }
        if (newTimetable.getTeacher() != null) {
            timetable.setTeacher(newTimetable.getTeacher());
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
    public List<Timetable> getTimetabgitlesByTeacherId(long teacherId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable ti where ti.teacher= :id", Timetable.class)
                .setParameter("id", teacherId)
                .list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
