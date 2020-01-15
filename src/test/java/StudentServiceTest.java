import com.education.domain.Student;
import com.education.repository.StudentRepository;
import com.education.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:spring.cfg.xml")
@Transactional
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @Test
    public void save() {
        Student student = new Student();
        student.setName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCod("0000000000");
        studentService.save(student);
        Long studentId = student.getId();
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Liam", studentById.getName());
        assertEquals("Mansourvar", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("0000", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCod());
    }

    @Test
    public void delete() {
        Student student = new Student();
        student.setName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCod("0000000000");
        studentService.save(student);
        Long studentId = student.getId();
        studentService.delete(studentId);
        Student studentById = studentService.getById(studentId);

        assertNull(studentById);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setName("Liam");
        student.setLastName("Mansourvar");
        student.setAddress("Istanbul");
        student.setTelephone("0000");
        student.setNationalCod("0000000000");
        studentService.save(student);
        Long studentId = student.getId();

        Student newStudent = new Student();
        newStudent.setName("Mary");
        newStudent.setLastName("Ebrahimi");

        studentService.update(studentId, newStudent);
        Student studentById = studentService.getById(studentId);

        assertNotNull(studentById);
        assertEquals("Mary", studentById.getName());
        assertEquals("Ebrahimi", studentById.getLastName());
        assertEquals("Istanbul", studentById.getAddress());
        assertEquals("0000", studentById.getTelephone());
        assertEquals("0000000000", studentById.getNationalCod());
    }
}
