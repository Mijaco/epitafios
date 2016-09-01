/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.model;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author UserTBS1
 */
@javax.persistence.Entity
@Table(name = "EP_USER")
public class EpUser implements Entity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String id;
    @Column(name = "USER_PASS")
    private String password;
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "USER_PATH")
    private String rutaInicial;

    public EpUser() {
    }

//     @ElementCollection(fetch = FetchType.EAGER)
//    private Set<Role> rolesPosibles = new HashSet<Role>();


    public EpUser(String id,String name, String passwordHash) {
        this.id = id;
        this.name = name;
        this.password = passwordHash;
    }
    public EpUser(String id, String passwordHash) {
        this.id = id;
//        this.name = name;
        this.password = passwordHash;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public Set<Role> getRoles() {
//        return this.roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public void addRole(Role role) {
//        this.roles.add(role);
//    }

//     public void addRole(Role role) {
//        this.rolesPosibles.add(role);
//    }
//    
//    public Set<Role> getRolesPosibles() {
//        return rolesPosibles;
//    }
//
//    public void setRolesPosibles(Set<Role> rolesPosibles) {
//        this.rolesPosibles = rolesPosibles;
//    }

    
    
    public String getRutaInicial() {
        return rutaInicial;
    }

    public void setRutaInicial(String rutaInicial) {
        this.rutaInicial = rutaInicial;
    }

//    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        return this.getRoles();
//        return this.getRolesPosibles();
//    }
////
//    @Override
//    public String getUsername() {
//        return this.id;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EpUser)) {
            return false;
        }
        EpUser other = (EpUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.origen.spring.jpa.model.EpUser[ id=" + id + " ]";
    }
    
}
