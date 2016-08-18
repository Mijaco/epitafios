package com.origen.hibernate.service;

import com.origen.hibernate.dao.UsuarioDAO;
import com.origen.hibernate.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioPruebaImpl implements ServicioPrueba {
    
    private UsuarioDAO usuarioDAO;// ya posee cargado la Session

    @Override
    @Transactional
    public List<String> obtenerPerfilesPorUsuario(String id){
//        Usuario user = this.usuarioDAO.getById(id);
//        String pass = this.usuarioDAO.obtenerPasswordUsuario(id);
//        List<Usuario> usuarios = this.usuarioDAO1.listar();
//        UsuarioBean usuarioBean = new UsuarioBean(user);
//        System.out.println("Email: "  + usuarioBean.getUserEmail());
//        System.out.println("Pass: "  + pass);
//        System.out.println("usuarios: "  + usuarios);
//        System.out.println("usuarios " + usuarios);
        
        return new ArrayList<String>();
    }

    @Override
       public Usuario obtenerEntidadPrueba(String id){
        Usuario user = (Usuario)this.usuarioDAO.getById(id);
        
        
//        List<Usuario> users = (List<Usuario>)this.usuarioDAO.listarQueryNativo("Select * from Intusuario_seg");
//        Usuario user = users.get(0);
        user = new Usuario(user);
        
        System.out.println("first user: " + user.toString());

        return user;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
//
//    @Override
//    @Transactional
//    public void addUsuario(Usuario p) {
//        this.usuarioDAO.addUsuario(p);
//    }
//
//    @Override
//    @Transactional
//    public void updateUsuario(Usuario p) {
//        this.usuarioDAO.updateUsuario(p);
//    }
//
//    @Override
//    @Transactional
//    public List<Usuario> listUsuarios() {
//        return this.usuarioDAO.listUsuarios();
//    }

   

//    @Override
//    @Transactional
//    public void removeUsuario(String id) {
//        this.usuarioDAO.removeUsuario(id);
//    }

    
    //getter and setter
    
      public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }
      public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
