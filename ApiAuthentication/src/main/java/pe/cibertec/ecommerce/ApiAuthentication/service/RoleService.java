
package pe.cibertec.ecommerce.ApiAuthentication.service;

import java.util.List;
import pe.cibertec.ecommerce.ApiAuthentication.entity.Role;


public interface RoleService {
    public List<Role> findAll();
    public Role addRole(Role role);
    
}
