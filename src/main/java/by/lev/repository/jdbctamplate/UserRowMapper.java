package by.lev.repository.jdbctamplate;

import by.lev.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.lev.repository.UserColumns.ID;
import static by.lev.repository.UserColumns.NAME;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(ID));
        user.setName(resultSet.getString(NAME));
        return user;
    }
}
