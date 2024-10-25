//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Book.java
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
/**
 * Constructs a book with desired title, author, publication year, publisher, and number of pages
 */
public class Book {
  // private fields
  private String title;
  private String author;
  private int yearOfPublication;
  private String publisher;
  private int numberOfPages;

  /**
   * Constructor method for the book class; takes in private fields
   * 
   * @param title             name of book
   * @param author            author of book
   * @param yearOfPublication year book was published
   * @param publisher         name of publisher
   * @param numberOfPages     # of pages in book
   * @throws IllegalArgumentException if the publishing year is negative or > 2024, or if the page
   *                                  count is negative
   */
  public Book(String title, String author, int yearOfPublication, String publisher,
      int numberOfPages) {
    // initialize the private fields
    this.title = title;
    this.author = author;
    // validity check for yearOfPublication
    if (yearOfPublication < 0 || yearOfPublication > 2024) {
      throw new IllegalArgumentException("invalid publication year");
    }
    this.yearOfPublication = yearOfPublication;
    this.publisher = publisher;
    // validity check for numberOfPages
    if (numberOfPages < 0)
      throw new IllegalArgumentException("negative page count");
    this.numberOfPages = numberOfPages;
  }

  // Accessor methods

  /**
   * Accessor method for the title private field
   * 
   * @return the title of the book
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Accessor method for the author private field
   * 
   * @return the author of the book
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Accessor method for the yearOfPublication private field
   * 
   * @return the year of publication of the book
   */
  public int getYearOfPublication() {
    return this.yearOfPublication;
  }

  /**
   * Accessor method for the publisher private field
   * 
   * @return the publisher of the book
   */
  public String getPublisher() {
    return this.publisher;
  }

  /**
   * Accessor method for the numberOfPages private field
   * 
   * @return the number of pages in the book
   */
  public int getNumberOfPages() {
    return this.numberOfPages;
  }

  // Mutator methods

  /**
   * Mutator method for the title private field
   * 
   * @param title the new title of the book
   */
  public void setTitle(String title) {
    this.title = new String(title);
  }

  /**
   * Mutator method for the author private field
   * 
   * @param author the new author of the book
   */
  public void setAuthor(String author) {
    this.author = new String(author);
  }

  /**
   * Mutator method for the yearOfPublication private field
   * 
   * @param yearOfPublication the new publishing year of the book
   * @throws IllegalArgumentException if the publication year is negative of > 2024
   */
  public void setYearOfPublication(int yearOfPublication) {
    if (yearOfPublication < 0 || yearOfPublication > 2024) {
      throw new IllegalArgumentException("invalid publication year");
    }
    this.yearOfPublication = yearOfPublication;
  }

  /**
   * Mutator method for the publisher private field
   * 
   * @param author the new publisher of the book
   */
  public void setPublisher(String publisher) {
    this.publisher = new String(publisher);
  }

  /**
   * Mutator method for the numberOfPages private field
   * 
   * @param numberOfPages the new page count of the book
   * @throws IllegalArgumentException if the page count is negative
   */
  public void setNumberOfPages(int numberOfPages) {
    if (numberOfPages < 0) {
      throw new IllegalArgumentException("negative page count");
    }
    this.numberOfPages = numberOfPages;
  }

}
