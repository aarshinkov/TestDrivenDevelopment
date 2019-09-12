package com.safb.tdd.repository;

import com.safb.tdd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsersRepository extends JpaRepository<User, Integer> {

    @Override
    List<User> findAll();
}
