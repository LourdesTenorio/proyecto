
package pe.cibertec.ecommerce.ApiAuthentication.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pe.cibertec.ecommerce.ApiAuthentication.entity.User;

@FeignClient (name="ApiClient", url="localhost:8085")
public interface ClienteFeingClient {
    @PostMapping("api/v1/user/add")
    public User add(@RequestBody User user);
    
    @GetMapping("api/v1/user/findByEmail")
    public User findByEmail(@RequestParam String email);
}
