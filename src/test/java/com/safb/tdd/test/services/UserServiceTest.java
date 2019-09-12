package com.safb.tdd.test.services;

import com.safb.tdd.config.AppConfig;
import com.safb.tdd.entity.User;
import com.safb.tdd.repository.UsersRepository;
import com.safb.tdd.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UsersRepository usersRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsers() {
        List<User> testList = createTestUsersList();

        when(usersRepository.findAll()).thenReturn(testList);

        List<User> users = userService.getAllUsers();

        Assert.assertEquals(3, users.size());
        verify(usersRepository, times(1)).findAll();
    }

    private List<User> createTestUsersList() {
        User userOne = new User();
        userOne.setUserId(1);
        userOne.setUsername("userone");
        userOne.setPassword("Hey-1234");

        User userTwo = new User();
        userTwo.setUserId(2);
        userTwo.setUsername("usertwo");
        userTwo.setPassword("User-12345");

        User userThree = new User();
        userThree.setUserId(3);
        userThree.setUsername("userthree");
        userThree.setPassword("Pinko-6654");

        List<User> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);

        return users;
    }
}
