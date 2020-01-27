package com.education.repository;

import com.education.domain.Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Class room = getById(id);
        session.delete(room);
    }

    @Override
    public void update(long id, Class newRoom) {
        Session session = sessionFactory.getCurrentSession();
        Class room = getById(id);
        if (newRoom.getClassNumber() != null) {
            room.setClassNumber(newRoom.getClassNumber());
        }
        if (newRoom.getCapacity() != 0) {
            room.setCapacity(newRoom.getCapacity());
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
