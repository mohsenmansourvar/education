/*
package com.education.repository;

import com.education.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Student studentById = getById(id);
        session.delete(studentById);
    }

    @Override
    public void update(long id, Student newStudent) {
        Session session = sessionFactory.getCurrentSession();
        Student studentId = getById(id);
        if (newStudent.getFirstName() != null) {
            studentId.setFirstName(newStudent.getFirstName());
        }
        if (newStudent.getLastName() != null) {
            studentId.setLastName(newStudent.getLastName());
        }
        if (newStudent.getNationalCode() != null) {
            studentId.setNationalCode(newStudent.getNationalCode());
        }
        if (newStudent.getAddress() != null) {
            studentId.setAddress(newStudent.getAddress());
        }
        if (newStudent.getTelephone() != null) {
            studentId.setTelephone(newStudent.getTelephone());
        }
        session.update(studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student ", Student.class)
                .list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
*/
