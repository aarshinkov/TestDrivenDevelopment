package com.safb.tdd.test.controllers;

import com.safb.tdd.config.AppConfig;
import com.safb.tdd.config.ViewConfig;
import com.safb.tdd.controllers.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class HomeControllerTest {

    @Autowired
    private ViewConfig viewConfig;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mock;

    @Before
    public void setup() {

        this.mock = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void homePageTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        ResultMatcher view = MockMvcResultMatchers.view().name("home");
        ResultMatcher globalMenuAttribute = MockMvcResultMatchers.model().attribute("globalMenu", "home");
        ResultMatcher submenuAttribute = MockMvcResultMatchers.model().attribute("submenu", "home");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");

        this.mock.perform(builder)
                .andExpect(ok)
                .andExpect(view)
                .andExpect(globalMenuAttribute)
                .andExpect(submenuAttribute)
                .andReturn();
    }

    @Test
    public void aboutPageTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        ResultMatcher view = MockMvcResultMatchers.view().name("about");
        ResultMatcher globalMenuAttribute = MockMvcResultMatchers.model().attribute("globalMenu", "home");
        ResultMatcher submenuAttribute = MockMvcResultMatchers.model().attribute("submenu", "about");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/about");

        this.mock.perform(builder)
                .andExpect(ok)
                .andExpect(view)
                .andExpect(globalMenuAttribute)
                .andExpect(submenuAttribute)
                .andReturn();
    }
}
