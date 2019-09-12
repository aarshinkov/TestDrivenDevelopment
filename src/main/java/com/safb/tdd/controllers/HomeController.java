package com.safb.tdd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The main controller which the application starts from.
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @param model Takes automatically the model and it is present
     *              in the method for adding different kind of attributes
     * @return the main Home view
     * @author Atanas Yordanov Arshinkov
     * @see org.springframework.ui.Model
     * @since 1.0.0
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
