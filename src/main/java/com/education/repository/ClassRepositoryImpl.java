package com.education.repository;

import com.education.domain.Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class ClassRepositoryImpl implements ClassRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Class room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
    }

    @Override
    @Transactional(readOnly = true)
    public Class getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Class where id= :id", Class.class)
                .setParameter("id", id)
                .uniqueResult();
    }
}
