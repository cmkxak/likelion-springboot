package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public int delete(String id) {
        return this.jdbcTemlate.update("delete from users where id = ?", id);
    }

    public int deleteAll() {
        return this.jdbcTemlate.update("delete from users");
    }

    public User findById(String id) {
        String sql = "select * from users where id = ?";
        return this.jdbcTemlate.queryForObject(sql, rowMapper, id);
    }

    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            return user;
        }
    };
}
