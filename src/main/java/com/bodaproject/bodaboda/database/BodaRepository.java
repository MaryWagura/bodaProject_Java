package com.bodaproject.bodaboda.database;

import com.bodaproject.bodaboda.database.entities.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface BodaRepository  extends CrudRepository<UserModel, Long> {
}
