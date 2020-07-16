package org.valcano.booking.model.controller;

import java.time.LocalDate;

public class BookingDate {

  private LocalDate from;

  private LocalDate to;

  public BookingDate() {
  }

  public BookingDate(LocalDate from, LocalDate to) {
    this.from = from;
    this.to = to;
  }

  public LocalDate getFrom() {
    return from;
  }

  public void setFrom(LocalDate from) {
    this.from = from;
  }

  public LocalDate getTo() {
    return to;
  }

  public void setTo(LocalDate to) {
    this.to = to;
  }
}
