package pe.cibertec.ecommerce.ApiAuthentication.dto;

import java.util.Set;
import lombok.Data;
import pe.cibertec.ecommerce.ApiAuthentication.entity.Role;

@Data
public class SingUpDto {
    
    private String name;
    private String userName;
    private String email;
    private String password;
    private Set<Role> roles;
    private String Direcc;
    private String Phone;
}
