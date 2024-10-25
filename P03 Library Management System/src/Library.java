//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Library.java
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
 * a library class that manages a collection of books
 */
public class Library {
  private ArrayList<Book> books = new ArrayList<Book>();

  // Accessor Methods

  /**
   * Accessor method for the total # of books
   * 
   * @return the number of books in the library
   */
  public int getTotalBooks() {
    return books.size();
  }

  /**
   * Accessor method for the a list of all of books
   * 
   * @return an ArrayList with all books in the library
   */
  public ArrayList<Book> getAllBooks() {
    return books;
  }

  /**
   * Accessor method to find books under an author
   * 
   * @param author the author whose books are desired
   * @return an ArrayList with all books by an author
   */
  public ArrayList<Book> findBooksByAuthor(String author) {
    // adds books under specified author to the 'collection' ArrayList
    ArrayList<Book> collection = new ArrayList<>();
    for (Book b : books) {
      if (b.getAuthor().equalsIgnoreCase(author)) {
        collection.add(b);
      }
    }
    return collection;
  }

  /**
   * Accessor method to print the title and author of each book in the library
   */
  public void printAllBooks() {
    for (Book b : books) {
      System.out.println("Title: " + b.getTitle() + ", Author: " + b.getAuthor());
    }
  }

  // Mutator Methods

  /**
   * Mutator method to add a book to the library in chronological order
   * 
   * @param book the book to be added
   */
  public void addBook(Book book) {
    // sets the index to books.size by default so that if there are no books,
    // or if there are no books with a greater publishing year, the new book
    // will be appended to the end of the books ArrayList.
    // Otherwise makes the index at the point where the book would fit chronologically
    int index = books.size();
    for (int i = 0; i < books.size(); i++) {
      if (book.getYearOfPublication() < books.get(i).getYearOfPublication()) {
        index = i;
      }
    }
    this.books.add(index, book);
  }

  /**
   * Mutator method to remove a book to the library by title
   * 
   * @param title title of the book to be removed
   * @return true if the desired book was successfully removed
   */
  public boolean removeBookByTitle(String title) {
    // removes the first book that matches the title parameter
    for (Book b : books) {
      if (b.getTitle().equalsIgnoreCase(title)) {
        return books.remove(b);
      }
    }
    return false;
  }

  /**
   * Mutator method to update the title of a book
   * 
   * @param oldTitle the title of the book to be changed
   * @param newTitle the new title of the book
   * @return true if the book was updated
   */
  public boolean updateBookTitle(String oldTitle, String newTitle) {
    // updates the title of the book in the library with corresponding title
    for (Book b : books) {
      if (b.getTitle().equalsIgnoreCase(oldTitle)) {
        b.setTitle(newTitle);
        return true;
      }
    }
    return false;
  }

  /**
   * Mutator method to update the author of a book
   * 
   * @param title     the title of the book to be changed
   * @param newAuthor the new author of the book
   * @return true if the book was updated
   */
  public boolean updateBookAuthor(String title, String newAuthor) {
    // updates the title of the book in the library with corresponding title
    for (Book b : books) {
      if (b.getTitle().equalsIgnoreCase(title)) {
        b.setAuthor(newAuthor);
        return true;
      }
    }
    return false;
  }

}
