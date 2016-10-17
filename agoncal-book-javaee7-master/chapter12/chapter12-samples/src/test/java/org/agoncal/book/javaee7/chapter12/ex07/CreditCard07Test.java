package org.agoncal.book.javaee7.chapter12.ex07;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CreditCard07Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static Date creationDate;
  public static final String creditCardXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><creditCard07><controlNumber>566</controlNumber><expiryDate>10/14</expiryDate><number>12345678</number><type>Visa</type></creditCard07>";

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws IOException {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2013, Calendar.JUNE, 5);
    creationDate = calendar.getTime();
  }

  @After
  public void stop() {
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldMarshallACreditCard() throws JAXBException {

    CreditCard07 creditCard = new CreditCard07("12345678", "10/14", 566, "Visa");

    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(CreditCard07.class);
    Marshaller m = context.createMarshaller();
    m.marshal(creditCard, writer);

    System.out.println(writer);

    assertEquals(creditCardXML, writer.toString());

  }

  @Test
  public void shouldUnmarshallACreditCard() throws JAXBException {
    StringReader reader = new StringReader(creditCardXML);
    JAXBContext context = JAXBContext.newInstance(CreditCard07.class);
    Unmarshaller u = context.createUnmarshaller();
    CreditCard07 creditCard = (CreditCard07) u.unmarshal(reader);

    assertEquals("12345678", creditCard.getNumber());
    assertEquals("10/14", creditCard.getExpiryDate());
    assertEquals((Object) 566, creditCard.getControlNumber());
    assertEquals("Visa", creditCard.getType());
  }
}