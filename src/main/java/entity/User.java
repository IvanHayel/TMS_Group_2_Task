package entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Entity {
    private static int lastGeneratedId = 0;

    private String login;
    private String password;
    private String name;
    private String surname;

    public User(String login, String password, String name, String surname) {
        this.id = generateNextId();
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User() {
        this(null, null, null, null);
    }

    private static int generateNextId() {
        return ++lastGeneratedId;
    }
}