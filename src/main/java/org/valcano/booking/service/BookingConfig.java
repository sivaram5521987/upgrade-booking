package org.valcano.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.valcano.booking.dao.BookingRepository;
import org.valcano.booking.dao.UserRepository;
import org.valcano.booking.service.*;

@Configuration
public class BookingConfig {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BookingRepository bookingRepository;

  @Bean
  public UserEntityGateway userEntityGateway() {
    return new UserEntityGatewayImpl(userRepository);
  }

  @Bean
  public BookingGateway bookingGateway() {
    return new BookingGatewayImpl(bookingRepository);
  }

  @Bean
  public ReservationService reservationService() {
    return new ReservationServiceImpl();
  }

  @Bean
  public AvailabilityService availabilityService() {
    return new AvailabilityServiceImpl();
  }

  @Bean
  public BookingComponent bookingComponent() {
    return new BookingComponentImpl(bookingGateway(), reservationService(), availabilityService());
  }
}
