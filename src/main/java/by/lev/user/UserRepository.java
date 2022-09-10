package by.lev.user;

import by.lev.connection.MyPostgreSQLConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.lev.user.UserColumns.ID;
import static by.lev.user.UserColumns.NAME;

public class UserRepository {
    public List<User> readAll() {
        String readAllScript = "select * from my_experience_project.users";

        List<User> users = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {

            connection = MyPostgreSQLConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(readAllScript);

            while(resultSet.next()){
                users.add(userRowMapping(resultSet));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User userRowMapping(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong(ID));
        user.setName(rs.getString(NAME));
        return user;
    }
}
