
package com.cibertec.Poryecto.McDonalds.ApiPlatos.category;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient (name="ApiCategory", url="localhost:8083")
public interface CategoryFeing {
    @GetMapping("/api/v1/category/findCategoryById")
    public String findCategoryById(@RequestParam long id);
}
