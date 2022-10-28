package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemlate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemlate) {
        this.dataSource = dataSource;
        this.jdbcTemlate = jdbcTemlate;
    }

    public void add(User user) {
        this.jdbcTemlate.update("insert into users values(?,?,?);", user.getId(), user.getName(), user.getPassword());
    }

    public void delete(String id) {
        this.jdbcTemlate.update("delete from users where id = ?", id);
    }

    public void deleteAll() {
        this.jdbcTemlate.update("delete from users;");
    }
}
