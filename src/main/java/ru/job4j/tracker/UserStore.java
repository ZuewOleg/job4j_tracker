package ru.job4j.tracker;

public class UserStore {
    public static void main(String[] args) {
        User user = new User(1, "root", "root");
        System.out.println(user);
        System.out.println("User: " + "id - "
                + user.getId() + ", " + "username - "
                + user.getUsername() + ", " + "password - "
                + user.getPassword()
        );
    }
}
