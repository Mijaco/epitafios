package com.epitafio.seguridad.dao.newsentry;

import com.epitafio.seguridad.dao.Dao;
import com.origen.spring.jpa.model.EpNewsentry;


/**
 * Definition of a Data Access Object that can perform CRUD Operations for {@link NewsEntry}s.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
public interface NewsEntryDao extends Dao<EpNewsentry, Long>
{

}