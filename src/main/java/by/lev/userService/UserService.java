package by.lev.userService;

import by.lev.domain.User;
import by.lev.userRepository.UserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface userRepository;

    @Override
    public List<User> readAll() {
        return userRepository.readAll();
    }
}
/*Именно такой вариант удобен для последующего тестирования. Это рекомендуемый вариант.*/



//@Service
//public class UserService implements UserServiceInterface {
//
//    private UserRepositoryInterface userRepository;
//
//    @Autowired
//    public UserService(@Qualifier("userRepository") UserRepositoryInterface userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public List<User> readAll() {
//        return userRepository.readAll();
//    }
//}


//@Service
//public class UserService implements UserServiceInterface {
//
//    @Autowired
//    @Qualifier("userRepository")
//    private UserRepositoryInterface userRepository;
//
//    @Override
//    public List<User> readAll() {
//        return userRepository.readAll();
//    }
//}



//@Service
//public class UserService implements UserServiceInterface {
//
//
//    private UserRepositoryInterface userRepository;
//
//
//    @Autowired
//    public void setUserRepository(@Qualifier("userRepository") UserRepositoryInterface userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public List<User> readAll() {
//        return userRepository.readAll();
//    }
//}
