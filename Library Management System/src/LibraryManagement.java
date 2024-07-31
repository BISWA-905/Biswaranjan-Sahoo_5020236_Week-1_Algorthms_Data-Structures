
import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagement {
    private Book[] books;
    private int size;

    // Constructor
    public LibraryManagement(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add a book to the library
    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    // Linear search to find a book by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null; // Book not found
    }

    // Binary search to find a book by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    // Sort books by title to prepare for binary search
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement(10);

        // Add books to the library
        library.addBook(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("2", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("3", "1984", "George Orwell"));

        // Linear search for a book by title
        System.out.println("Linear Search for '1984':");
        System.out.println(library.linearSearchByTitle("1984"));

        // Sort books by title
        library.sortBooksByTitle();

        // Binary search for a book by title
        System.out.println("Binary Search for 'The Great Gatsby':");
        System.out.println(library.binarySearchByTitle("The Great Gatsby"));
    }
}

