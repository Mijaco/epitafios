package com.epitafio.seguridad.dao.user;

import com.epitafio.seguridad.dao.Dao;
import com.origen.spring.jpa.entidades.Usuario;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserDao extends Dao<Usuario, String>, UserDetailsService
{

	   Usuario findByName(String name);

}