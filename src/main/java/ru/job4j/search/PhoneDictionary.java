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
            for (var person : persons) {
                if (combine.test(person)) {
                    result.add(person);
                }
            }
        return result;
    }

    public ArrayList<Person> filter(String key) {
        Predicate<Person> name = a -> a.getName().contains(key);
        Predicate<Person> surname = a -> a.getSurname().contains(key);
        Predicate<Person> phone = a -> a.getPhone().contains(key);
        Predicate<Person> address = a -> a.getAddress().contains(key);
        Predicate<Person> combine = name.or(surname.or(phone.or(address)));
        return find(key, combine);
    }
}
