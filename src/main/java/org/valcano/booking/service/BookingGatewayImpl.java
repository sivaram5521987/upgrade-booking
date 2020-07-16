package org.valcano.booking.service;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.valcano.booking.model.controller.BookingRequest;
import org.valcano.booking.dao.BookingRepository;
import org.valcano.booking.model.db.Booking;

public class BookingGatewayImpl implements BookingGateway {

  private final BookingRepository bookingRepository;

  BookingGatewayImpl(final BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  @Transactional
  @Override
  public String saveBooking(final BookingRequest request) {
    Booking booking = bookingRepository.save(toDomainObject(request));
    return booking.getBookingIdentifier();
  }

  @Override
  public Set<Booking> findAllBookingsFromDate(LocalDate from) {
    return bookingRepository.findAllAfter(from);
  }

  @Override
  @Transactional
  public int deleteBooking(final String identifier) {
    return bookingRepository.deleteBookingByBookingIdentifier(identifier);
  }

  @Override
  public Booking findByIdentifier(final String identifier) {
    return bookingRepository.findByBookingIdentifier(identifier).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public int updateBooking(final String identifier, final LocalDate from, final LocalDate to) {
    return bookingRepository.updateBooking(identifier, from, to);
  }

  private Booking toDomainObject(final BookingRequest request) {
    Booking booking = new Booking();

    booking.setBookingIdentifier(getRandomUuidIdentifier());
    booking.setBookingFrom(LocalDate.parse(request.getBookingFrom()));
    booking.setBookingTo(LocalDate.parse(request.getBookingFrom()).plusDays(request.getDays()));

    return booking;
  }

  private String getRandomUuidIdentifier() {
    return UUID.randomUUID().toString();
  }
}
