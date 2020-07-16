package org.valcano.booking.model.service;

import java.time.LocalDate;
import java.util.Objects;


public class Booking {

  private final String identifier;

  /**
   * Inclusive date
   */
  private final LocalDate from;

  /**
   * Exclusive date
   */
  private final LocalDate to;

  public Booking(String identifier, LocalDate from, LocalDate to) {
    this.identifier = identifier;
    this.from = from;
    this.to = to;
  }

  public String getIdentifier() {
    return identifier;
  }

  public LocalDate getFrom() {
    return from;
  }

  public LocalDate getTo() {
    return to;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking book = (Booking) o;
    return Objects.equals(identifier, book.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier);
  }
}
