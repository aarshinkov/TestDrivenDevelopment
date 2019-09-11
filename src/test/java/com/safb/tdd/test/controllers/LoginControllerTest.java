package com.safb.tdd.test.controllers;

import com.safb.tdd.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class LoginControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mock;

    @Before
    public void setup() {
        this.mock = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void loginPageTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        ResultMatcher view = MockMvcResultMatchers.view().name("login/login");
        ResultMatcher globalMenuAttribute = MockMvcResultMatchers.model().attribute("globalMenu", "login");
        ResultMatcher submenuAttribute = MockMvcResultMatchers.model().attribute("submenu", "login");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/login");

        this.mock.perform(builder)
                .andExpect(ok)
                .andExpect(view)
                .andExpect(globalMenuAttribute)
                .andExpect(submenuAttribute)
                .andReturn();
    }
}
