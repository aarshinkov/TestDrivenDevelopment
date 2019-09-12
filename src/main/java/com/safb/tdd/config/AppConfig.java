package com.safb.tdd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The main application configuration.
 * The {@link org.springframework.web.servlet.config.annotation.EnableWebMvc} annotation enables the MVC approach
 * for developing the application.
 * The {@link org.springframework.context.annotation.ComponentScan} annotation specifies in which package/packages
 * should the application look for a component classes, marked as either {@link org.springframework.stereotype.Component},
 * {@link org.springframework.stereotype.Controller}, {@link org.springframework.stereotype.Repository}, {@link org.springframework.stereotype.Service}
 *
 * @author Atanas Yordanov Arshinkov
 * @see org.springframework.stereotype.Component
 * @see org.springframework.stereotype.Controller
 * @see org.springframework.stereotype.Repository
 * @see org.springframework.stereotype.Service
 * @since 1.0.0
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.safb.tdd")
public class AppConfig {

}
