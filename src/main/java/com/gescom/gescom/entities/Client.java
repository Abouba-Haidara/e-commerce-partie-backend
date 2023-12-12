package com.gescom.gescom.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("2")
@EqualsAndHashCode(callSuper = false)
public class Client extends Person implements Serializable {
  private String code;
  private String birthDay;

}
