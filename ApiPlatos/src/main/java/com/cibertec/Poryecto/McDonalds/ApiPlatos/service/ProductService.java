package com.cibertec.Poryecto.McDonalds.ApiPlatos.service;

import com.cibertec.Poryecto.McDonalds.ApiPlatos.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;


public interface ProductService {
    public List<Product> findAll();
    public Page<Product> findAll(int page,int size);
    public Product findById(Long idProduct);
    public Product findByName(String name);
    public Product add(Product product);
    public Product update(Product product);
    public void delete(Long idProduct);
}
