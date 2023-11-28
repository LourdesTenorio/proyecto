
package com.cibertec.Proyecto.McDonalds.ApiCategory.service;

import com.cibertec.Proyecto.McDonalds.ApiCategory.entity.CategoryMcDonalds;
import java.util.List;
import org.springframework.data.domain.Page;



public interface CategoryMacService {
    public List<CategoryMcDonalds> findAll();
    //paginacion
    public Page<CategoryMcDonalds> findAll(int page, int size); 
    public CategoryMcDonalds findById(Long id);
    public CategoryMcDonalds findByName(String categoryName);
    public CategoryMcDonalds add(CategoryMcDonalds categoryMc);
    public CategoryMcDonalds update(CategoryMcDonalds categoryMc);   
    public void delete(Long id);
    public String findCategoryById(Long categoryId);

}
