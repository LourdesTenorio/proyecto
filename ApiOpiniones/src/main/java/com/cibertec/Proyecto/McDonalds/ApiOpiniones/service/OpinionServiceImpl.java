package com.cibertec.Proyecto.McDonalds.ApiOpiniones.service;

import com.cibertec.Proyecto.McDonalds.ApiOpiniones.dao.OpinionRepository;
import com.cibertec.Proyecto.McDonalds.ApiOpiniones.entity.Opinion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpinionServiceImpl implements OpinionService{

    @Autowired
    private OpinionRepository opinionRepository;
    
    @Override
    public List<Opinion> findAll() {
        return opinionRepository.findAll();
    }

    @Override
    public Opinion add(Opinion opinion) {
        return opinionRepository.save(opinion);
    }

    @Override
    public void delete(Long id){
        var opinion = opinionRepository.findById(id).get();
        opinionRepository.delete(opinion);
    }
    
}
