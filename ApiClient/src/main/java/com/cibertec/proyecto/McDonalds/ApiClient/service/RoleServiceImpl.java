
package com.cibertec.proyecto.McDonalds.ApiClient.service;

import com.cibertec.proyecto.McDonalds.ApiClient.dao.RoleRepository;
import com.cibertec.proyecto.McDonalds.ApiClient.entity.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
