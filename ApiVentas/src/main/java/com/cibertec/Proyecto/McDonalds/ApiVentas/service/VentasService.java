package com.cibertec.Proyecto.McDonalds.ApiVentas.service;

import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.Compra;
import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.CompraResponse;


public interface VentasService {
    public CompraResponse placeVentas(Compra compras);
}
