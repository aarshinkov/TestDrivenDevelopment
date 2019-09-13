package com.safb.tdd.dao;

import com.safb.tdd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUsersCount(Integer count) throws SQLException {
        String sql = "SELECT * FROM users LIMIT ?";

        PreparedStatement ps = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection().prepareCall(sql);
        ps.setInt(1, count);

        ResultSet rs = ps.executeQuery();

        List<User> users = new ArrayList<>();

        while (rs.next()) {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            users.add(user);
        }

        return users;
    }
}
