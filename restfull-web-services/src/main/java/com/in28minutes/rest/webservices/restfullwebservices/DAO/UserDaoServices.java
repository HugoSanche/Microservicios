package com.in28minutes.rest.webservices.restfullwebservices.DAO;

import com.in28minutes.rest.webservices.restfullwebservices.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoServices {

    private static List<User> users=new ArrayList<>();
    static {
                users.add(new User(1,"Hugo", LocalDate.now().minusYears(30)));
                users.add(new User(1,"Hugo", LocalDate.now().minusYears(30)));
                users.add(new User(1,"Hugo", LocalDate.now().minusYears(30)));
    }
    public List<User> listAll(){
        return users;
    }


}
