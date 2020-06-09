package com.trustgeek;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Spy
    List<String> stringList = new ArrayList<String>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList_real_adding_items_different_result() {
        stringList.add("Sagar");
        stringList.add("Duwal");

        Mockito.doReturn(3).when(stringList).size();
        assertSame(3, stringList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testList_testing_when_method_with_spy_object_to_mock_get_from_list() {
        /*
         * This will fail because by default when using `spy` it calls real method, which is used for partial mocking
         * */

        Mockito.when(stringList.get(0)).thenReturn("Sagar");
        assertSame("Sagar", stringList.get(0));
    }

    @Test
    public void testList_testing_when_method_to_mock_get_from_list() {
        Mockito.doReturn("Sagar").when(stringList).get(0);
        assertSame("Sagar", stringList.get(0));
    }

    @Test
    public void testList_call_real_method_for_mock() {
        stringList.add("Sagar");
        stringList.add("Duwal");

        Mockito.when(stringList.size()).thenCallRealMethod();
        assertSame(2, stringList.size());
    }
}
