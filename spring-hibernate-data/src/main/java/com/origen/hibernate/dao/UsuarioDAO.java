package com.origen.hibernate.dao;

import com.origen.hibernate.dao.general.BaseDao;
import com.origen.hibernate.model.Usuario;


public interface UsuarioDAO extends BaseDao<Usuario,String>{
    
    /*metodos no comunes entre los daos*/
    public String obtenerPasswordUsuario(String id);
        
    
    
}
