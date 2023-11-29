package com.cibertec.Proyecto.McDonalds.ApiVentas.controller;

import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.Compra;
import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.CompraResponse;
import com.cibertec.Proyecto.McDonalds.ApiVentas.service.VentasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/ventas")
public class VentasController {
    @Autowired
    private VentasService ventasService;
    
    @PostMapping("/palceVentas")
    public CompraResponse placeVenta(@RequestBody Compra compra){
            log.info("Registrando nueva venta: {}", compra);

        return ventasService.placeVentas(compra);
    }
    
}
