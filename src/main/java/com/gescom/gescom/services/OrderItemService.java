package com.gescom.gescom.services;

import com.gescom.gescom.entities.OrderItem;

import java.util.List;

public interface OrderItemService {
    void createOrderItem(OrderItem orderItem);
    List<OrderItem> findAll();
    void editOrderItem(OrderItem orderItem, long id);
    void delete(long id);
    void deleteAll();
}
