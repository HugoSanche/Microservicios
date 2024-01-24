package com.in28minutes.rest.webservices.restfullwebservices.DAO;

import com.in28minutes.rest.webservices.restfullwebservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
