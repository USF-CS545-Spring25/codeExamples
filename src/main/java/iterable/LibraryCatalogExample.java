package iterable;

import java.util.Iterator;

public class LibraryCatalogExample {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.addBook("The Women", "Kristin Hannah");
        catalog.addBook("The Ministry of Time", "Kaliane Bradley");
        catalog.addBook("X",  "Sue Grafton");

        Iterator<Book> it = catalog.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        // Another way to iterate over books in the catalog - can do it because LibraryCatalog implements Iterable
        for (Book book: catalog) {
            System.out.println(book);
        }
    }
}
