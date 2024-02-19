package com.gescom.gescom.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String title;
    private double price;
    @Column(unique = true)
    private String code;
    private boolean promotion = false;
    private boolean selected =  false;
    private boolean available = false;
    @Transient
    private int quantity = 1;
    @ManyToOne
    private Category category;
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    Collection<OrderItem> orderItems = new ArrayList<>();
    private String defaultImage="https://img.freepik.com/premium-vector/default-image-icon-vector-missing-picture-page-website-design-mobile-app-no-photo-available_87543-11093.jpg";
    @OneToMany(mappedBy = "product")
    private Collection<ProductImage> images = new ArrayList<>();
}
