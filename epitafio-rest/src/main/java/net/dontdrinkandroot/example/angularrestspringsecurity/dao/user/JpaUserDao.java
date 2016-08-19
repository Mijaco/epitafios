package net.dontdrinkandroot.example.angularrestspringsecurity.dao.user;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.JpaDao;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


public class JpaUserDao extends JpaDao<User, String> implements UserDao
{

	public JpaUserDao()
	{
		super(User.class);
	}


	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException
	{
            
               System.out.println("id : " + id);
		User user = this.find(id);
		if (null == user) {
			throw new UsernameNotFoundException("usuario con " + id + " no encontrada");
		}

		return user;
	}


	@Override
	@Transactional(readOnly = true)
	public User findByName(String name)
	{
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = builder.createQuery(this.entityClass);

		Root<User> root = criteriaQuery.from(this.entityClass);
		Path<String> namePath = root.get("name");
		criteriaQuery.where(builder.equal(namePath, name));

		TypedQuery<User> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		List<User> users = typedQuery.getResultList();

		if (users.isEmpty()) {
			return null;
		}

		return users.iterator().next();
	}

}
