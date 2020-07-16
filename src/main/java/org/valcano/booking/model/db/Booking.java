package org.valcano.booking.model.db;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Booking {

  @Id
  @GeneratedValue
  private long id;

  private String bookingIdentifier;

  /**
   * Inclusive date.
   */
  private LocalDate bookingFrom;

  /**
   * Exclusive date
   */
  private LocalDate bookingTo;

  public Booking() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBookingIdentifier() {
    return bookingIdentifier;
  }

  public void setBookingIdentifier(String bookingIdentifier) {
    this.bookingIdentifier = bookingIdentifier;
  }

  public LocalDate getBookingFrom() {
    return bookingFrom;
  }

  public void setBookingFrom(LocalDate bookingFrom) {
    this.bookingFrom = bookingFrom;
  }

  public void setBookingTo(LocalDate bookingTo) {
    this.bookingTo = bookingTo;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  @Version
  private long version;

  public Booking(final String bookingIdentifier, final LocalDate bookingFrom, final LocalDate bookingTo) {
    this.bookingIdentifier = bookingIdentifier;
    this.bookingFrom = bookingFrom;
    this.bookingTo = bookingTo;
  }

  public LocalDate getBookingTo() {
    return this.bookingTo.minusDays(1);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("bookingIdentifier", bookingIdentifier)
        .append("bookingFrom", bookingFrom)
        .append("bookingTo", bookingTo)
        .append("version", version)
        .toString();
  }
}
