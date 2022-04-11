package service;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private static final UserService TEST_USER_SERVICE = UserService.getInstance();
    private static final User TEST_USER = new User("Login", "Password", "Name", "Surname");

    @BeforeEach
    void init() {
        TEST_USER_SERVICE.save(TEST_USER);
    }

    @Test
    void testGetInstance() {
        assertNotNull(TEST_USER_SERVICE);
    }

    @Test
    void testSave() {
        User userToSave = new User("SaveTest", "Password", "Name", "Surname");
        assertTrue(TEST_USER_SERVICE.save(userToSave));
        assertSame(userToSave, TEST_USER_SERVICE.find(2));
    }

    @Test
    void testFind() {
        assertNotNull(TEST_USER_SERVICE.find(1));
        assertNotNull(TEST_USER_SERVICE.find("Login"));
        assertEquals(1, TEST_USER_SERVICE.find(1).getId());
        assertEquals("Login", TEST_USER_SERVICE.find(1).getLogin());
        assertEquals("Password", TEST_USER_SERVICE.find(1).getPassword());
        assertEquals("Name", TEST_USER_SERVICE.find(1).getName());
        assertEquals("Surname", TEST_USER_SERVICE.find(1).getSurname());
        assertEquals(1, TEST_USER_SERVICE.find("Login").getId());
        assertEquals("Login", TEST_USER_SERVICE.find("Login").getLogin());
        assertEquals("Password", TEST_USER_SERVICE.find("Login").getPassword());
        assertEquals("Name", TEST_USER_SERVICE.find("Login").getName());
        assertEquals("Surname", TEST_USER_SERVICE.find("Login").getSurname());
        assertSame(TEST_USER, TEST_USER_SERVICE.find(1));
        assertSame(TEST_USER, TEST_USER_SERVICE.find("Login"));
    }

    @Test
    void testRemove() {
        assertTrue(TEST_USER_SERVICE.remove(1));
    }

    @Test
    void testUpdate() {
        TEST_USER.setLogin("NewLogin");
        assertSame(TEST_USER, TEST_USER_SERVICE.update(TEST_USER));
        assertEquals("NewLogin", TEST_USER_SERVICE.find(1).getLogin());
    }

    @Test
    void testIsLoginExist() {
        assertTrue(TEST_USER_SERVICE.isLoginExist("Login"));
        assertFalse(TEST_USER_SERVICE.isLoginExist("NotExist"));
    }
}