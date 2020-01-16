package com.education.repository;

import com.education.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TeacherRepositoryImpl implements TeacherRepository {
    private SessionFactory sessionFactory;

    @Override
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public Teacher getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Teacher where id= :id",Teacher.class)
                .setParameter("id",id)
                .uniqueResult();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
