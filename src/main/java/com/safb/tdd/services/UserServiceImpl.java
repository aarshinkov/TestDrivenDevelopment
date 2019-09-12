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

/**
 * The class is an implementation on the {@link com.safb.tdd.services.UserService} interface.
 * It gives the basic functionality of the methods declared in the interface.
 * The class uses the {@link com.safb.tdd.repository.UsersRepository} for executing
 * base operations with the database, e.x CRUD operations.
 *
 * @author Atanas Yordanov Arshinkov
 * @see com.safb.tdd.services.UserService
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * A {@link org.springframework.jdbc.core.JdbcTemplate} used for making a connection to the database manually.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * An autowired user repository used for accessing the database through the {@link com.safb.tdd.entity.User} entity class
     */
    @Autowired
    private UsersRepository usersRepository;


    /**
     * When the method is called it will get all  users and return it as a collection.
     *
     * @return {@link java.util.List} collection of {@link com.safb.tdd.entity.User} objects taken from the database.
     * @see com.safb.tdd.entity.User
     * @see java.util.List
     * @since 1.0.0
     */
    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    /**
     * @param count The count parameter specifies how many users should the method return
     * @return Users based on the count parameter. If the count parameter is 3, the method will return 3 instances of the {@link com.safb.tdd.entity.User} entity.
     * @throws SQLException If the method cannot connect to the database it will throw an exception
     * @see com.safb.tdd.entity.User
     * @see com.safb.tdd.services.UserService
     * @since 1.0.0
     */
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
