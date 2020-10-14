package com.education.repository;

import com.education.domain.Teacher;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@AllArgsConstructor
public class TeacherRepositoryImpl implements TeacherRepository {

    private final SessionFactory sessionFactory;

    @Override
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public void update(long id, Teacher newTeacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = getById(id);
        if (newTeacher.getFirstName() != null) {
            teacher.setFirstName(newTeacher.getFirstName());
        }
        if (newTeacher.getLastName() != null) {
            teacher.setLastName(newTeacher.getLastName());
        }
        if (newTeacher.getNationalCode() != null) {
            teacher.setNationalCode(newTeacher.getNationalCode());
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

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = getById(id);
        session.delete(teacher);
    }

    @Override
    public Teacher getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Teacher where id= :id", Teacher.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Teacher> getAllTeachers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Teacher", Teacher.class)
                .list();
    }
}
