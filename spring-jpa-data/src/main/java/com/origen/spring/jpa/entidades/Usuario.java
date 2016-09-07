/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.entidades;

import com.origen.spring.jpa.model.Entity;
import com.origen.spring.jpa.model.Role;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author JuglarM
 */
@javax.persistence.Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Entity, UserDetails {
    @Id
    @Basic(optional = false)
    @Column(name = "USU_ID")
    private String usuId;
    @Column(name = "USU_NOMB")
    private String usuNomb;
    @Column(name = "USU_APELLIDO")
    private String usuApellido;
    @Column(name = "USU_CORREO")
    private String usuCorreo;
    @Column(name = "USU_TELE")
    private String usuTele;
    @Column(name = "USU_PASS")
    private String usuPass;
    @Column(name = "USU_TIPO")
    private String usuTipo;
    @Column(name = "USU_ACTI")
    private Character usuActi;
    @OneToMany(mappedBy = "usuNego", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @JoinColumn(name = "USU_NEGO", referencedColumnName = "USU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuNego;

    public Usuario() {
    }
    
    private Set<Role> roles = new HashSet<Role>();

    public Usuario(String id,String name, String passwordHash) {
        this.usuId = id;
        this.usuNomb = name;
        this.usuPass = passwordHash;
    }
    public Usuario(String id, String passwordHash) {
        this.usuId = id;
//        this.name = name;
        this.usuPass = passwordHash;
    }

    public Usuario(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuNomb() {
        return usuNomb;
    }

    public void setUsuNomb(String usuNomb) {
        this.usuNomb = usuNomb;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuTele() {
        return usuTele;
    }

    public void setUsuTele(String usuTele) {
        this.usuTele = usuTele;
    }

    public String getUsuPass() {
        return usuPass;
    }

    public void setUsuPass(String usuPass) {
        this.usuPass = usuPass;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public Character getUsuActi() {
        return usuActi;
    }

    public void setUsuActi(Character usuActi) {
        this.usuActi = usuActi;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Usuario getUsuNego() {
        return usuNego;
    }

    public void setUsuNego(Usuario usuNego) {
        this.usuNego = usuNego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.origen.spring.jpa.entidades.Usuario[ usuId=" + usuId + " ]";
    }
    
    @Override
    public String getPassword() {
        return this.usuPass;
    }

    public void setPassword(String password) {
        this.usuPass = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
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
    
    @Override
    public String getUsername() {
        return this.usuId;
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
