package pe.cibertec.ecommerce.ApiAuthentication.service;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiAuthentication.cliente.ClienteFeingClient;
import pe.cibertec.ecommerce.ApiAuthentication.dao.UserRepository;
import pe.cibertec.ecommerce.ApiAuthentication.entity.User;

@Service                                                           
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClienteFeingClient userFeing;

    @Override
    public  UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeing.findByEmail(email);
        
        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }

}
