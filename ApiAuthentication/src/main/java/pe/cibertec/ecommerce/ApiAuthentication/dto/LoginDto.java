
package pe.cibertec.ecommerce.ApiAuthentication.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
