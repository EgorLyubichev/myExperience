package by.lev.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:database.properties")
public class DatabaseProperties {

    @Value("${POSTGRES_DRIVER}")
    private String driver;

    @Value("${DATABASE_URL}")
    private String url;

    @Value("${DATABASE_LOGIN}")
    private String login;

    @Value("${DATABASE_PASSWORD}")
    private String password;
}
