package org.valcano.booking.dao;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.valcano.booking.model.db.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

  @Lock(value = LockModeType.OPTIMISTIC)
  @Override
  Booking save(Booking s);

  int deleteBookingByBookingIdentifier(final String bookingIdentifier);

  Optional<Booking> findByBookingIdentifier(final String bookingIdentifier);

  @Modifying
  @Transactional
  @Query("update Booking b set b.bookingFrom = :from, b.bookingTo = :to where b.bookingIdentifier = :identifier")
  int updateBooking(@Param("identifier") final String identifier, @Param("from") final LocalDate from,
                    @Param("to") final LocalDate to);

  @Query("select b from Booking b where b.bookingFrom > :from ")
  Set<Booking> findAllAfter(@Param("from") LocalDate from);
}
