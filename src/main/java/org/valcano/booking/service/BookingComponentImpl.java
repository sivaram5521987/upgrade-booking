package org.valcano.booking.service;

import static java.util.stream.Collectors.toSet;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.valcano.booking.model.controller.BookingRequest;
import org.valcano.booking.model.controller.BookingResponse;
import org.valcano.booking.model.controller.BookingSummary;
import org.valcano.booking.model.controller.UpdateBookingRequest;
import org.valcano.booking.model.db.Booking;

class BookingComponentImpl implements BookingComponent {

  private static final Logger log = LoggerFactory.getLogger(BookingComponentImpl.class);

  private final BookingGateway bookingGateway;

  private final ReservationService reservationService;

  private final AvailabilityService availabilityService;

  BookingComponentImpl(final BookingGateway bookingGateway,
                       final ReservationService reservationService,
                       final AvailabilityService availabilityService) {
    this.bookingGateway = bookingGateway;
    this.reservationService = reservationService;
    this.availabilityService = availabilityService;
  }

  @Override
  public BookingResponse doCampsiteBooking(final BookingRequest bookingRequest) {
    Set<org.valcano.booking.model.service.Booking> bookings = getSystemBookings();
    LocalDate bookingFrom = LocalDate.parse(bookingRequest.getBookingFrom());
    LocalDate bookingTo = bookingFrom.plusDays(bookingRequest.getDays());

    org.valcano.booking.model.service.Booking userBook = new org.valcano.booking.model.service.Booking(null, bookingFrom, bookingTo);
    boolean isAvailable = reservationService.checkAvailability(bookings, userBook);

    if (isAvailable) {
      return new BookingResponse(bookingGateway.saveBooking(bookingRequest));
    }

    throw new IllegalArgumentException("That date is already booked!.");
  }

  @Override
  public int deleteBooking(final String identifier) {
    return bookingGateway.deleteBooking(identifier);
  }

  private Set<org.valcano.booking.model.service.Booking> getSystemBookings() {
    return bookingGateway
        .findAllBookingsFromDate(LocalDate.now())
        .stream()
        .map(b -> new org.valcano.booking.model.service.Booking(b.getBookingIdentifier(), b.getBookingFrom(), b.getBookingTo()))
        .collect(toSet());
  }

  @Override
  @Transactional
  public BookingResponse updateBooking(final String identifier, final UpdateBookingRequest request) {
    Booking booking = bookingGateway.findByIdentifier(identifier);

    Set<org.valcano.booking.model.service.Booking> bookings = getSystemBookings();

    bookings
        .remove(new org.valcano.booking.model.service.Booking(booking.getBookingIdentifier(), booking.getBookingFrom(), booking.getBookingTo()));
    //remove actual booking in the set.

    LocalDate bookingFrom = LocalDate.parse(request.getUpdatedBookingFrom());
    LocalDate bookingTo = bookingFrom.plusDays(request.getDays());
    booking.setBookingFrom(bookingFrom);
    booking.setBookingTo(bookingTo);

    boolean isAvailable = reservationService.checkAvailability(bookings,
        new org.valcano.booking.model.service.Booking(booking.getBookingIdentifier(), booking.getBookingFrom(), booking.getBookingTo()));

    if (isAvailable) {
      int updatedBookings = bookingGateway.updateBooking(identifier, bookingFrom, bookingTo);

      log.info("{} booking was updated.", updatedBookings);
      return new BookingResponse(identifier);
    }

    throw new IllegalArgumentException("That date is already booked!.");
  }

  @Override
  public BookingSummary findBookingByIdentifier(final String identifier) {
    return new BookingSummary(bookingGateway.findByIdentifier(identifier));
  }

  @Override
  public List<LocalDate> findAvailableDays(final LocalDate from, final LocalDate to) {

    return availabilityService.getAvailableDays(
        bookingGateway.findAllBookingsFromDate(LocalDate.now()),
        from,
        to
    );
  }
}
