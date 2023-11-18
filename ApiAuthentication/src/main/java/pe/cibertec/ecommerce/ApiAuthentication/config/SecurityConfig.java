package pe.cibertec.ecommerce.ApiAuthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.cibertec.ecommerce.ApiAuthentication.dao.UserRepository;
import pe.cibertec.ecommerce.ApiAuthentication.service.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Bean
    public static PasswordEncoder passwordEncoder(){
                            //encriptador
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeHttpRequests((authorize) ->
        authorize.requestMatchers("/api/v1/role/**").permitAll().requestMatchers("/api/v1/user/signup").permitAll().anyRequest().permitAll()  );
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration
        configuration) throws Exception{
         return configuration.getAuthenticationManager();
    }
    
    
     
}
