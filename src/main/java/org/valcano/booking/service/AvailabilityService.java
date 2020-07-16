package org.valcano.booking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.valcano.booking.model.db.Booking;

public interface AvailabilityService {

  List<LocalDate> getAvailableDays(final Set<Booking> bookings, final LocalDate from,
                                   final LocalDate to);
}
