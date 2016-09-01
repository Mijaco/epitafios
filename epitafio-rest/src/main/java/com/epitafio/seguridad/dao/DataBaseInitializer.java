package com.epitafio.seguridad.dao;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.epitafio.seguridad.dao.newsentry.NewsEntryDao;
import com.epitafio.seguridad.dao.user.UserDao;
import com.origen.spring.jpa.model.EpNewsentry;
import com.origen.spring.jpa.model.Role;
import com.origen.spring.jpa.model.EpUser;



/**
 * Initialize the database with some test entries.
 *
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class DataBaseInitializer
{

	private NewsEntryDao newsEntryDao;

	private UserDao userDao;

	private PasswordEncoder passwordEncoder;


	protected DataBaseInitializer()
	{
		/* Default constructor for reflection instantiation */
	}

	public DataBaseInitializer(UserDao userDao, NewsEntryDao newsEntryDao, PasswordEncoder passwordEncoder)
	{
		this.userDao = userDao;
		this.newsEntryDao = newsEntryDao;
		this.passwordEncoder = passwordEncoder;
	}

	public void initDataBase()
	{
            
                /*T raer usuario con ROL de BD real*/
//		EpUser userUser = new EpUser("123456789-oasis", "Mijaco",this.passwordEncoder.encode("pass1"));
////		userUser.addRole(Role.USER);
//		this.userDao.save(userUser);
//
//		EpUser adminUser = new EpUser("987654321-tumi","Mijail", this.passwordEncoder.encode("pass2"));
////		adminUser.addRole(Role.USER);
////		adminUser.addRole(Role.ADMIN);
//		this.userDao.save(adminUser);

//		long timestamp = System.currentTimeMillis() - (1000 * 60 * 60 * 24);
//		for (int i = 0; i < 10; i++) {
//                         timestamp = System.currentTimeMillis() - (1000 * 60 * 60 * 24);
//			EpNewsentry newsEntry = new EpNewsentry();
//			newsEntry.setContent("This is example content " + i);
//			newsEntry.setDate(new Date(timestamp));
//			this.newsEntryDao.save(newsEntry);
//			timestamp += 1000 * 60 * 60;
//		}
	}

}