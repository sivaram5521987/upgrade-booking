package org.valcano.booking.service;

import static java.time.LocalDate.of;

import com.google.common.collect.Sets;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.valcano.booking.model.db.Booking;
import org.valcano.booking.service.AvailabilityService;
import org.valcano.booking.service.AvailabilityServiceImpl;

public class AvailabilityServiceImplTest {

  private AvailabilityService availabilityService;

  @Before
  public void setUp() {
    availabilityService = new AvailabilityServiceImpl();
  }

  @Test
  public void getAvailableDays() {

    Set<Booking> booked =
        Sets.newHashSet(
            new Booking(
                "xxaa1",
                of(2018, 1, 1),
                of(2018, 1, 3)),
            new Booking(
                "xxaa2",
                of(2018, 1, 10),
                of(2018, 1, 13)),
            new Booking(
                "xxaa23",
                of(2018, 1, 20),
                of(2018, 1, 21))
        );
    List<LocalDate> days = availabilityService.getAvailableDays(booked, of(2018, 1, 1), of(2018, 1, 31));

    System.out.println(days);
    System.out.println(days.size());
  }
}