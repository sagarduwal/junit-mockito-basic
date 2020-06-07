package com.trustgeek.junit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
public class GreetingsImplTest {

    private Greetings greetings;

    @BeforeEach
    public void setUp() throws Exception {
        greetings = new GreetingsImpl();
    }

    @Test
    public void greetShouldReturnValidOutput() {
        String result = greetings.greet("junit");

        assertNotNull(result);
        assertEquals("Hello junit", result);
    }

    @Test
    public void greetShouldThrowException_for_null_name() {

        assertThrows(IllegalArgumentException.class, () -> {
            greetings.greet(null);
        });
    }

    @Test
    public void greetShouldThrowException_for_empty_name() {

        assertThrows(IllegalArgumentException.class, () -> {
            greetings.greet("");
        });
    }

    @AfterEach
    public void teardown() {
        greetings = null;
    }
}