
package com.cibertec.Proyecto.McDonalds.ApiCategory.service;

import com.cibertec.Proyecto.McDonalds.ApiCategory.dao.CategoryRepository;
import com.cibertec.Proyecto.McDonalds.ApiCategory.entity.CategoryMcDonalds;
import com.cibertec.Proyecto.McDonalds.ApiCategory.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class CategoryMacServiceImpl implements CategoryMacService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    
    @Override
    public List<CategoryMcDonalds> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<CategoryMcDonalds> findAll(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public CategoryMcDonalds findById(Long id) {
         var message="Category with id = " + id.toString() + " not found";
        return categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(message));
    }

    @Override
    public CategoryMcDonalds findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public CategoryMcDonalds add(CategoryMcDonalds categoryMc) {
         return categoryRepository.save(categoryMc);
    }

    @Override
    public CategoryMcDonalds update(CategoryMcDonalds categoryMc) {
         var catMc = categoryRepository.findById(categoryMc.getIdCategory()).get();
         catMc.setName(categoryMc.getName());
         catMc.setImagen(categoryMc.getImagen());        
         return categoryRepository.save(catMc);
    }

    @Override
    public void delete(Long id) {
        var categoryMc = categoryRepository.findById(id).get();
        categoryRepository.delete(categoryMc);
    }

    @Override
    public String findCategoryById(Long categoryId) {
        CategoryMcDonalds usuar= categoryRepository.findById(categoryId).get();
        String nombre= usuar.getName();
        return nombre;
    }
    
}
