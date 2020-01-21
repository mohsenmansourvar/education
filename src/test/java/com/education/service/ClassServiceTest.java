package com.education.service;

import com.education.domain.Class;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ClassServiceTest {
    @Autowired
    private ClassService classService;

    @Test
    public void save() {
        Class room = new Class();
        room.setRoomNumber("125");
        room.setCapacity(45);
        classService.save(room);
        Long roomId = room.getId();

        Class roomById = classService.getById(roomId);

        assertNotNull(roomById);
        assertEquals("125", roomById.getRoomNumber());
        assertEquals(45, roomById.getCapacity());
    }

    @Test
    public void getById() {
        Class room = new Class();
        room.setRoomNumber("123");
        room.setCapacity(12);
        classService.save(room);
        Long roomId = room.getId();

        Class roomById = classService.getById(roomId);

        assertNotNull(roomById);
        assertEquals("123", roomById.getRoomNumber());
        assertEquals(12, roomById.getCapacity());
    }

    @Test
    public void delete() {
        Class room = new Class();
        room.setRoomNumber("111");
        room.setCapacity(20);
        classService.save(room);
        Long roomId = room.getId();

        classService.delete(roomId);

        Class roomById = classService.getById(roomId);

        assertNull(roomById);
    }
}
