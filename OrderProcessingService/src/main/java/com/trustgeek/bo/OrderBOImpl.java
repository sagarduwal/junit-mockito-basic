package com.trustgeek.bo;

import com.trustgeek.dao.Order;
import com.trustgeek.dao.OrderDAO;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO;

    @Override
    public boolean placeOrder(Order order) throws BOException {
        try {
            int result = orderDAO.create(order);
            if (result == 0)
                return false;
        } catch (SQLException ex) {
            throw new BOException(ex);
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int id) throws BOException {
        try {
            Order order = orderDAO.read(id);
            order.setStatus("cancelled");
            int result = orderDAO.update(order);
            if (result == 0)
                return false;
        } catch (SQLException ex) {
            throw new BOException(ex);
        }
        return true;
    }

    @Override
    public boolean deleteOrder(int id) throws BOException {
        try {
            int result = orderDAO.delete(id);
            if (result == 0)
                return false;
        } catch (SQLException ex) {
            throw new BOException(ex);
        }

        return true;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
