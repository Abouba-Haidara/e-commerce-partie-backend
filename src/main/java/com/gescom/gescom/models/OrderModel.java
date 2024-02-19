package com.gescom.gescom.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
    private long id;
    private Date date;
    private String orderNumber;
    private double amount;
    private long clientId;
    private long paymentId;
}
