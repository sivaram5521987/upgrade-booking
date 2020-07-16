package org.valcano.booking.service;

import org.valcano.booking.model.controller.BookingRequest;
import org.valcano.booking.model.controller.BookingResponse;
import org.valcano.booking.model.controller.BookingSummary;
import org.valcano.booking.model.controller.UpdateBookingRequest;

import java.time.LocalDate;
import java.util.List;

public interface BookingComponent {

  BookingResponse doCampsiteBooking(final BookingRequest bookingRequest);

  int deleteBooking(final String identifier);

  BookingResponse updateBooking(final String identifier, final UpdateBookingRequest request);

  BookingSummary findBookingByIdentifier(final String identifier);

  List<LocalDate> findAvailableDays(final LocalDate from, final LocalDate to);
}
