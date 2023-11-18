
package pe.cibertec.ecommerce.ApiAuthentication.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiAuthentication.dao.RoleRepository;
import pe.cibertec.ecommerce.ApiAuthentication.entity.Role;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
    
}
