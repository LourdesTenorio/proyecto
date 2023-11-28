package com.cibertec.Proyecto.McDonalds.ApiVentas.dto;

import com.cibertec.Proyecto.McDonalds.ApiVentas.entity.Boleta;
import com.cibertec.Proyecto.McDonalds.ApiVentas.entity.BoletaItem;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compra {
    private Boleta boleta;
    private Set<BoletaItem> boletaItems;
}
