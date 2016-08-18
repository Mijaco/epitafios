/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.model;

/**
 *
 * @author Mijail Aymara
 */



import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "INTUSUARIO_SEG")
public class UsuarioJPA implements Serializable { 

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "USER_NOMBR")
    private String name;
    @Basic(optional = false)
    @Column(name = "USER_APELL")
    private String country;
    @Basic(optional = false)
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Basic(optional = false)
    @Column(name = "USER_PASSW")
    private String userPassw;
    @Column(name = "USER_FEUCH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userFeuch;
    @Column(name = "USER_FEULG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userFeulg;
    @Column(name = "USER_IP")
    private String userIp;
    @Column(name = "USER_ESTAD")
    private Character userEstad;
    @Column(name = "USER_BLOCK")
    private Character userBlock;
    @Column(name = "USER_FEBLK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userFeblk;
    @Column(name = "USER_NFAIL")
    private Short userNfail;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intusuarioSeg", fetch = FetchType.LAZY)
//    private List<IntcamuserSeg> intcamuserSegList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intusuarioSeg", fetch = FetchType.LAZY)
//    private List<IntperfusaSeg> intperfusaSegList;
    public UsuarioJPA(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
    
     public UsuarioJPA(UsuarioJPA usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.country = usuario.getCountry();
    
    }

    
    
    public UsuarioJPA() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
  
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassw() {
        return userPassw;
    }

    public void setUserPassw(String userPassw) {
        this.userPassw = userPassw;
    }

    public Date getUserFeuch() {
        return userFeuch;
    }

    public void setUserFeuch(Date userFeuch) {
        this.userFeuch = userFeuch;
    }

    public Date getUserFeulg() {
        return userFeulg;
    }

    public void setUserFeulg(Date userFeulg) {
        this.userFeulg = userFeulg;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Character getUserEstad() {
        return userEstad;
    }

    public void setUserEstad(Character userEstad) {
        this.userEstad = userEstad;
    }

    public Character getUserBlock() {
        return userBlock;
    }

    public void setUserBlock(Character userBlock) {
        this.userBlock = userBlock;
    }

    public Date getUserFeblk() {
        return userFeblk;
    }

    public void setUserFeblk(Date userFeblk) {
        this.userFeblk = userFeblk;
    }

    public Short getUserNfail() {
        return userNfail;
    }

    public void setUserNfail(Short userNfail) {
        this.userNfail = userNfail;
    }

//    public List<IntcamuserSeg> getIntcamuserSegList() {
//        return intcamuserSegList;
//    }
//
//    public void setIntcamuserSegList(List<IntcamuserSeg> intcamuserSegList) {
//        this.intcamuserSegList = intcamuserSegList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

  
    public String toString(){
        System.out.println("nombre: " + name);
        System.out.println("id: " + id);
        
        String cadena = id + name;
        return cadena;
    }

//    public List<IntperfusaSeg> getIntperfusaSegList() {
//        return intperfusaSegList;
//    }
//
//    public void setIntperfusaSegList(List<IntperfusaSeg> intperfusaSegList) {
//        this.intperfusaSegList = intperfusaSegList;
//    }
}


