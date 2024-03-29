package com.gescom.gescom.services;

import com.gescom.gescom.entities.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order) ;
    void delete(long id);
    Order editOrder(Order order, long id);
    List<Order> findAllOrder();
    Order findOrder(long id);
    void deleteAll();
}
