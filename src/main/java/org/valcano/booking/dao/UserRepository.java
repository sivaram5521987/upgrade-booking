package org.valcano.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.valcano.booking.model.db.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
