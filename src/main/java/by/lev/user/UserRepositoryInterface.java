package by.lev.user;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepositoryInterface {
    public List<User> readAll();
}
