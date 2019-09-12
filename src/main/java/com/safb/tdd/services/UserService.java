package com.safb.tdd.services;

import com.safb.tdd.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User> getUsers(Integer count) throws SQLException;
}
