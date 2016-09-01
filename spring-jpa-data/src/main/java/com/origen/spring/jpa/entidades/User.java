//package com.origen.spring.jpa.entidades;
//
//import com.origen.spring.jpa.model.*;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//import javax.persistence.Basic;
//
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@javax.persistence.Entity
//@Table(name = "EP_USER")
//public class User implements Entity, UserDetails {
//    @Id
//    @Basic(optional = false)
//    @Column(name = "USER_ID")
//    private Long id;
//    @Column(name = "USER_PASS")
//    private String password;
//    @Column(name = "USER_NAME")
//    private String name;
//    @Column(name = "USER_PATH")
//    private String rutaInicial;
//
//
////    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<Role> roles = new HashSet<Role>();
//
//
//    public User(String id,String name, String passwordHash) {
//        this.id = id;
//        this.name = name;
//        this.password = passwordHash;
//    }
//    public User(String id, String passwordHash) {
//        this.id = id;
////        this.name = name;
//        this.password = passwordHash;
//    }
//
//
//    public String getId() {
//        return this.id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
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
//
//    public String getRutaInicial() {
//        return rutaInicial;
//    }
//
//    public void setRutaInicial(String rutaInicial) {
//        this.rutaInicial = rutaInicial;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.getRoles();
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
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public User() {
//    }
//
//    public User(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getUserPass() {
//        return userPass;
//    }
//
//    public void setUserPass(String userPass) {
//        this.userPass = userPass;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserPath() {
//        return userPath;
//    }
//
//    public void setUserPath(String userPath) {
//        this.userPath = userPath;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (userId != null ? userId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof User)) {
//            return false;
//        }
//        User other = (User) object;
//        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.origen.spring.jpa.model.User[ userId=" + userId + " ]";
//    }
//    
//}
