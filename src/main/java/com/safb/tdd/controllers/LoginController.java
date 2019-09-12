package com.safb.tdd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The login controller is used for processing the login logic and for entering the application.
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Controller
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @param model Takes automatically the model when a request is made
     * @return the login page of the application
     * @author Atanas Arshinkov
     * @since 1.0.0
     */
    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("globalMenu", "login");
        model.addAttribute("submenu", "login");

        return "login/login";
    }
}
