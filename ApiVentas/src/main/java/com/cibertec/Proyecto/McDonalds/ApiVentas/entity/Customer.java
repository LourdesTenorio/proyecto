package com.cibertec.Proyecto.McDonalds.ApiVentas.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Customer {
    private Long idcustomer;
    private String name;
    private String email;
    private String phone;
}
