
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book testBook;
    @BeforeEach
    void setUp() {
        library = new Library();
        testBook = new Book("Test Title", "Author", "123", Category.TECHNOLOGY, 2024, 1, false);
        library.add(testBook);
    }
    @Test
    void addBook() {
        assertEquals(1, library.countOfBooks("Test Title"), "Library should have 1 copy of the book.");

    }
    @Test
    void testBorrowSuccessful() {
        Book borrowed = library.borrowBook("Test Title");
        assertNotNull(borrowed, "The book should be available for borrowing.");
        assertTrue(borrowed.isBorrowed(), "The book's status should be updated to borrowed.");
    }

@Test
    void testBorrowFailed() {
      library.borrowBook("Test Title");
      Book borrowed = library.borrowBook("Test Title");
      assertNull(borrowed, "The book's status should be updated to borrowed.");
}



    @Test
    void testRemoveBook() {
        // 1. Setup: Add a book
        Book tempBook = new Book("Atomic Habits", "James Clear", "999", Category.NON_FICTION, 2018, 1, false);
        library.add(tempBook);

        // 2. Action: Remove the book
        library.removeBook("Atomic Habits", 1);

        // 3. Assert: Check if the count is now 0
        int count = library.countOfBooks("Atomic Habits");
        assertEquals(0, count, "The book count should be 0 after removal.");
    }

}

