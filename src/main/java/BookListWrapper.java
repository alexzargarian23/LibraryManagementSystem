import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "library")
public class BookListWrapper {
    private List<Book> books;

    @XmlElement(name = "book")
    public List<Book> getBooks() { return books; }

    public void setBooks(List<Book> books) { this.books = books; }
}