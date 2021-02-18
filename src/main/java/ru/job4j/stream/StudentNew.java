package ru.job4j.stream;

import java.util.Objects;

public class StudentNew {
    private String surname;
    private int score;

    public StudentNew(int score, String surname) {
        this.surname = surname;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentNew that = (StudentNew) o;
        return score == that.score
                && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    @Override
    public String toString() {
        return "StudentNew{"
                +
                "score=" + score
                +
                ", surname='" + surname + '\''
                +
                '}';
    }
}
