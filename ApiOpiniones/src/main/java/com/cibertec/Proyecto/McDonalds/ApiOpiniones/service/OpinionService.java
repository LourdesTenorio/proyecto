package com.cibertec.Proyecto.McDonalds.ApiOpiniones.service;

import com.cibertec.Proyecto.McDonalds.ApiOpiniones.entity.Opinion;
import java.util.List;
import org.springframework.data.domain.Page;


public interface OpinionService {
    
    public List<Opinion> findAll();
    public Page<Opinion> findAll(int page, int size);
    public Opinion findById (Long id);
    public Opinion add(Opinion opiniones);
    public Opinion update(Opinion opiniones);
    public void delete(Long id);

}
