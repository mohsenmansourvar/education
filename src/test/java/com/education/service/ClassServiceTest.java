package com.education.service;

import com.education.domain.Class;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
