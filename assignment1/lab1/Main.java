package assignment1.lab1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1, "Atomic Habits", "James Clear");
        Book book2 = new Book(2, "You can win", "Shiv Khera");

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
