package com.cibertec.Proyecto.McDonalds.ApiVentas.dao;

import com.cibertec.Proyecto.McDonalds.ApiVentas.entity.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoletaRepository extends JpaRepository<Boleta, Long>{
    
}
