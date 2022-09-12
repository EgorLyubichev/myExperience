package by.lev.repository;

import by.lev.domain.User;

import java.util.List;


public interface UserRepositoryInterface {
    public List<User> readAll();
}
