package com.trustgeek;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class ATest {

    @Mock
    B b;
    private A a;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        a= new A(b);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void usesVoidMethod_call_the_void_method() throws  Exception{
        a.usesVoidMethod();

        verify(b).voidMethod();
    }

    @Test(expected = RuntimeException.class)
    public void usesVoidMethod_call_the_void_method_throw_runtime_exception() throws  Exception{
        doThrow(Exception.class).when(b).voidMethod();
        a.usesVoidMethod();
    }

    @Test
    public void usesVoidMethod_call_the_void_method_with_do_nothing() throws  Exception{
        doNothing().when(b).voidMethod();
        a.usesVoidMethod();
        verify(b).voidMethod();
    }


    @Test(expected = RuntimeException.class)
    public void usesVoidMethod_call_consicutively() throws  Exception{
        doNothing().doThrow(Exception.class).when(b).voidMethod();
        a.usesVoidMethod();

        verify(b).voidMethod();
        a.usesVoidMethod();

    }

}