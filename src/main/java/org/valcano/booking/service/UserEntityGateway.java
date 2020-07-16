package org.valcano.booking.service;

import org.valcano.booking.model.db.User;

public interface UserEntityGateway {

  User transformToModelUser(final String firstName, final String lastName, final String email);

  User saveUser(final User user);
}
