package com.cibertec.Poryecto.McDonalds.ApiPlatos.service;

import com.cibertec.Poryecto.McDonalds.ApiPlatos.dao.ProductRepository;
import com.cibertec.Poryecto.McDonalds.ApiPlatos.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Product findById(Long idProduct) {
        return productRepository.findById(idProduct).get();
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        var platosBD = productRepository.findById(product.getIdProduct()).get();
        platosBD.setName(product.getName());
        platosBD.setImg(product.getImg());
        platosBD.setPrice(product.getPrice());
        platosBD.setIdcategory(product.getIdcategory());
        return productRepository.save(platosBD);
    }

    @Override
    public void delete(Long idProduct) {
        var platosBD = productRepository.findById(idProduct).get();
        productRepository.delete(platosBD);
    }
    
}
