package com.cibertec.Proyecto.McDonalds.ApiOpiniones.dao;

import com.cibertec.Proyecto.McDonalds.ApiOpiniones.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion, Long>{
    
}
