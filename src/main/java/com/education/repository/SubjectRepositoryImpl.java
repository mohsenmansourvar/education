package com.education.repository;

import com.education.domain.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SubjectRepositoryImpl implements SubjectRepository {
    private SessionFactory sessionFactory;

    @Override
    public void save(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.save(subject);
    }

    @Transactional(readOnly = true)
    @Override
    public Subject getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Subject where id = :id", Subject.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void update(long id, Subject newSubject) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = getById(id);
        if (newSubject.getName() != null) {
            subject.setName(newSubject.getName());
        }
        if (newSubject.getUnitNumber() != 0) {
            subject.setUnitNumber(newSubject.getUnitNumber());
        }
        session.update(subject);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = getById(id);
        session.delete(subject);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Subject> getAllSubjects() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Subject",Subject.class)
                .list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
