//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: LibraryTester.java
// Course: CS 300 Fall 2024
//
// Author: Tristin Yun
// Email: tyun7@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons: NOBODY
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

/**
 * Tests methods of Book and Library classes.
 */
public class LibraryTester {
  /**
   * PROVIDED TESTER METHOD: example test method for testing the getTitle method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetTitle() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    return "1984".equals(book.getTitle());
  }

  /**
   * PROVIDED TESTER METHOD: example test method for testing the setTitle method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testSetTitle() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    book.setTitle("Animal Farm");
    return "Animal Farm".equals(book.getTitle());
  }

  /**
   * test method for testing the getAuthor method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetAuthor() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    return "George Orwell".equals(book.getAuthor());
  }

  /**
   * test method for testing the setAuthor method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testSetAuthor() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    book.setAuthor("Albert Einstein");
    return "Albert Einstein".equals(book.getAuthor());
  }

  /**
   * test method for testing the getYearOfPublication method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetYearOfPublication() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    return 1949 == book.getYearOfPublication();
  }

  /**
   * test method for testing the setYearOfPublication method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testSetYearOfPublication() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    book.setYearOfPublication(1869);
    return 1869 == book.getYearOfPublication();
  }

  /**
   * test method for testing the getPublisher method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetPublisher() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    return "Secker & Warburg".equals(book.getPublisher());
  }

  /**
   * test method for testing the setPublisher method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testSetPublisher() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    book.setPublisher("Penguin Classics");
    return "Penguin Classics".equals(book.getPublisher());
  }

  /**
   * test method for testing the getNumberOfPages method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetNumberOfPages() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    return 328 == book.getNumberOfPages();
  }

  /**
   * test method for testing the setNumberOfPages method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testSetNumberOfPages() {
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    book.setNumberOfPages(420);
    return 420 == book.getNumberOfPages();
  }

  /**
   * PROVIDED TESTER METHOD: Retrieves the total number of books in the library.
   * 
   * @return the total number of books
   */
  public static boolean testGetTotalBooks() {
    Library library = new Library();
    library.addBook(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
    library.addBook(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

    int expected = 2;
    int result = library.getTotalBooks();

    ArrayList<Book> expectedA = new ArrayList<>();
    expectedA.add(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
    expectedA.add(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

    if (expected != result) {
      return false;
    }
    return compareBooks(expectedA, library.getAllBooks());
  }


  /**
   * PROVIDED TESTER METHOD: example test method for adding a single book to the library.
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testAddBook() {
    Library library = new Library();
    Book book = new Book("Test Book", "Test Author", 2023, "Publisher X", 100);
    library.addBook(book);

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    return compareBooks(expected, library.getAllBooks());
  }

  /**
   * test method for adding multiple books to the library.
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testAddMultipleBooks() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2024, "Publisher X", 100));
    library.addBook(new Book("Test Book2", "Test Author2", 2019, "Publisher Y", 200));
    library.addBook(new Book("Test Book3", "Test Author3", 2020, "Publisher Z", 300));

    int expectedTotal = 3;
    if (expectedTotal != library.getTotalBooks()) {
      return false;
    }

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book2", "Test Author2", 2019, "Publisher Y", 200));
    expected.add(new Book("Test Book3", "Test Author3", 2020, "Publisher Z", 300));
    expected.add(new Book("Test Book1", "Test Author1", 2024, "Publisher X", 100));
    return compareBooks(expected, library.getAllBooks());
  }

  /**
   * PROVIDED TESTER METHOD: example test method for removing a book by title from the library.
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testRemoveBookByTitle() {
    Library library = new Library();
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    boolean result = library.removeBookByTitle("Test Book");

    // checking result from removeBookByTitle("Test Book")
    if (result != true) {
      return false;
    }
    // checking resulted number of books
    if (library.getTotalBooks() != 0) {
      return false;
    }
    ArrayList<Book> expected = new ArrayList<>();
    // checking resulted library
    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  /**
   * test method for removing one of many books by title from library
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testRemoveOneOfManyBooks() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    library.addBook(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    library.addBook(new Book("Test Book3", "Test Author3", 2024, "Publisher Z", 300));
    boolean result = library.removeBookByTitle("Test Book3");

    // checking result from removeBookByTitle("Test Book3")
    if (result != true) {
      return false;
    }
    // checking resulted number of books
    if (library.getTotalBooks() != 2) {
      return false;
    }
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    expected.add(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    // checking resulted library
    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  /**
   * test method for creating a list of books under specified author
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testFindBooksByAuthor() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    library.addBook(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    library.addBook(new Book("Test Book3", "Test Author3", 2024, "Publisher Z", 300));
    ArrayList<Book> list = library.findBooksByAuthor("Test Author1");

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    // checking resulted list
    if (!compareBooks(expected, list)) {
      return false;
    }
    return true;
  }

  /**
   * test method for creating a list of books under multiple authors
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testFindBooksByMultipleAuthors() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    library.addBook(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    library.addBook(new Book("Test Book3", "Test Author3", 2024, "Publisher Z", 300));
    ArrayList<Book> collection = library.findBooksByAuthor("Test Author2");
    collection.addAll(library.findBooksByAuthor("Test Author3"));

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    expected.add(new Book("Test Book3", "Test Author3", 2024, "Publisher Z", 300));
    // checking resulted list
    if (!compareBooks(expected, collection)) {
      return false;
    }
    return true;
  }


  /**
   * test method for updating a book title in the library.
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testUpdateBookTitle() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    boolean result = library.updateBookTitle("Test Book1", "Arry Potta");

    if (result != true) {
      return false;
    }

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Arry Potta", "Test Author1", 2022, "Publisher X", 100));

    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  /**
   * test method for updating multiple book titles in the library.
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testUpdateMultipleBookTitles() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    library.addBook(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    library.addBook(new Book("Test Book3", "Test Author3", 2024, "Publisher Z", 300));
    boolean result1 = library.updateBookTitle("Test Book1", "Arry Potta");
    boolean result2 = library.updateBookTitle("Arry Potta", "Won Weasley");
    boolean result3 = library.updateBookTitle("Test Book3", "Moincraft");

    if (!(result1 == true && result2 == true && result3 == true)) {
      return false;
    }

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Won Weasley", "Test Author1", 2022, "Publisher X", 100));
    expected.add(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    expected.add(new Book("Moincraft", "Test Author3", 2024, "Publisher Z", 300));

    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  /**
   * test method for updating a book's author in the library
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testUpdateBookAuthor() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    boolean result = library.updateBookAuthor("Test Book1", "Henry Barnard");

    if (result != true) {
      return false;
    }

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book1", "Henry Barnard", 2022, "Publisher X", 100));

    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  /**
   * test method for updating multiple books' authors in the library
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testUpdateMultipleBookAuthors() {
    Library library = new Library();
    library.addBook(new Book("Test Book1", "Test Author1", 2022, "Publisher X", 100));
    library.addBook(new Book("Test Book2", "Test Author2", 2023, "Publisher Y", 200));
    library.addBook(new Book("Test Book3", "Test Author3", 2024, "Publisher Z", 300));
    boolean result1 = library.updateBookAuthor("Test Book1", "Andrew");
    boolean result2 = library.updateBookAuthor("Test Book2", "Beavus");
    boolean result3 = library.updateBookAuthor("Test Book3", "Carmello");

    if (!(result1 == true && result2 == true && result3 == true)) {
      return false;
    }

    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book1", "Andrew", 2022, "Publisher X", 100));
    expected.add(new Book("Test Book2", "Beavus", 2023, "Publisher Y", 200));
    expected.add(new Book("Test Book3", "Carmello", 2024, "Publisher Z", 300));

    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  /**
   * test method for removing a book that isn't in the library
   * 
   * @return true if the test passes, false otherwise
   */
  public static boolean testRemoveNonExistentBook() {
    Library library = new Library();
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    boolean result = library.removeBookByTitle("Candid");

    // checking result from removeBookByTitle("Test Book")
    if (result != false) {
      return false;
    }
    // checking resulted number of books
    if (library.getTotalBooks() != 1) {
      return false;
    }
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    // checking resulted library
    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  /**
   * Compares two lists of books for equality.
   * 
   * @param expected the expected list of books
   * @param result   the list of books to compare
   * @return true if both lists contain the same books, false otherwise
   */
  private static boolean compareBooks(ArrayList<Book> expected, ArrayList<Book> result) {
    if (expected.size() != result.size()) {
      return false;
    }
    for (int i = 0; i < expected.size(); i++) {
      Book expectedBook = expected.get(i);
      Book resultBook = result.get(i);
      if (!expectedBook.getTitle().equals(resultBook.getTitle())
          || !expectedBook.getAuthor().equals(resultBook.getAuthor())
          || !(expectedBook.getPublisher().equals(resultBook.getPublisher()))
          || !(expectedBook.getNumberOfPages() == resultBook.getNumberOfPages())
          || !(expectedBook.getYearOfPublication() == resultBook.getYearOfPublication())) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // test two functions in book.class
    System.out.println("Test getTitle: " + testGetTitle());
    System.out.println("Test setTitle: " + testSetTitle());
    System.out.println("Test getAuthor: " + testGetAuthor());
    System.out.println("Test setAuthor: " + testSetAuthor());
    System.out.println("Test getYearOfPublication: " + testGetYearOfPublication());
    System.out.println("Test setYearOfPublication: " + testSetYearOfPublication());
    System.out.println("Test getPublisher: " + testGetPublisher());
    System.out.println("Test setPublisher: " + testSetPublisher());
    System.out.println("Test getNumberOfPages: " + testGetNumberOfPages());
    System.out.println("Test setNumberOfPages: " + testSetNumberOfPages());
    System.out.println("Test getTotalBooks: " + testGetTotalBooks());
    System.out.println("Test addBook: " + testAddBook());
    System.out.println("Test addMultipleBooks: " + testAddMultipleBooks());
    System.out.println("Test removeBookByTitle: " + testRemoveBookByTitle());
    System.out.println("Test removeOneOfManyBooks: " + testRemoveOneOfManyBooks());
    System.out.println("Test findBooksByAuthor: " + testFindBooksByAuthor());
    System.out.println("Test findBooksByMultipleAuthors: " + testFindBooksByMultipleAuthors());
    System.out.println("Test updateBookTitle: " + testUpdateBookTitle());
    System.out.println("Test updateMultipleBookTitles: " + testUpdateMultipleBookTitles());
    System.out.println("Test updateBookAuthor: " + testUpdateBookAuthor());
    System.out.println("Test updateMultipleBookAuthors: " + testUpdateMultipleBookAuthors());
    System.out.println("Test removeNonExistentBook: " + testRemoveNonExistentBook());

  }
}
