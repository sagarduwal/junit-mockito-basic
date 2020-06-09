package com.trustgeek;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ComputationImplTest {

    int num1;
    int num2;
    int expectedResult;

    public ComputationImplTest(int num1, int num2, int expectedResult) {
        this.num1 = num1;
        this.num2 = num2;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() throws Exception {
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[][]{{-1, 2, 1}, {1, 2, 3}, {6, 7, 13}});
    }

    @Test
    public void add_should_return_a_result() {
        ComputationImpl computation = new ComputationImpl();
        int result = computation.add(10, 20);
        assertEquals(30, result);
    }

    @Test
    public void add_should_return_a_result_parameterized() {
        ComputationImpl computation = new ComputationImpl();
        int result = computation.add(num1, num2);
        assertEquals(expectedResult, result);
    }
}