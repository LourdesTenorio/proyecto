package com.cibertec.Proyecto.McDonalds.ApiVentas.service;

import com.cibertec.Proyecto.McDonalds.ApiVentas.dao.BoletaRepository;
import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.Compra;
import com.cibertec.Proyecto.McDonalds.ApiVentas.dto.CompraResponse;
import com.cibertec.Proyecto.McDonalds.ApiVentas.entity.Boleta;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasServiceImpl implements VentasService{
    
    @Autowired
    private BoletaRepository boletaRepository;
    
    @Override
    @Transactional
    public CompraResponse placeVentas(Compra compras) {
        Boleta boleta = compras.getBoleta();
        boleta.setTrackingNumber(getTrackingNumber());
        compras.getBoletaItems().forEach(i->{
            boleta.addBoletaItem(i); 
        });
        boletaRepository.save(boleta);
        return 
          new CompraResponse(boleta.getTrackingNumber());
        
    }
    
    private String getTrackingNumber(){
        return UUID.randomUUID().toString();
    }
    
}
