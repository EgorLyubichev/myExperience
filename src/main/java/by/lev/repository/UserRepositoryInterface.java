package by.lev.repository;

import by.lev.domain.User;

import java.util.List;


public interface UserRepositoryInterface {
    List<User> readAll();

    User readById(Long id);
}
