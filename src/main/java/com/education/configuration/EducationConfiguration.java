package com.education.configuration;

import com.education.repository.*;
import com.education.service.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class EducationConfiguration {
    @Bean
    public StudentRepositoryImpl studentRepository(SessionFactory sessionFactory) {
        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
        studentRepository.setSessionFactory(sessionFactory);
        return studentRepository;
    }

    @Bean
    public StudentServiceImpl studentService(StudentRepository studentRepository) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentRepository(studentRepository);
        return studentService;
    }

    @Bean
    public TeacherRepositoryImpl teacherRepository(SessionFactory sessionFactory) {
        TeacherRepositoryImpl teacherRepository = new TeacherRepositoryImpl();
        teacherRepository.setSessionFactory(sessionFactory);
        return teacherRepository;
    }

    @Bean
    public TeacherServiceImpl teacherService(TeacherRepository teacherRepository) {
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        teacherService.setTeacherRepository(teacherRepository);
        return teacherService;
    }

    @Bean
    public SubjectRepositoryImpl subjectRepository(SessionFactory sessionFactory) {
        SubjectRepositoryImpl subjectRepository = new SubjectRepositoryImpl();
        subjectRepository.setSessionFactory(sessionFactory);
        return subjectRepository;
    }

    @Bean
    public SubjectServiceImpl subjectService(SubjectRepository subjectRepository) {
        SubjectServiceImpl subjectService = new SubjectServiceImpl();
        subjectService.setSubjectRepository(subjectRepository);
        return subjectService;
    }

    @Bean
    public ClassRepositoryImpl classRepository(SessionFactory sessionFactory) {
        ClassRepositoryImpl classRepository = new ClassRepositoryImpl();
        classRepository.setSessionFactory(sessionFactory);
        return classRepository;
    }

    @Bean
    public ClassServiceImpl classService(ClassRepository classRepository) {
        ClassServiceImpl classService = new ClassServiceImpl();
        classService.setClassRepository(classRepository);
        return classService;
    }

    @Bean
    public TimeTableRepositoryImpl timeTableRepository(SessionFactory sessionFactory) {
        TimeTableRepositoryImpl timeTableRepository = new TimeTableRepositoryImpl();
        timeTableRepository.setSessionFactory(sessionFactory);
        return timeTableRepository;
    }

    @Bean
    public TimeTableServiceImpl timeTableService(TimetableRepository timeTableRepository) {
        TimeTableServiceImpl timeTableService = new TimeTableServiceImpl();
        timeTableService.setTimeTableRepository(timeTableRepository);
        return timeTableService;

    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/education");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }

    @Bean
    public Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource, Properties properties) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("com.education.domain");
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setDataSource(dataSource);
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
}
