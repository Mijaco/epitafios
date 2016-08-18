/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.persistencia.dao.interfaz;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.util.persistencia.exception.DaoException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityTransaction;
/**
 *
 * @author Mijail Aymara
 */
public interface BaseDao <T, PK extends Serializable>  {

  
    public T crear(T entidad) throws DaoException;

    public T buscar(PK clavePrimaria) throws DaoException;

    public void borrar(T entidad) throws DaoException;

    public T actualizar(T entidad) throws DaoException;

    public List<T> listar(String nombreSentencia) throws DaoException;

    public List<T> listarPorParametros(String nombreSentencia, Object... parametros) throws DaoException;

    public List<T> listarPorParametrosPaginados(String nombreSentencia, int primerResultado, int maximoResultado, Object... parametros) throws DaoException;

    public EntityTransaction obtenerTransaccion() throws DaoException;

    public void terminarTransaccion(EntityTransaction entityTransaction) throws DaoException;

    public void revertirTransaccion(EntityTransaction entityTransaction) throws DaoException;

    public Object crearQueryNativo(String nombreSentencia) throws DaoException;

    public long obtenerSecuencia(String nombreSentencia) throws DaoException;

    public long obtenerSecuencia(String nombreSentencia, Object... parametros) throws DaoException;

    public int borrarPorParametros(String nombreSentencia, Object... parametros) throws DaoException;

    public void flush() throws DaoException;

    public Long obtenerCantidadResultados(String sentencia) throws DaoException;

    public Long obtenerCantidadResultados(String sentencia, Object... parametros) throws DaoException;

    public List<Object[]> listarPorQueryNativo(String sqlnativo) throws DaoException;

    public List<Object[]> listarPorQueryNativo(String sqlnativo, int primero, int maximo) throws DaoException;

    public List<Object[]> listarPorQueryNativo(String sqlnativo, List<Object> params) throws DaoException;

    public List<Object[]> listarPorQueryNativo(String sqlnativo, int primero, int maximo, List<Object> params) throws DaoException;

    public List<Object[]> listarQueryArrayNativo(String nombreSentencia, Object... parametros) throws DaoException ;

}

