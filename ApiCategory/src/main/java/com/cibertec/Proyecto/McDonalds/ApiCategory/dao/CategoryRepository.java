
package com.cibertec.Proyecto.McDonalds.ApiCategory.dao;
import com.cibertec.Proyecto.McDonalds.ApiCategory.entity.CategoryMcDonalds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryMcDonalds, Long>{
    CategoryMcDonalds findByName(String categoryName);
}
