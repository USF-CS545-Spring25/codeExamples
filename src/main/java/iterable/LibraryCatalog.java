package iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class LibraryCatalog implements Iterable<Book> {
    private ArrayList<Book> books;

    LibraryCatalog() {
        books = new ArrayList<>();
    }

    public void addBook(String name, String author) {
        Book book = new Book(name, author);
        books.add(book);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            sb.append(books.get(i));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }


    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}
