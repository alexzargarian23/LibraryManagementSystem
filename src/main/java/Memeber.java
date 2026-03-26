import java.util.ArrayList;
import java.util.List;

public class Memeber implements User{

    private String  name;
    private List<Book> BarrowedBooks;

    public Memeber(String alex) {
        this.name = alex;
        this.BarrowedBooks = new ArrayList<>();
    }

    @Override
    public int countOfBookBarrowed() {
        return BarrowedBooks.size();
    }

    @Override
    public List<Book> getBarrowedBooks() {
        return BarrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        BarrowedBooks.add(book);
    }
}

