package com.safb.tdd.controllers;

import com.safb.tdd.entity.User;
import com.safb.tdd.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UsersController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users", params = "count", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getUsersCount(@RequestParam("count") Integer count) throws SQLException {
        return userService.getUsers(count);
    }
}
