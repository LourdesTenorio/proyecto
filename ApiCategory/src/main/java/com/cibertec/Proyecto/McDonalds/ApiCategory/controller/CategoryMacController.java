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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
@RequestMapping("/api/v1/category")
public class CategoryMacController {

    @Autowired
    private CategoryMacService categoryService;

    @GetMapping("/findAll/page/{page}/size/{size}")
    public ResponseEntity<Page<CategoryMcDonalds>> findAll(@PathVariable int page, @PathVariable int size) {
        log.info("Llamando a findAll con página: {} y tamaño: {}", page, size);
        return new ResponseEntity<>(categoryService.findAll(page, size), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CategoryMcDonalds>> findAll() {
        log.info("Llamando a findAll");
        return new ResponseEntity<>(categoryService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CategoryMcDonalds> findById(@PathVariable Long id) {
        log.info("Llamando a findById con id: {}", id);
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByCategoryName/{categoryName}")
    public ResponseEntity<CategoryMcDonalds> findByName(@PathVariable String categoryName) {
        CategoryMcDonalds category = categoryService.findByName(categoryName);
        if (category != null) {
            log.info("Categoría encontrada: {}", category);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            log.warn("No se encontró ninguna categoría con el nombre: {}", categoryName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryMcDonalds> add(@RequestBody CategoryMcDonalds categoryMc) {
        log.info("Llamando a add con categoryMc: {}", categoryMc);
       CategoryMcDonalds addedCategory = categoryService.add(categoryMc);
    log.info("Categoría agregada con éxito: {}", addedCategory);
    return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryMcDonalds> update(@RequestBody CategoryMcDonalds categoryMc) {
        return new ResponseEntity<>(categoryService.update(categoryMc), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Llamando a delete con id: {}", id);
    categoryService.delete(id);
    log.info("Categoría eliminada con éxito");
    }

    @GetMapping("/findCategoryById")
    public String findCategoryById(@RequestParam long id) {
        log.info("Llamando a findCategoryById con id: {}", id);
    String categoryName = categoryService.findCategoryById(id);
    if (categoryName != null) {
        log.info("Nombre de la categoría encontrada: {}", categoryName);
        return categoryName;
    } else {
        log.warn("No se encontró ninguna categoría con id: {}", id);
        return "Categoría no encontrada";
    }
    }
}
