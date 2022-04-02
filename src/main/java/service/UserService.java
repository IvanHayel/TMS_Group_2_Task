package service;

import entity.User;
import storage.EntityStorage;

import java.util.List;

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
        return userStorage.save(user);
    }

    public User find(int id) {
        return userStorage.find(id);
    }

    public User find(String login){
        return userStorage.findAll().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);

    }

    public boolean remove(int id) {
        return userStorage.remove(id);
    }

    public User update(User user) {
        return userStorage.update(user);
    }

    public boolean isLoginExist(String login) {
        List<User> users = userStorage.findAll();
        return users.stream()
                .anyMatch(user -> user.getLogin().equals(login));
    }
}