package org.agoncal.book.javaee7.chapter15.ex11;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
public class Customer11 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Customer11() {
  }

  public Customer11(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================


  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Customer11");
    sb.append("{id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append('}');
    return sb.toString();
  }
}