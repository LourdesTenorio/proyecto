package com.cibertec.Proyecto.McDonalds.ApiOpiniones.controller;

import com.cibertec.Proyecto.McDonalds.ApiOpiniones.entity.Opinion;
import com.cibertec.Proyecto.McDonalds.ApiOpiniones.service.OpinionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/opinion")
public class OpinionController {
    
    @Autowired
    private OpinionService opinionService;
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Opinion>> findAll(){
        return new ResponseEntity<>(opinionService.findAll(),
                HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Opinion> add(@RequestBody Opinion opinion){
        return new ResponseEntity<>(opinionService.add(opinion),
                HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        opinionService.delete(id);
    }
    
}
