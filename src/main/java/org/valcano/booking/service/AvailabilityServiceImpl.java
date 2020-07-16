package org.valcano.booking.service;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.valcano.booking.model.db.Booking;

public class AvailabilityServiceImpl implements AvailabilityService {

  private static List<LocalDate> createAvailabilityList(final LocalDate from, final LocalDate to) {
    int days = Period.between(from, to).getDays();
    return Stream.iterate(from, f -> f.plusDays(1))
        .limit(days + 1) //Last day in Period API is exclusive, here we want to include it.
        .collect(toList());
  }

  @Override
  public List<LocalDate> getAvailableDays(
      final Set<Booking> bookings,
      final LocalDate from,
      final LocalDate to) {

    Set<LocalDate> sysDays = bookings
        .stream()
        .flatMap(s -> createAvailabilityList(s.getBookingFrom(), s.getBookingTo()).stream())
        .collect(toSet());
    List<LocalDate> askedAvailability = createAvailabilityList(from, to);
    return askedAvailability
        .stream()
        .filter(day -> !sysDays.contains(day))
        .collect(toList());
  }
}
