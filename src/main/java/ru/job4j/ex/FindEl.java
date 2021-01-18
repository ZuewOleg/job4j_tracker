package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) {
        int rsl = -1;
        for (String a : value) {
                rsl = a == key ? key : throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] a = {"k", "o", "f"};
        try {
            indexOf(a, "f");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
