package com.origen.hibernate.dao;

import com.origen.hibernate.beans.UsuarioBean;
import com.origen.hibernate.dao.general.DAOGeneral;
import com.origen.hibernate.model.Usuario;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UsuarioDAOImpl extends DAOGeneral<Usuario, String> implements UsuarioDAO {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);
//    private SessionFactory sessionFactory;
    public UsuarioDAOImpl() {
        super(null);
        setReferenciaEntidad(Usuario.class);
    }

    public void setSessionFactory(SessionFactory sf) {
        System.out.println("agregando session cerrada ? : " + (sf.isClosed()));
        this.sessionFactory = sf;
        setReferenciaEntidad(Usuario.class);
    }

//    @Override
//    public Usuario getById(String id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Usuario usuarioSession = (Usuario) session.load(Usuario.class, "maymara");
//                
//        
//        return usuarioSession;
//    }
    
    
    public String obtenerPasswordUsuario(String id){
        System.out.println("  >>>  UsuarioDAOImpl <<<<<");    
        Usuario usuarioSession = (Usuario)getById(id);
        String pass = usuarioSession.getUserPassw();
        
        return pass;
    } 

}
