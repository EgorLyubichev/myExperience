package by.lev.repository.jdbctemplate;

import by.lev.domain.User;
import by.lev.exception.NoSuchEntityException;
import by.lev.repository.UserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
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

    private static final Logger logger = Logger.getLogger(JdbcTemplateUserRepository.class);

    @Override
    public List<User> readAll() {
        logger.info("Start readAll method");
        return jdbcTemplate.query("select * from my_experience_project.users", userRowMapper);
    }

    @Override
    public User readById(Long id) {
        try {
            return jdbcTemplate.queryForObject("select * from my_experience_project.users where id = " + id, userRowMapper);
        } catch (EmptyResultDataAccessException e) {
            logger.error("DB connection process issues: Entity User with id " + id + " doesn't exist", e);
            throw new NoSuchEntityException("Entity User with id " + id + " doesn't exist", 404);
        }
    }
}
