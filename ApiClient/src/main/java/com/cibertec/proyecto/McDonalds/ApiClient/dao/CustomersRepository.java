package com.cibertec.proyecto.McDonalds.ApiClient.dao;

import com.cibertec.proyecto.McDonalds.ApiClient.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomersRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByEmail (String email);
}
