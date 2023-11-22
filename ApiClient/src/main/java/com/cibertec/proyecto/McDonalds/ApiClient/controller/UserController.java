
package com.cibertec.proyecto.McDonalds.ApiClient.controller;

import com.cibertec.proyecto.McDonalds.ApiClient.entity.User;
import com.cibertec.proyecto.McDonalds.ApiClient.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    
    @PostMapping("/add")
    public User add(@RequestBody User user) {
        
        return  userService.add(user);
    }
    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam  String email) {        
        return  userService.findByEmail(email);
    }
    @GetMapping("/findAll")
    public List<User> findAll() {
        
        return  userService.findAll();
    }
    @GetMapping("/findById")
    public User findById(@RequestParam long id) {
        
        return  userService.findById(id);
    }
    @GetMapping("/findByName")
    public User findByName(@RequestParam String name) {
        
        return  userService.findByName(name);
    }
    @PutMapping ("/update")
    public User update(@RequestBody User use){
        return userService.update(use);
    }
    @DeleteMapping ("/delete")
    public void delete (@RequestParam long id){
        userService.delete(id);
    }
}
