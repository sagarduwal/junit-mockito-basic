package com.trustgeek.bo;

import com.trustgeek.dao.Order;

public interface OrderBO {
    boolean placeOrder(Order order) throws  BOException;
    boolean cancelOrder(int id) throws  BOException;
    boolean deleteOrder(int id) throws  BOException;
}
