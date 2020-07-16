package org.valcano.booking.model.controller;

import java.time.LocalDate;
import org.valcano.booking.model.db.Booking;


public class BookingSummary {

  private String bookingIdentifier;

  /**
   * Inclusive date.
   */
  private LocalDate bookingFrom;

  /**
   * Exclusive date
   */
  private LocalDate bookingTo;

  public BookingSummary() {
  }

  public BookingSummary(String bookingIdentifier, LocalDate bookingFrom, LocalDate bookingTo) {
    this.bookingIdentifier = bookingIdentifier;
    this.bookingFrom = bookingFrom;
    this.bookingTo = bookingTo;
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

  public LocalDate getBookingTo() {
    return bookingTo;
  }

  public void setBookingTo(LocalDate bookingTo) {
    this.bookingTo = bookingTo;
  }

  public BookingSummary(Booking sb) {
    this.bookingIdentifier = sb.getBookingIdentifier();
    this.bookingFrom = sb.getBookingFrom();
    this.bookingTo = sb.getBookingTo();
  }
}
