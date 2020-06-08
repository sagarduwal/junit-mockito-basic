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

    OrderBOImpl bo;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        bo = new OrderBOImpl();
        bo.setOrderDAO(orderDAO);

    }

    @Test
    public void placeOrder_should_create_an_order() throws SQLException, BOException {
        Order order = new Order();
        when(orderDAO.create(order)).thenReturn(1);

        boolean result = bo.placeOrder(order);
        assertTrue(result);
        verify(orderDAO).create(order);
    }

    @Test
    public void placeOrder_should_not_create_an_order() throws SQLException, BOException {

        Order order = new Order();
        when(orderDAO.create(order)).thenReturn(0);

        boolean result = bo.placeOrder(order);
        assertFalse(result);
        verify(orderDAO).create(order);
    }

    @Test(expected = BOException.class)
    public void placeOrder_should_throw_BOException() throws SQLException, BOException {

        Order order = new Order();
        when(orderDAO.create(order)).thenThrow( SQLException.class);

        boolean result = bo.placeOrder(order);
    }

    @Test
    public void cancelOrder_should_cancel_order() throws SQLException, BOException {
        Order order = new Order();
        order.setId(1);
        order.setStatus("cancelled");

        when(orderDAO.read(order.getId())).thenReturn(order);

        when(orderDAO.update(order)).thenReturn(1);

        boolean result = bo.cancelOrder(order.getId());

        assertTrue(result);
        verify(orderDAO).read(order.getId());
        verify(orderDAO).update(order);
    }

    @Test
    public void cancelOrder_should_not_cancel_order() throws SQLException, BOException {
        Order order = new Order();
        order.setId(1);

        when(orderDAO.read(order.getId())).thenReturn(order);

        when(orderDAO.update(order)).thenReturn(0);

        boolean result = bo.cancelOrder(order.getId());

        assertFalse(result);
        verify(orderDAO).read(order.getId());
        verify(orderDAO).update(order);
    }

    @Test(expected = BOException.class)
    public void cancelOrder_should_throw_BOException() throws SQLException, BOException {
        Order order = new Order();
        order.setId(1);

        when(orderDAO.read(order.getId())).thenThrow(new SQLException());

//        when(orderDAO.update(order)).thenReturn(0);

        boolean result = bo.cancelOrder(order.getId());

    }

    @Test(expected = BOException.class)
    public void cancelOrder_should_throw_BOException_on_update() throws SQLException, BOException {
        Order order = new Order();
        order.setId(1);

        when(orderDAO.read(order.getId())).thenReturn(order);

        when(orderDAO.update(order)).thenThrow(new SQLException());

        boolean result = bo.cancelOrder(order.getId());

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