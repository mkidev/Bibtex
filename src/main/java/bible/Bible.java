package bible;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by marcel on 12.02.2015.
 */
public class Bible {
    private String biblename;
    private SortedSet<Book> books;

    public Bible() {
        books = new TreeSet<>(Comparator.comparingInt(Book::getBnumber));
    }
    public boolean addBook(Book book) {
        return books.add(book);
    }

    public String getBiblename() {
        return biblename;
    }

    public void setBiblename(String biblename) {
        this.biblename = biblename;
    }

    public SortedSet<Book> getBooks() {
        return books;
    }

    public void setBooks(SortedSet<Book> books) {
        this.books = books;
    }
}
