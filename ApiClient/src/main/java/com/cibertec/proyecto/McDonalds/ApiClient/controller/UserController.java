package com.cibertec.proyecto.McDonalds.ApiClient.controller;

import com.cibertec.proyecto.McDonalds.ApiClient.entity.User;
import com.cibertec.proyecto.McDonalds.ApiClient.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        log.info("Añadiendo nuevo usuario: {}", user.getEmail());

        return userService.add(user);
    }

    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam String email) {
        log.info("Buscando usuario por correo electrónico: {}", email);

        return userService.findByEmail(email);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        log.info("Obteniendo todos los usuarios.");

        return userService.findAll();
    }

    @GetMapping("/findClienteById")
    public String findClienteById(@RequestParam long id) {
        log.info("Buscando cliente por ID: {}", id);

        return userService.findClienteById(id);
    }

    @GetMapping("/findById")
    public User findById(@RequestParam long id) {
        log.info("Buscando usuario por ID: {}", id);

        return userService.findById(id);
    }

    @GetMapping("/findByName")
    public User findByName(@RequestParam String name) {
        log.info("Buscando usuario por nombre: {}", name);

        return userService.findByName(name);
    }

    @PutMapping("/update")
    public User update(@RequestBody User use) {
        log.info("Actualizando información de usuario con ID: {}", use.getIdcustomer());

        return userService.update(use);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam long id) {
        log.info("Eliminando usuario con ID: {}", id);

        userService.delete(id);
    }
}
