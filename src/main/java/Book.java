import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "book")
public class Book{



    private String title;
    private String author;
    private String isbn;
    private Category category;
    private int year;
    private int countOfBook;
    private boolean isBorrowed; // Changed to lowercase 'i'

    public Book(String title, String author, String isbn, Category category, int year, int countOfBook, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.year = year;
        this.countOfBook = countOfBook;
        this.isBorrowed = isBorrowed;
    }
    public Book(){

    }
    @XmlElement
    public String getTitle() {
        return title;
    }
    @XmlElement
    public String getAuthor() {
        return author;
    }
    @XmlElement
    public String getIsbn() {
        return isbn;
    }
    @XmlElement
    public Category getCategory() {
        return category;
    }
    @XmlElement
    public int getYear() {
        return year;
    }
    @XmlElement
    public int getCountOfBook() {
        return countOfBook;
    }
    @XmlElement
    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCountOfBook(int countOfBook) {
        this.countOfBook = countOfBook;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        String status = isBorrowed() ? "[Borrowed]" : "[Available]";
        return String.format("%-15s | %-15s | %-10s | %d | %s",
                title, author, category, year, status);
    }
}