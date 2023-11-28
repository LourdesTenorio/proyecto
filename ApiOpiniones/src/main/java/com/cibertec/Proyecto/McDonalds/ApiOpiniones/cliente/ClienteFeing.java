
package com.cibertec.Proyecto.McDonalds.ApiOpiniones.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient (name="ApiClient", url="localhost:8085")
public interface ClienteFeing {
    @GetMapping("api/v1/user/findClienteById")
    public String findClienteById(@RequestParam long id);
}
