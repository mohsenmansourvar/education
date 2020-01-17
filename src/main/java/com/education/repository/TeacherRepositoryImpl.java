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
        return session.createQuery("from Teacher where id= :id", Teacher.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void update(long id, Teacher newTeacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = getById(id);
        if (newTeacher.getName() != null) {
            teacher.setName(newTeacher.getName());
        }
        if (newTeacher.getLastName() != null) {
            teacher.setLastName(newTeacher.getLastName());
        }
        if (newTeacher.getNationalCod() != null) {
            teacher.setNationalCod(newTeacher.getNationalCod());
        }
        if (newTeacher.getSpecialty() != null) {
            teacher.setSpecialty(newTeacher.getSpecialty());
        }
        if (newTeacher.getAddress() != null) {
            teacher.setAddress(newTeacher.getAddress());
        }
        if (newTeacher.getTelephone() != null) {
            teacher.setTelephone(newTeacher.getTelephone());
        }
        session.update(teacher);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
