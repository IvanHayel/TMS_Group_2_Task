package service.user;

import entity.User;

public interface UserService {
    boolean save(User user);

    User get(int id);

    User get(String login);

    User update(User user);

    boolean delete(int id);

    boolean isLoginExist(String login);
}
