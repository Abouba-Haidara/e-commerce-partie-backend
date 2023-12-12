package com.gescom.gescom.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    private String name;
    private String email;
    private String address;
    private String telephone;
    private String code;
    private String birthDay;
    private String raisonSocial;
    private String accountBank;
}
