package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setLogin("Login");
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        actualUser.setSurname("Doe");
        assertEquals("Login", actualUser.getLogin());
        assertEquals("Name", actualUser.getName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Doe", actualUser.getSurname());
    }

    @Test
    void testConstructor2() {
        User actualUser = new User();
        assertNull(actualUser.getSurname());
        assertNull(actualUser.getPassword());
        assertNull(actualUser.getName());
        assertNull(actualUser.getLogin());
    }

    @Test
    void testConstructor3() {
        User actualUser = new User("Login", "iloveyou", "Name", "Doe");

        assertEquals("Doe", actualUser.getSurname());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Name", actualUser.getName());
        assertEquals("Login", actualUser.getLogin());
    }

    @Test
    void testEquals() {
        assertNotEquals(new User(), null);
        assertNotEquals(new User(), "Different type to User");
    }

    @Test
    void testEquals2() {
        User user = new User();
        assertEquals(user, user);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

    @Test
    void testEquals3() {
        User user = new User();
        User user1 = new User();
        assertEquals(user, user1);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user1.hashCode());
    }

    @Test
    void testEquals4() {
        User user = new User("Login", "iloveyou", "Name", "Doe");
        assertNotEquals(user, new User());
    }

    @Test
    void testEquals5() {
        User user = new User();
        assertNotEquals(user, new User("Login", "iloveyou", "Name", "Doe"));
    }

    @Test
    void testEquals6() {
        User user = new User();
        user.setPassword("iloveyou");
        assertNotEquals(user, new User());
    }

    @Test
    void testEquals7() {
        User user = new User();
        user.setName("Name");
        assertNotEquals(user, new User());
    }

    @Test
    void testEquals8() {
        User user = new User();
        user.setSurname("Doe");
        assertNotEquals(user, new User());
    }

    @Test
    void testEquals9() {
        User user = new User("Login", "iloveyou", "Name", "Doe");

        User user1 = new User();
        user1.setLogin("Login");
        assertNotEquals(user, user1);
    }

    @Test
    void testEquals10() {
        User user = new User("Login", "iloveyou", "Name", "Doe");
        User user1 = new User("Login", "iloveyou", "Name", "Doe");

        assertEquals(user, user1);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user1.hashCode());
    }

    @Test
    void testEquals11() {
        User user = new User();

        User user1 = new User();
        user1.setPassword("iloveyou");
        assertNotEquals(user, user1);
    }

    @Test
    void testEquals12() {
        User user = new User();

        User user1 = new User();
        user1.setName("Name");
        assertNotEquals(user, user1);
    }

    @Test
    void testEquals13() {
        User user = new User();

        User user1 = new User();
        user1.setSurname("Doe");
        assertNotEquals(user, user1);
    }
}