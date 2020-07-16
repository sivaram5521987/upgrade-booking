package org.valcano.booking.model.controller;

public class UpdateBookingRequest {

  private String updatedBookingFrom;

  private int days;

  public UpdateBookingRequest() {
  }

  public UpdateBookingRequest(String updatedBookingFrom, int days) {
    this.updatedBookingFrom = updatedBookingFrom;
    this.days = days;
  }

  public String getUpdatedBookingFrom() {
    return updatedBookingFrom;
  }

  public void setUpdatedBookingFrom(String updatedBookingFrom) {
    this.updatedBookingFrom = updatedBookingFrom;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }
}
