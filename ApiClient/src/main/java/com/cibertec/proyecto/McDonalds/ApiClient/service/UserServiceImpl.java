package com.cibertec.proyecto.McDonalds.ApiClient.service;

import com.cibertec.proyecto.McDonalds.ApiClient.dao.CustomersRepository;
import com.cibertec.proyecto.McDonalds.ApiClient.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private CustomersRepository customerRepository;

    @Override
    public List<User> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public User findById(Long idcustomer) {
       
        return customerRepository.findById(idcustomer).get();
    }

    @Override
    public User findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public User add(User customers) {
        return customerRepository.save(customers);
    }

    @Override
    public void delete(Long idcustomer) {
        var customerBD = customerRepository.findById(idcustomer).get();
        customerRepository.delete(customerBD);
    }

    @Override
    public User findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public User update(User customers) {
        var customerBD = customerRepository.findById(customers.getIdcustomer()).get();
        customerBD.setName(customers.getName());
        customerBD.setDirecc(customers.getDirecc());
        customerBD.setEmail(customers.getEmail());
        customerBD.setPhone(customers.getPhone());
        return customerRepository.save(customerBD);
    }

    @Override
    public String findClienteById(Long clienteId) {
        User usuar= customerRepository.findById(clienteId).get();
        String nombre= usuar.getName();
        return nombre;
    }

    


   
    
}
