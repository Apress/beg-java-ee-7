package org.agoncal.book.javaee7.chapter02.ex02;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService02 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private NumberGenerator02 numberGenerator;

  // ======================================
  // =            Constructors            =
  // ======================================

  public BookService02() {
    this.numberGenerator = new IsbnGenerator02();
  }

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book02 createBook(String title, Float price, String description) {
    Book02 book = new Book02(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
