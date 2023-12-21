package com.gescom.gescom.services;

import com.gescom.gescom.entities.Order;
import com.gescom.gescom.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository repository;
    OrderServiceImpl(final OrderRepository repository) {
        this.repository =  repository;
    }
    @Override
    public Order createOrder(Order order) {
        return this.repository.save(order);
    }

    @Override
    public void delete(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Order editOrder(Order order, long id) {
        Order  o = this.repository.getReferenceById(id);
        o.setMountTotal(order.getMountTotal());
        o.setPayment(order.getPayment());
        this.repository.save(o);
        return  o;
    }

    @Override
    public List<Order> findAllOrder() {
        return this.repository.findAll();
    }

    @Override
    public Order findOrder(long id) {
        return this.repository.getReferenceById(id);
    }
}
