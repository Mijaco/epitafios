/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.serial;

import com.origen.spring.jpa.model.EpUser;
import com.origen.spring.jpa.model.Role;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Mijail Aymara
 */
public class UserLoad implements Serializable, UserDetails {

    private String id;
    private String password;
    private String name;
    private String rutaInicial;
    private Set<Role> roles = new HashSet<Role>();

    public UserLoad(EpUser epUser) {
        id = epUser.getId();
        name = epUser.getName();
        password = epUser.getPassword();
        rutaInicial = epUser.getRutaInicial();
    }

    public UserLoad(String id, String name, String passwordHash) {
        this.id = id;
        this.name = name;
        this.password = passwordHash;
    }

    public UserLoad(String id, String passwordHash) {
        this.id = id;
        this.password = passwordHash;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.getRoles();
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
}
