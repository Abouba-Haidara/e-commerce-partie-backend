package com.gescom.gescom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductImage implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob
    @Column(columnDefinition = "LONGBLOB", length = 65555)
    private byte[] image;
    private long size = 0;
    private String urlImage;
    private String extension;
    private String type;
    private String name;
    @ManyToOne
    private Product product;
}
