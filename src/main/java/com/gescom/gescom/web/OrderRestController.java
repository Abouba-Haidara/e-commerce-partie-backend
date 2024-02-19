package com.gescom.gescom.web;

import com.gescom.gescom.entities.Client;
import com.gescom.gescom.entities.Order;
import com.gescom.gescom.models.OrderModel;
import com.gescom.gescom.services.OrderService;
import com.gescom.gescom.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    final private OrderService orderService;
   final  private PersonService personService;
    OrderRestController(final OrderService orderService, final PersonService personService) {
        this.personService = personService;
        this.orderService = orderService;
    }
    @PostMapping("/orders")
    void saveOrder(@RequestBody OrderModel orderModel){
        Order order = new Order();
        order.setClient(personService.findOneClientById(orderModel.getClientId()));
        order.setDate(new Date());
        order.setOrderNumber(orderModel.getOrderNumber());
        order.setPayment(null);
        order.setMountTotal(0);
        orderService.createOrder(order);
    }
    @GetMapping("/orders")
    List<Order> findAll() {
       return this.orderService.findAllOrder();
    }

    @DeleteMapping("/orders")
    void deleteAll() {
        this.orderService.deleteAll();
    }
}
