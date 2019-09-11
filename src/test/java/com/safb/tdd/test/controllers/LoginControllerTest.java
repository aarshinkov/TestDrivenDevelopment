package com.safb.tdd.test.controllers;

import com.safb.tdd.controllers.*;
import org.junit.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;
import org.springframework.test.web.servlet.setup.*;

public class LoginControllerTest {

    private MockMvc mock;

    @Before
    public void setup() {
        this.mock = MockMvcBuilders.standaloneSetup(new LoginController()).build();
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
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
