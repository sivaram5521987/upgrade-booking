package org.valcano.booking.model.controller;

public class BookingRequest {

  private String firstName;

  private String lastName;

  private String email;

  private String bookingFrom;

  private int days;

  public BookingRequest() {
  }

  public BookingRequest(String firstName, String lastName, String email, String bookingFrom, int days) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.bookingFrom = bookingFrom;
    this.days = days;
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

  public String getBookingFrom() {
    return bookingFrom;
  }

  public void setBookingFrom(String bookingFrom) {
    this.bookingFrom = bookingFrom;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }


}

