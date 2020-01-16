import com.education.domain.Student;
import com.education.domain.Teacher;
import com.education.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:spring.cfg.xml")
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void save() {
        Teacher teacher = new Teacher();
        teacher.setName("Reza");
        teacher.setLastName("Ebrahimi");
        teacher.setNationalCod("0000000000");
        teacher.setAddress("Berlin");
        teacher.setTelephone("0049");
        teacherService.save(teacher);
        Long teacherId = teacher.getId();

        Teacher teacherById = teacherService.getById(teacherId);

        assertNotNull(teacherById);
        assertEquals("Reza", teacherById.getName());
        assertEquals("Ebrahimi", teacherById.getLastName());
        assertEquals("0000000000", teacherById.getNationalCod());
        assertEquals("Berlin", teacherById.getAddress());
        assertEquals("0049", teacherById.getTelephone());
    }
}
