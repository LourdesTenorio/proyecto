package pe.cibertec.ecommerce.ApiAuthentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ecommerce.ApiAuthentication.dto.LoginDto;
import pe.cibertec.ecommerce.ApiAuthentication.dto.SingUpDto;
import pe.cibertec.ecommerce.ApiAuthentication.entity.User;
import pe.cibertec.ecommerce.ApiAuthentication.service.UserDetailsServiceImpl;
import pe.cibertec.ecommerce.ApiAuthentication.service.UserServiceFeign;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserServiceFeign userFeing;

    @Autowired
    private UserDetailsServiceImpl userDetailServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SingUpDto userDto) {
        log.info("Registrando nuevo usuario: {}", userDto.getEmail());
        User user = new User();
        user.setName(userDto.getName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(userDto.getRoles());
        user.setDirecc(userDto.getDirecc());
        user.setPhone(userDto.getPhone());
        User registeredUser = userFeing.add(user);
        log.info("Usuario registrado con éxito: {}", registeredUser.getEmail());
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        log.info("Intento de inicio de sesión para el usuario: {}", loginDto.getEmail());
        try {
            UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(loginDto.getEmail());
            if (passwordEncoder.matches(loginDto.getPassword(), userDetails.getPassword())) {
                log.info("Inicio de sesión exitoso para el usuario: {}", loginDto.getEmail());
                return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
            } else {
                log.warn("Usuario o contraseña inválidos para el usuario: {}", loginDto.getEmail());
                return new ResponseEntity<>("Usuario o contraseña inválidos", HttpStatus.UNAUTHORIZED);
            }
        } catch (UsernameNotFoundException e) {
            log.warn("Usuario o contraseña inválidos para el usuario: {}", loginDto.getEmail());
            return new ResponseEntity<>("Usuario o contraseña inválidos", HttpStatus.UNAUTHORIZED);
        }
    }
}
