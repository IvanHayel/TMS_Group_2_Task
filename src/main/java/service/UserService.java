package service;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import storage.EntityStorage;

import java.util.List;

@Slf4j
public class UserService {
    private static final EntityStorage<User> userStorage = new EntityStorage<>();

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) instance = new UserService();
        return instance;
    }

    private UserService() {
    }

    public boolean save(User user) {
        log.info("User with id " + user.getId() + " saved");
        return userStorage.save(user);
    }

    public User find(int id) {
        log.info("Searching user with id " + id);
        return userStorage.find(id);
    }

    public User find(String login) {
        log.info("Searching user with login " + login);
        return userStorage.findAll().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);

    }

    public boolean remove(int id) {
        log.info("User with id " + id + " removed");
        return userStorage.remove(id);
    }

    public User update(User user) {
        log.info("User with id " + user.getId() + " updated");
        return userStorage.update(user);
    }

    public boolean isLoginExist(String login) {
        log.info("Checking if login " + login + " exist");
        List<User> users = userStorage.findAll();
        return users.stream()
                .anyMatch(user -> user.getLogin().equals(login));
    }
}