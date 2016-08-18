/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.origen.hibernate.beans;

import com.origen.hibernate.model.Usuario;
import java.util.Date;

/**
 *
 * @author UserTBS1
 */
public class UsuarioBean {
   
    private String id;
    private String name;
    private String country;
    private String userEmail;
    private String userPassw;
    private Date userFeuch;
    private String userIp;
    private Character userEstad;
    private Character userBlock;
    private Date userFeblk;
    private Short userNfail;

    public UsuarioBean(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.country = usuario.getCountry();
        this.userEmail = usuario.getUserEmail();
        this.userPassw = usuario.getUserPassw();
        this.userFeuch = usuario.getUserFeuch();
        this.userIp = usuario.getUserIp();
        this.userEstad = usuario.getUserEstad();
        this.userBlock = usuario.getUserBlock();
        this.userFeblk = usuario.getUserFeblk();
        this.userNfail = usuario.getUserNfail();
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

    
    
}
