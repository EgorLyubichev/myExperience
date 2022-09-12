package by.lev;

import by.lev.user.User;
import by.lev.user.UserRepositoryInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("by.lev");
        UserRepositoryInterface userRepository = annotationConfigApplicationContext.getBean
                ("userRepository", UserRepositoryInterface.class);

        List<User> users = userRepository.readAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
