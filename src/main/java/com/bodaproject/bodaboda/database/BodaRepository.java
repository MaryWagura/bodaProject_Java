package com.bodaproject.bodaboda.database;

import com.bodaproject.bodaboda.database.entities.UserModel;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BodaRepository  extends CrudRepository<UserModel, Long> {
    List<UserModel> findByNumberplate(String numberplate);
    List<UserModel> findByIdnumber(String idnumber);
}
