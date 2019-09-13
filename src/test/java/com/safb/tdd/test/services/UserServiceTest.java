package com.safb.tdd.test.services;

import com.safb.tdd.config.AppConfig;
import com.safb.tdd.dao.UserDao;
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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UserDao userDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUsersTest() {
        List<User> testList = createTestUsersList();

        when(usersRepository.findAll()).thenReturn(testList);

        List<User> users = userService.getAllUsers();

        Assert.assertEquals(3, users.size());
        verify(usersRepository, times(1)).findAll();
    }

    @Test
    public void getUsersCount_PassThree_ExpectThree() throws SQLException {

        when(userDao.getUsersCount(3)).thenReturn(createUserListCount(3));

        List<User> users = userService.getUsers(3);

        Assert.assertEquals(3, users.size());

        verify(userDao, times(1)).getUsersCount(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUsersCount_PassZero_ThrowException() throws SQLException {
        userService.getUsers(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUsersCount_PassNegative_ThrowException() throws SQLException {
        userService.getUsers(-1);
    }

    private List<User> createUserListCount(Integer count) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            User user = new User();
            users.add(user);
        }

        return users;
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
