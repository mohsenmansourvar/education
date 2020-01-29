package com.education.repository;

import com.education.domain.Timetable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
