
package pe.cibertec.ecommerce.ApiAuthentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiAuthentication.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
   User findByEmail (String email);
}
