package com.gescom.gescom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    private double price;
    @Column(unique = true)
    private String code;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    Collection<OrderItem> orderItems = new ArrayList<>();
}
