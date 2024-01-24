package com.in28minutes.rest.webservices.restfullwebservices.DAO;

import com.in28minutes.rest.webservices.restfullwebservices.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
