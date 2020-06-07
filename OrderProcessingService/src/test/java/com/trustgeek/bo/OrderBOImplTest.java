package com.trustgeek.bo;

import com.trustgeek.dao.Order;
import com.trustgeek.dao.OrderDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class OrderBOImplTest {

    @Mock
    OrderDAO orderDAO;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void placeOrder_should_create_an_order() throws SQLException, BOException {
        OrderBOImpl bo = new OrderBOImpl();
        bo.setOrderDAO(orderDAO);

        Order order = new Order();
        when(orderDAO.create(order)).thenReturn(1);

        boolean result = bo.placeOrder(order);
        assertTrue(result);
        verify(orderDAO).create(order);
    }

    @Test
    public void cancelOrder() {
    }

    @Test
    public void deleteOrder() {
    }

    @Test
    public void getOrderDAO() {
    }

    @Test
    public void setOrderDAO() {
    }
}