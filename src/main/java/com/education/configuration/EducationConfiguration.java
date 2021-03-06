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
    public StudentServiceImpl studentService(StudentRepository studentRepository) {
        return new StudentServiceImpl(studentRepository);
    }

    @Bean
    public TeacherServiceImpl teacherService(TeacherRepository teacherRepository) {
        return new TeacherServiceImpl(teacherRepository);

    }

    @Bean
    public SubjectServiceImpl subjectService(SubjectRepository subjectRepository) {
        return new SubjectServiceImpl(subjectRepository);
    }

    @Bean
    public ClassServiceImpl classService(ClassRepository classRepository) {
        return new ClassServiceImpl(classRepository);
    }

    @Bean
    public TimetableServiceImpl timeTableService(TimetableRepository timeTableRepository, StudentService studentService) {
        return new TimetableServiceImpl(timeTableRepository, studentService);
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

    @Bean(name = "entityManagerFactory")
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
