package com.safb.tdd.services;

import com.safb.tdd.entity.User;
import com.safb.tdd.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<User> getUsers(Integer count) throws SQLException {
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
