
package pe.cibertec.ecommerce.ApiAuthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiAuthentication.dao.UserRepository;
import pe.cibertec.ecommerce.ApiAuthentication.entity.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User findByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }
    
}
