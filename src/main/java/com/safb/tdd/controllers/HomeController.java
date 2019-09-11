package com.safb.tdd.controllers;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @param model Takes automatically the model and it is present
     *              in the method for adding different kind of attributes
     * @return the main Home view
     */
    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("globalMenu", "home");
        model.addAttribute("submenu", "home");

        return "home";
    }

    /**
     * @param model Takes automatically the model and it is present
     *              in the method for adding attributes
     * @return the About view
     */
    @GetMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("globalMenu", "home");
        model.addAttribute("submenu", "about");

        return "about";
    }
}
