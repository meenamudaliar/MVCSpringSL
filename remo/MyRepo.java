package com.remo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;
@Repository
public interface MyRepo extends CrudRepository<User, String>{

}
