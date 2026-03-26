import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);

        // 1. Seed some data so the library isn't empty
        myLibrary.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", Category.FICTION, 1925, 5, false));
        myLibrary.add(new Book("A Brief History of Time", "Stephen Hawking", "978-0553380163", Category.SCIENCE, 1988, 2, false));
        // 2. Create our single user
        Memeber student = new Memeber("Alex");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. View All Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. View My Borrowed Books");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // You might want to add a printBooks() method to Library!
                    System.out.println("Displaying all books...");
                    myLibrary.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String bookToBorrow = scanner.nextLine();

                    Book result = myLibrary.borrowBook(bookToBorrow);

                    if (result != null) {
                        student.addBorrowedBook(result); // This updates the Member's list
                        System.out.println("Success! You have borrowed: " + result.getTitle());
                    } else {
                        System.out.println("Error: Book not found or already borrowed.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- My Borrowed Books ---");
                    List<Book> myBooks = student.getBarrowedBooks();

                    if (myBooks.isEmpty()) {
                        System.out.println("You haven't borrowed any books yet.");
                    } else {
                        for (Book b : myBooks) {
                            System.out.println("- " + b.getTitle() + " (" + b.getAuthor() + ")");
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
        System.out.println("Goodbye!");
    }
}