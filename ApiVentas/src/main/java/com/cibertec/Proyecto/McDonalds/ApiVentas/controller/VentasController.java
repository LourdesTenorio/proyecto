package com.cibertec.Proyecto.McDonalds.ApiVentas.controller;

import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.Compra;
import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.CompraResponse;
import com.cibertec.Proyecto.McDonalds.ApiVentas.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ventas")
public class VentasController {
    @Autowired
    private VentasService ventasService;
    
    @PostMapping("/placeVentas")
    public CompraResponse placeVenta(@RequestBody Compra compra){
        return ventasService.placeVentas(compra);
    }
    
}
