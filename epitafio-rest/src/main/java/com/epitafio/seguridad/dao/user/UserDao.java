package com.epitafio.seguridad.dao.user;

import com.epitafio.seguridad.dao.Dao;
import com.origen.spring.jpa.model.EpUser;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserDao extends Dao<EpUser, String>, UserDetailsService
{

	EpUser findByName(String name);

}