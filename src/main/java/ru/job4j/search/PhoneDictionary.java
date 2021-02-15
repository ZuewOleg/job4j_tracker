package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key, Predicate<Person> combine) {
            ArrayList<Person> result = new ArrayList<>();
            for (Person person : persons) {
                if (combine.test(person)) {
                    result.add(person);
                }
            }
        return result;
    }

    public ArrayList<Person> filter(String key) {
        Predicate<Person> combine = a -> a.getName().contains(key)
                || a.getSurname().contains(key)
                || a.getPhone().contains(key)
                || a.getAddress().contains(key);
        return find(key, combine);
    }
}
