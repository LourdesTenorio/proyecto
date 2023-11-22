
package pe.cibertec.ecommerce.ApiAuthentication.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiAuthentication.entity.User;


public interface UserService {
    public User findByEmail(String email);
    public User add(User user);
}
