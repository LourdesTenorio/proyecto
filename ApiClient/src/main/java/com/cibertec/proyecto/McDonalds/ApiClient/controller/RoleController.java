
package com.cibertec.proyecto.McDonalds.ApiClient.controller;

import com.cibertec.proyecto.McDonalds.ApiClient.entity.Role;
import com.cibertec.proyecto.McDonalds.ApiClient.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    @Autowired
    private RoleService rolService;
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Role>> findAll(){
        return new ResponseEntity<>( rolService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/addRole")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        return new ResponseEntity<>(rolService.addRole(role), HttpStatus.CREATED);
    }
    
   
}