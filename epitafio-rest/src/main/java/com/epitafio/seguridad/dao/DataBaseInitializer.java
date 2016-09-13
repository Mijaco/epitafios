package com.epitafio.seguridad.dao;


import org.springframework.security.crypto.password.PasswordEncoder;

import com.epitafio.seguridad.dao.user.UserDao;
import com.origen.spring.jpa.entidades.Usuario;



/**
 * Initialize the database with some test entries.
 *
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class DataBaseInitializer
{

	private UserDao userDao;

	private PasswordEncoder passwordEncoder;


	protected DataBaseInitializer()
	{
		/* Default constructor for reflection instantiation */
	}

	public DataBaseInitializer(UserDao userDao, PasswordEncoder passwordEncoder)
	{
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	public void initDataBase()
	{
            
            /*T raer usuario con ROL de BD real*/
//            Usuario usuario = new Usuario("123456789-oasis", "Mijaco", this.passwordEncoder.encode("pass1"));
//            this.userDao.save(usuario);
//
//            Usuario adminUser = new Usuario("987654321-tumi", "Mijail", this.passwordEncoder.encode("pass2"));
//            this.userDao.save(adminUser);
	}

}