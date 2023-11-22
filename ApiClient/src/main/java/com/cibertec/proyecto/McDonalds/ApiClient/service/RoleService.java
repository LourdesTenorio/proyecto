
package com.cibertec.proyecto.McDonalds.ApiClient.service;

import com.cibertec.proyecto.McDonalds.ApiClient.entity.Role;
import java.util.List;


public interface RoleService {
    public List<Role> findAll();
    public Role addRole(Role role);
}
