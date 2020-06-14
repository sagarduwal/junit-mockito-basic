package com.trustgeek.dao;

import com.trustgeek.util.IdGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static  org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class UserDAOTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create_should_return_user_id() {
        UserDAO userDAO = new UserDAO();

        mockStatic(IdGenerator.class);
        when(IdGenerator.generateId()).thenReturn(1);

        int result = userDAO.create(new User());
        assertEquals(1, result);
        verifyStatic();
    }
}