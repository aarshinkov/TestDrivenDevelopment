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
public class HomeControllerTest {

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
