package pe.cibertec.ecommerce.ApiAuthentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiAuthentication.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Role findByName (String name);
    
}
