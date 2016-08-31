/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.general;

import java.io.Serializable;
import org.springframework.data.repository.Repository;

public interface BaseDaoSpringJPA<T, ID extends Serializable>
        extends Repository<T, ID> {

    
        public abstract Object save(Object obj);

    public abstract Object findOne(Serializable serializable);

    public abstract Iterable findAll();

    public abstract Long count();

    public abstract void delete(Object obj);

    public abstract boolean exists(Serializable serializable);


}
