package com.education.repository;

import com.education.domain.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SubjectRepositoryImpl implements SubjectRepository {
    private SessionFactory sessionFactory;

    @Override
    public void save(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.save(subject);
    }

    @Override
    public Subject getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Subject where id = :id", Subject.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
