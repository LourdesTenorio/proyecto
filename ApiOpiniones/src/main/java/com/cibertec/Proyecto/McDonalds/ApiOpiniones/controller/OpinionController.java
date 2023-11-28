package com.cibertec.Proyecto.McDonalds.ApiOpiniones.controller;

import com.cibertec.Proyecto.McDonalds.ApiOpiniones.cliente.ClienteFeing;
import com.cibertec.Proyecto.McDonalds.ApiOpiniones.entity.Opinion;
import com.cibertec.Proyecto.McDonalds.ApiOpiniones.service.OpinionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/opinion")
public class OpinionController {
    
    @Autowired
    private OpinionService opinionService;
    @Autowired
    private ClienteFeing clienteFeing;
    
   @GetMapping("/findAll/page/{page}/size/{size}")
    public ResponseEntity<Page<Opinion>> findAll(@PathVariable int page, @PathVariable int size){
        return new ResponseEntity<>(opinionService.findAll(page, size), HttpStatus.OK);
    }

    
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Opinion opinion){
        Long id = opinion.getIdCliente();
        return new ResponseEntity<>("El cliente: "+clienteFeing.findClienteById(id) +" realizo la siguiente opinion "+ opinionService.add(opinion),
                HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        opinionService.delete(id);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Opinion>> findAll(){
        return new ResponseEntity<>(opinionService.findAll(),
                HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Opinion> findById(@PathVariable Long id){
        return new ResponseEntity<>(opinionService.findById(id),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Opinion> update(@RequestBody Opinion opiniones){
        return new ResponseEntity<>(opinionService.update(opiniones),HttpStatus.OK);
    }

}
