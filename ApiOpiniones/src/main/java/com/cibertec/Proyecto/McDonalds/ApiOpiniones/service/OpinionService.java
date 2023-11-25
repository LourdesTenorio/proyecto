package com.cibertec.Proyecto.McDonalds.ApiOpiniones.service;

import com.cibertec.Proyecto.McDonalds.ApiOpiniones.entity.Opinion;
import java.util.List;


public interface OpinionService {
    public List<Opinion> findAll();
    public Opinion add(Opinion opinion);
    public void delete(Long id);
}
