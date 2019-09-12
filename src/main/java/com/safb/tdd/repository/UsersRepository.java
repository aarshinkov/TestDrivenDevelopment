package com.safb.tdd.repository;

import com.safb.tdd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This interface serves as a predefined repository which you can execute base operations on {@link com.safb.tdd.entity.User} entity
 *
 * @author Atanas Arshinkov
 * @see com.safb.tdd.entity.User
 * @since 1.0.0
 */
@Component
public interface UsersRepository extends JpaRepository<User, Integer> {

    /**
     * @return {@link java.util.List} of all {@link com.safb.tdd.entity.User} entity objects, stored in the database.
     * @author Atanas Yordanov Arshinkov
     * @see java.util.List
     * @see com.safb.tdd.entity.User
     * @since 1.0.0
     */
    @Override
    List<User> findAll();
}
