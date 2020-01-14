package com.education.repository;

import com.education.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    private SessionFactory sessionFactory;

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student where id = :id", Student.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
