package by.lev.connection;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyPostgreSQLConnection {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(getProperty("POSTGRES_DRIVER"));
        } catch (
                ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }

        String url = getProperty("DATABASE_URL");
        String login = getProperty("DATABASE_LOGIN");
        String password = getProperty("DATABASE_PASSWORD");

        return DriverManager.getConnection(url, login, password);
    }


    public static String getProperty(String key) {
        return ResourceBundle.getBundle("database").getString(key);
    }


}
