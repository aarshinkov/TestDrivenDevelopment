package com.safb.tdd.dao;

import com.safb.tdd.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getUsersCount(Integer count) throws SQLException;

}
