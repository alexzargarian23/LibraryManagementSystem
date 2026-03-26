import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private List<Book> books;

    // It's safer to initialize the list in the constructor to avoid NullPointerExceptions
    public Library() {
        this.books = new ArrayList<>();
    }

    public int countOfBooks(String title) {
        int count = 0;
        for (Book book : books) {
            // Use .equalsIgnoreCase for a better user experience!
            if (book.getTitle().equalsIgnoreCase(title)) {
                count++;
            }
        }
        return count;
    }

    public void add(Book book) {
        this.books.add(book);
    }

    // Logic fix: Using an Iterator to safely remove items while looping
    public void removeBook(String title, int countToRemove) {
        Iterator<Book> iterator = books.iterator();
        int removedSoFar = 0;

        while (iterator.hasNext() && removedSoFar < countToRemove) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                removedSoFar++;
            }
        }
    }

    public Book borrowBook(String title) {
        for (Book book : books) {
            // Find the first available copy that isn't already borrowed
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.setBorrowed(true); // Mark it as borrowed instead of deleting it
                return book;
            }
        }
return null;
    }

    public void displayBooks() {
        if(books.isEmpty()) {
            return;
        }
        else{
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    @Override
    public String toString() {
        return "Library{" + "books=" + books + '}';
    }

}