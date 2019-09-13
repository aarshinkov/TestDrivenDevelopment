package com.safb.tdd.services;

import com.safb.tdd.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * An interface declaring abstract methods for accessing the {@link com.safb.tdd.entity.User} class and making
 * operations with it.
 *
 * @author Atanas Yordanov Arshinkov
 * @see com.safb.tdd.entity.User
 * @since 1.0.0
 */
public interface UserService {


    /**
     * An abstract method for retrieving all {@link com.safb.tdd.entity.User} objects stored in the database.
     *
     * @return {@link java.util.List} collection of all {@link com.safb.tdd.entity.User} objects, stored in the database
     * @author Atanas Yordanov Arshinkov
     * @since 1.0.0
     */
    List<User> getAllUsers();

    /**
     * An abstract method for retrieving the last countable number of {@link com.safb.tdd.entity.User} objects stored in the database.
     *
     * @param count The number of {@link com.safb.tdd.entity.User} objects to be returned as a collection;
     * @return {@link java.util.List} collection of all {@link com.safb.tdd.entity.User} objects, stored in the database
     * @throws IllegalArgumentException If the count value is zero or negative
     * @throws SQLException             If the method cannot connect to the database
     * @author Atanas Yordanov Arshinkov
     * @since 1.0.0
     */
    List<User> getUsers(Integer count) throws IllegalArgumentException, SQLException;
}
