package by.lev.connection;

import by.lev.configuration.DatabaseProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class MyPostgreSQLConnection {

    private final DatabaseProperties databaseProperties;


    public Connection getConnection() throws SQLException {
        try {
            Class.forName(databaseProperties.getDriver());
        } catch (
                ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }

        String url = databaseProperties.getUrl();
        String login = databaseProperties.getLogin();
        String password = databaseProperties.getPassword();

        return DriverManager.getConnection(url, login, password);
    }
}
