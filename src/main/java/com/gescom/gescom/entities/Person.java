package com.gescom.gescom.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",
        discriminatorType = DiscriminatorType.INTEGER)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public abstract class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -8885817712041252438L;
    @Id @GeneratedValue(strategy =GenerationType.AUTO)
    long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephone;
    @Column(length = 100)
    private String address;
}
