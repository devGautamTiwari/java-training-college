package labs.day6.lab1;

import java.util.ArrayList;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

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