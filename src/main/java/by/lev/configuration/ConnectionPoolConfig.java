package by.lev.configuration;

import by.lev.util.DatabaseProperties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ConnectionPoolConfig {

    // analog Statement
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    // analog Prepared Statement
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    //ConnectionPool
    @Bean
    public DataSource hikariDatasource(DatabaseProperties databaseConfig){
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setJdbcUrl(databaseConfig.getUrl());
        hikariDataSource.setUsername(databaseConfig.getLogin());
        hikariDataSource.setPassword(databaseConfig.getPassword());
        hikariDataSource.setDriverClassName(databaseConfig.getDriver());
        hikariDataSource.setMaximumPoolSize(10);

        return hikariDataSource;
    }


}
