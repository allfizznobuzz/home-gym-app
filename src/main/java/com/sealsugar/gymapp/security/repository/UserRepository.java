package com.sealsugar.gymapp.security.repository;

import com.sealsugar.gymapp.security.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findUserByUserName(String userName);
}
