/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.origen.hibernate.dao.general;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mijail Aymara
 */
public interface BaseDao<T, PK extends Serializable> {
    
        public void agregar(T p);
	public void actualizar(T p);
	public List<T> listar();
	public T getById(PK pk);
	public void remover(PK pk);
        public List<T> listarQueryNativo(String queryNativo);
}
