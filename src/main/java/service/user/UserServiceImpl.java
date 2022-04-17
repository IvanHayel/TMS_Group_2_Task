package service.user;

import entity.User;
import storage.EntityStorage;
import storage.EntityStorageImpl;

import java.util.ArrayList;
import java.util.Collection;

public class UserServiceImpl implements UserService {
    private static final Collection<User> DEFAULT_USER_STORAGE_COLLECTION = new ArrayList<>();
    private static final EntityStorage<User> USER_STORAGE = new EntityStorageImpl<>(DEFAULT_USER_STORAGE_COLLECTION);

    private static UserServiceImpl instance;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) instance = new UserServiceImpl();
        return instance;
    }

    @Override
    public boolean save(User user) {
        return USER_STORAGE.save(user);
    }

    @Override
    public User get(int id) {
        return USER_STORAGE.getEntityById(id);
    }

    @Override
    public User get(String login) {
        return USER_STORAGE.getAll().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean delete(int id) {
        return USER_STORAGE.deleteEntityById(id);
    }

    @Override
    public User update(User user) {
        return USER_STORAGE.updateEntity(user);
    }

    @Override
    public boolean isLoginExist(String login) {
        return USER_STORAGE.getAll().stream()
                .anyMatch(user -> user.getLogin().equals(login));
    }
}