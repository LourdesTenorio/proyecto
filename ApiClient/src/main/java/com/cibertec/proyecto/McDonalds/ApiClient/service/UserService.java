package com.cibertec.proyecto.McDonalds.ApiClient.service;

import com.cibertec.proyecto.McDonalds.ApiClient.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<User> findAll();
    public User findById(Long idcustomer);
    public User findByName(String name);
    public User add(User customers);
    public void delete(Long idcustomer);
    public User findByEmail (String email);
    public User update(User user);
    public String findClienteById(Long clienteId);
}
