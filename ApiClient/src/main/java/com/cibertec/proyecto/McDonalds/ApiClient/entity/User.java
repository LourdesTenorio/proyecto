package com.cibertec.proyecto.McDonalds.ApiClient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Idcustomer;
    private String name;
    private String userName;
    private String email;
    private String password;
    @ManyToMany 
    @JoinTable(name="User_Role",                 
            joinColumns = @JoinColumn(name="user_id",referencedColumnName = "Idcustomer"), 
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
            )
    private Set<Role> roles;
    private String Direcc;
    private String Phone;
}
