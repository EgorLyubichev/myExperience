package by.lev;

import by.lev.domain.User;
import by.lev.userRepository.UserRepositoryInterface;
import by.lev.userService.UserServiceInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("by.lev");
        UserServiceInterface userService = annotationConfigApplicationContext.getBean
                (UserServiceInterface.class);

        List<User> users = userService.readAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
