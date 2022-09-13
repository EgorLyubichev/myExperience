package by.lev.repository.jdbctamplate;

import by.lev.domain.User;
import by.lev.repository.UserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class JdbcTemplateUserRepository implements UserRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final UserRowMapper userRowMapper;


    @Override
    public List<User> readAll() {
        return jdbcTemplate.query("select * from my_experience_project.users", userRowMapper);
    }
}
