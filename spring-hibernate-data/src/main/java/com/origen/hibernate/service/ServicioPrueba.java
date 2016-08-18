package com.origen.hibernate.service;


import com.origen.hibernate.model.Usuario;
import java.util.List;

/*Clase ejemplo de servicio , puede obtener datos del Usuario u otra entidades (en este caso se le puso ServicioPrueba , lo correcto es usar 'NombreControllerService')*/
public interface ServicioPrueba {

        
	public List<String> obtenerPerfilesPorUsuario(String id); // deberian ir metodos mas generales como obtenerPerfilesPorUsuario;

        public Usuario obtenerEntidadPrueba(String id);
}
