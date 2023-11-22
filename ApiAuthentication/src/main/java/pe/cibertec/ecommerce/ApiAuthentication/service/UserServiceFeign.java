
package pe.cibertec.ecommerce.ApiAuthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiAuthentication.cliente.ClienteFeingClient;
import pe.cibertec.ecommerce.ApiAuthentication.entity.User;

@Service
@Primary
public class UserServiceFeign implements UserService{

    
    @Autowired
    private ClienteFeingClient userFeing;
    
    @Override
    public User findByEmail(String Email) {
        return  userFeing.findByEmail(Email);
    }

    @Override
    public User add(User user) {
        return userFeing.add(user);
    }

    
    
}
