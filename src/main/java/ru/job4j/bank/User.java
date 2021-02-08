package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель данных описывает пользователя банка
 */
public class User {
    /**
     * @passport - данные паспорта (серия, номер)
     */
    private String passport;
    /**
     * @username - Ф.И.О пользователя банка
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
