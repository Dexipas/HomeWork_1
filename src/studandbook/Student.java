package studandbook;

import java.util.List;

public class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books){
        this.name = name;
        this.books = books;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
