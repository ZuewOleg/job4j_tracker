package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 183);
        Book second = new Book("History", 276);
        Book third = new Book("War and peace", 999999);
        Book four = new Book("Wii", 223);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = four;
        System.out.println("1. Выведите содержимое массива на консоль");
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getPages());
        }
        System.out.println(" ");
        System.out.println("2. Переставьте местами книги с индексом 0 и 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getPages());
        }
        System.out.println(" ");
        System.out.println("3. Добавьте цикл с выводом книг с именем \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            if ("Clean code".equals(pr.getName())) {
                System.out.println(pr.getName());
            }
        }
    }
}
