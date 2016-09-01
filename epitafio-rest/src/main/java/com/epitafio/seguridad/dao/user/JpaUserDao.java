package com.epitafio.seguridad.dao.user;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.epitafio.seguridad.dao.JpaDao;
import com.origen.spring.jpa.model.EpUser;
import com.origen.spring.jpa.model.Role;
import com.origen.spring.jpa.serial.UserLoad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


public class JpaUserDao extends JpaDao<EpUser, String> implements UserDao
{

	public JpaUserDao()
	{
		super(EpUser.class);
	}


	@Override
	@Transactional(readOnly = true)
	public UserLoad loadUserByUsername(String id) throws UsernameNotFoundException
	{
            
               System.out.println("id : " + id);
		EpUser user = this.find(id);
		if (null == user) {
			throw new UsernameNotFoundException("usuario con " + id + " no encontrada");
		}
                UserLoad UserLoad = new UserLoad(user);
                UserLoad.addRole(Role.ADMIN);
                UserLoad.addRole(Role.USER);
                
//                List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return UserLoad;
	}
        
        private List<GrantedAuthority> obtenerAutorizaciones(String cadenaRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// TODO:la cadena ira separada por comas
		setAuths.add(new SimpleGrantedAuthority(cadenaRoles));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	} 


	@Override
	@Transactional(readOnly = true)
	public EpUser findByName(String name)
	{
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<EpUser> criteriaQuery = builder.createQuery(this.entityClass);

		Root<EpUser> root = criteriaQuery.from(this.entityClass);
		Path<String> namePath = root.get("name");
		criteriaQuery.where(builder.equal(namePath, name));

		TypedQuery<EpUser> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		List<EpUser> users = typedQuery.getResultList();

		if (users.isEmpty()) {
			return null;
		}

		return users.iterator().next();
	}

}
