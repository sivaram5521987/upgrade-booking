package org.valcano.booking.service;

import java.time.LocalDate;
import java.util.Set;

import org.valcano.booking.model.controller.BookingRequest;
import org.valcano.booking.model.db.Booking;

public interface BookingGateway {

  String saveBooking(final BookingRequest request);

  Set<Booking> findAllBookingsFromDate(LocalDate from);

  int deleteBooking(final String identifier);

  Booking findByIdentifier(final String identifier);

  int updateBooking(final String identifier, final LocalDate from, final LocalDate to);
}
