package com.origen.hibernate.model;
/*
 * Entidad Nativa ( Modelo ) usada por hibernate
 * 
 * @author: Mijail Aymara
 */

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable { 

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String country;

    private String userEmail;

    private String userPassw;

    private Date userFeuch;

    private Date userFeulg;
    private String userIp;
    private Character userEstad;
    private Character userBlock;
    private Date userFeblk;
    private Short userNfail;


    public Usuario(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
    
     public Usuario(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.country = usuario.getCountry();
    
    }
    
    public Usuario() {
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

}


