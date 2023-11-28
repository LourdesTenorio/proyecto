package com.cibertec.Proyecto.McDonalds.ApiOpiniones.service;

import com.cibertec.Proyecto.McDonalds.ApiOpiniones.cliente.ClienteFeing;
import com.cibertec.Proyecto.McDonalds.ApiOpiniones.dao.OpinionRepository;
import com.cibertec.Proyecto.McDonalds.ApiOpiniones.entity.Opinion;
import com.cibertec.Proyecto.McDonalds.ApiOpiniones.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ClienteFeingImpl implements OpinionService{
    @Autowired
    private OpinionRepository opinionRepository;
    @Autowired
    private ClienteFeing clienteFeing;
    
    @Override
    public List<Opinion> findAll() {
        return opinionRepository.findAll();
    }

    @Override
    public Opinion add(Opinion opinion) {
        Long id = opinion.getId();
        return   opinionRepository.save(opinion);
    }

    @Override
    public void delete(Long id){
        var opinion = opinionRepository.findById(id).get();
        opinionRepository.delete(opinion);
    }

    
    @Override
    public Page<Opinion> findAll(int page, int size) {
        return opinionRepository.findAll(PageRequest.of(page, size));
    }



   @Override
    public Opinion findById(Long id) {
        var message="Opinion with id =" + id.toString() + " no encontrado";
        return opinionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(message));
    }


    @Override
    public Opinion update(Opinion Opinion) {
        var op = opinionRepository.findById(Opinion.getId()).get();
        Opinion.setComent(Opinion.getComent());
        Opinion.setIdProduct(Opinion.getIdProduct());
        return opinionRepository.save(op);
    }
    
}
