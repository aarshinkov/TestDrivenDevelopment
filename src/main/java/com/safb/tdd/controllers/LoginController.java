package com.safb.tdd.controllers;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("globalMenu", "login");
        model.addAttribute("submenu", "login");

        return "login/login";
    }
}
