/*
package com.education.repository;

import com.education.domain.Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class ClassRepositoryImpl implements ClassRepository {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Class aClass) {
        Session session = sessionFactory.getCurrentSession();
        session.save(aClass);
    }

    @Override
    @Transactional(readOnly = true)
    public Class getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Class where id= :id", Class.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Class room = getById(id);
        session.delete(room);
    }

    @Override
    public void update(long id, Class newClass) {
        Session session = sessionFactory.getCurrentSession();
        Class room = getById(id);
        if (newClass.getClassNumber() != null) {
            room.setClassNumber(newClass.getClassNumber());
        }
        if (newClass.getCapacity() != 0) {
            room.setCapacity(newClass.getCapacity());
        }
        session.update(room);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Class> getAllRooms() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Class ", Class.class)
                .list();
    }
}
*/
