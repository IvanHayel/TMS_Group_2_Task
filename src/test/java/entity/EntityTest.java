package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityTest {
    @Test
    void testGetId() {
        assertEquals(1, new User().getId());
    }

    @Test
    void testSetId() {
        User user = new User();
        user.setId(333);
        assertEquals(333, user.getId());
    }
}

