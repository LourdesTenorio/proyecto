package com.cibertec.Poryecto.McDonalds.ApiPlatos.dao;

import com.cibertec.Poryecto.McDonalds.ApiPlatos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findByName(String name);
}
