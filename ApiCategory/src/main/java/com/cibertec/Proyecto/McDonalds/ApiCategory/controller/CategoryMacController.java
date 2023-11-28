
package com.cibertec.Proyecto.McDonalds.ApiCategory.controller;

import com.cibertec.Proyecto.McDonalds.ApiCategory.service.CategoryMacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import com.cibertec.Proyecto.McDonalds.ApiCategory.entity.CategoryMcDonalds;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/category")
public class CategoryMacController {
    
    @Autowired
    private CategoryMacService categoryService;
    
    @GetMapping("/findAll/page/{page}/size/{size}")
    public ResponseEntity<Page<CategoryMcDonalds>> findAll(@PathVariable int page,@PathVariable int size){
        return new ResponseEntity<>(categoryService.findAll(page, size),HttpStatus.OK);
    } 
    
    @GetMapping("/findAll")
    public ResponseEntity<List<CategoryMcDonalds>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(),
                HttpStatus.OK);
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<CategoryMcDonalds> findById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }
    
    @GetMapping("/findByCategoryName/{categoryName}")
    public ResponseEntity<CategoryMcDonalds> findByName(@PathVariable String productName){
        return new ResponseEntity<>(categoryService.findByName(productName),HttpStatus.OK);
    }
    
    
    @PostMapping("/add")
    public ResponseEntity<CategoryMcDonalds> add(@RequestBody CategoryMcDonalds categoryMc){
        return new ResponseEntity<>(categoryService.add(categoryMc),HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<CategoryMcDonalds> update(@RequestBody CategoryMcDonalds categoryMc){
        return new ResponseEntity<>(categoryService.update(categoryMc),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
    @GetMapping("/findCategoryById")
    public String findCategoryById(@RequestParam long id){
        return categoryService.findCategoryById(id);
    }
}
