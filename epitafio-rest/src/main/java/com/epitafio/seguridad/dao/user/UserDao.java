package com.epitafio.seguridad.dao.user;

import com.epitafio.seguridad.dao.Dao;
import com.origen.spring.jpa.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserDao extends Dao<User, String>, UserDetailsService
{

	User findByName(String name);

}