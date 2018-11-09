//package com.staff.web;
//
//import com.staff.api.dao.IUserDao;
//import com.staff.api.entity.User;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class UserControllerTest {
//
//    UserController controller;
//
//    @Before
//    public void setUp() {
//        controller = new UserController();
//    }
//
//    @Test
//    public void showAllUsers() throws IOException {
//        IUserDao userDao = mock(IUserDao.class);
//        User user = generateUser();
//        when(userDao.FindWithPaging(any(), any(), anyInt(), anyInt()))
//                .thenReturn(List.of(user));
//
//        controller.userDao = userDao;
//
//        List<User> users = controller.showAllUsers("null", "name", "asc", 1, 20);
//
//        assertEquals(users.size(), 1);
//        assertEquals(users.get(0), user);
//    }
//
//    private User generateUser() {
//        User user = new User();
//        user.setName("Alex");
//        user.setSurname("Kolonit");
//        user.setPassword("qweqweqwe");
//
//        return user;
//    }
//}