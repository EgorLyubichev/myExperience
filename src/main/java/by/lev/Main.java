package by.lev;

import by.lev.user.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext
                ("classpath:application-context.xml");

        User user1 = classPathXmlApplicationContext.getBean("user1", User.class);
        System.out.println(user1);




    }
}
