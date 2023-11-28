package com.cibertec.Proyecto.McDonalds.ApiVentas.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoletaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boletaItemId;
    @Embedded
    private Items item;
    private BigDecimal discount;
    private BigDecimal subTotal;
    @ManyToOne
    @JoinColumn(name = "boletaId")
    private Boleta boleta;
}
