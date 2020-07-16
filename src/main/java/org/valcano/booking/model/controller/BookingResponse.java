package org.valcano.booking.model.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BookingResponse {

  private String bookingIdentifier;

  public BookingResponse(String bookingIdentifier) {
    this.bookingIdentifier = bookingIdentifier;
  }

  public String getBookingIdentifier() {
    return bookingIdentifier;
  }

  public void setBookingIdentifier(String bookingIdentifier) {
    this.bookingIdentifier = bookingIdentifier;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("bookingIdentifier", bookingIdentifier)
        .toString();
  }
}
