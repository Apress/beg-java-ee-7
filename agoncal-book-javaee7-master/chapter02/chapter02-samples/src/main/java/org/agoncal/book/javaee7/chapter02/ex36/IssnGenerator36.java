package org.agoncal.book.javaee7.chapter02.ex36;


import java.util.Random;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class IssnGenerator36 implements NumberGenerator36 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}