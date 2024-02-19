package com.gescom.gescom.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "orders")
public class Order implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private String orderNumber;
    private double mountTotal;
    @JsonBackReference
    @OneToMany(mappedBy = "order")
    private Collection<OrderItem> orderItems = new ArrayList<>();
    @ManyToOne
    private Client client;
    @OneToOne
    private Payment payment;
}
