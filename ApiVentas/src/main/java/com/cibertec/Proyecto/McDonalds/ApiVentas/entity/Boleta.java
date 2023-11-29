package com.cibertec.Proyecto.McDonalds.ApiVentas.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boletaId;
    @Embedded
    private Customer customer;
    private Date orderDate;
    private BigDecimal Amount;
    private String trackingNumber;
    @OneToMany(mappedBy = "boleta",cascade = CascadeType.ALL)
    private Set<BoletaItem> boletaItems;
    
    public void addBoletaItem(BoletaItem boletaItem){
        if (boletaItems==null){
            boletaItems=new HashSet<>();
        }
        boletaItems.add(boletaItem);
        boletaItem.setBoleta(this);
    }
}
