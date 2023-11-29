package com.cibertec.Proyecto.McDonalds.ApiVentas.entity;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Embeddable
public class Items {
    private Long idProduct;
    private String name;
    private BigDecimal price;
    private BigDecimal quantity;
}
