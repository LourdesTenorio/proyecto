package pe.cibertec.ecommerce.ApiAuthentication.controller;

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
import pe.cibertec.ecommerce.ApiAuthentication.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailServiceImpl;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SingUpDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(userDto.getRoles());
        //userService.add(user);
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        try {
            UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(loginDto.getEmail());

            if (passwordEncoder.matches(loginDto.getPassword(), userDetails.getPassword())) {

                return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Usuario o contraseña inválidos", HttpStatus.UNAUTHORIZED);
            }
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>("Usuario o contraseña inválidos", HttpStatus.UNAUTHORIZED);
        }
    }

}
