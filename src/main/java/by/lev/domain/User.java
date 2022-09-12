package by.lev.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {

    private Long id;

    private String name;

}
