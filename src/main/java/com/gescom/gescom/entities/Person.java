package com.gescom.gescom.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",
        discriminatorType = DiscriminatorType.INTEGER)
public abstract class Person implements Serializable {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephone;
    @Column(length = 100)
    private String address;
}
