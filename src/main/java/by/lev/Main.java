package by.lev;

import by.lev.user.User;
import by.lev.user.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new UserRepository().readAll();

        for (User user: users) {
            System.out.println(user);
        }



    }
}
