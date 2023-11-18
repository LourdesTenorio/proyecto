package pe.cibertec.ecommerce.ApiAuthentication.service;

import pe.cibertec.ecommerce.ApiAuthentication.entity.User;


public interface UserService  {
    
    User findByEmail(String Email);
    User add(User user);
}
