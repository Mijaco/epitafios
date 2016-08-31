package com.origen.spring.jpa.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@javax.persistence.Entity
public class User implements Entity, UserDetails {

    @Id
    @Column(unique = true, length = 16, nullable = false) // indica que es pk
    private String id;

//      @Column(unique = true, length = 16, nullable = false) // indica que es pk
//    private String name;

//	@Column(length = 80, nullable = false)// indica que es pk
    private String password;
    
    private String name;

    @Column(length = 80, nullable = true)
    private String rutaInicial;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<Role>();

    protected User() {
        /* Reflection instantiation */
    }

    public User(String id,String name, String passwordHash) {
        this.id = id;
        this.name = name;
        this.password = passwordHash;
    }
    public User(String id, String passwordHash) {
        this.id = id;
//        this.name = name;
        this.password = passwordHash;
    }

//    public User(String name, String passwordHash) {
////        this.name = name;
//        this.password = passwordHash;
//    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public String getRutaInicial() {
        return rutaInicial;
    }

    public void setRutaInicial(String rutaInicial) {
        this.rutaInicial = rutaInicial;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }
//
    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
