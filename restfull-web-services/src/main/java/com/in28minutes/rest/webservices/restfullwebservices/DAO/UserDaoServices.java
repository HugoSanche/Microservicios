package com.in28minutes.rest.webservices.restfullwebservices.DAO;

import com.in28minutes.rest.webservices.restfullwebservices.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoServices {

    private static Integer countId=0;
    private static List<User> users=new ArrayList<>();
    static {
                users.add(new User(++countId,"Hugo", LocalDate.now().minusYears(30)));
                users.add(new User(++countId,"Veronica", LocalDate.now().minusYears(40)));
                users.add(new User(++countId,"Daniel", LocalDate.now().minusYears(50)));
    }
    public List<User> listAll(){
        return users;
    }

    public User listUser(int id){
        return users.get(id);
    }
    public User findOne(int id){
        Predicate<? super User> predicate=user ->user.getId().equals(id);
        System.out.println("Result Predicate "+predicate);
        return users.stream().filter(predicate).findFirst().orElse(null); //if not found the id return null
    }

    public User save(User user){
        user.setId(++countId);
        users.add(user);
        return user;
    }
    public void deleteById(Integer id){
        Predicate<? super User> predicate=user ->user.getId().equals(id);
        users.removeIf(predicate);
    }
}










