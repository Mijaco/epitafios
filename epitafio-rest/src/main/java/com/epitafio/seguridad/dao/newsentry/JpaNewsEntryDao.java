package com.epitafio.seguridad.dao.newsentry;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.epitafio.seguridad.dao.JpaDao;
import com.origen.spring.jpa.model.EpNewsentry;

import org.springframework.transaction.annotation.Transactional;


/**
 * JPA Implementation of a {@link NewsEntryDao}.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class JpaNewsEntryDao extends JpaDao<EpNewsentry, Long> implements NewsEntryDao
{

	public JpaNewsEntryDao()
	{
		super(EpNewsentry.class);
	}


	@Override
	@Transactional(readOnly = true)
	public List<EpNewsentry> findAll()
	{
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<EpNewsentry> criteriaQuery = builder.createQuery(EpNewsentry.class);

		Root<EpNewsentry> root = criteriaQuery.from(EpNewsentry.class);
		criteriaQuery.orderBy(builder.desc(root.get("date")));

		TypedQuery<EpNewsentry> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
