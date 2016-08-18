/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.persistencia.dao.impl;


import com.util.persistencia.dao.interfaz.BaseDao;
import com.util.persistencia.exception.DaoException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.eclipse.persistence.config.CascadePolicy;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Define los metodos generales usados para la persistencia
 *
 * @author Mijail Aymara
 * @version 1.1, 05/08/14
 */
public class GestionGeneralDAO<T, PK extends Serializable> implements BaseDao<T, PK>, Serializable {

    private Class<T> referenciaEntidad;
    private EntityManager entityManager;

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected void setReferenciaEntidad(Class<T> referenciaEntidad) {
        this.referenciaEntidad = referenciaEntidad;
    }

    @Override
    public T crear(T entidad) throws DaoException {
        try {
            entityManager.persist(entidad);
            return entidad;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException(DaoException.ERROR_INSERTAR, ex.getMessage(), ex);
        }
    }

    @Override
    public T buscar(PK claveIdentificacion) throws DaoException {
        T entidad = null;
        try {
            if (claveIdentificacion != null) {
                entidad = entityManager.find(referenciaEntidad, claveIdentificacion);
            }
            return entidad;
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_BUSCAR, e.getMessage(), e);
        } catch (Exception e) {
            throw new DaoException(DaoException.ERROR_BUSCAR, e.getMessage(), e);
        }
    }

    @Override
    public void borrar(T entidad) throws DaoException {
        try {
            entityManager.remove(entidad);
        } catch (Exception ex) {
            throw new DaoException(DaoException.ERROR_BORRAR, ex.getMessage(), ex);
        }
    }

    @Override
    public T actualizar(T entidad) throws DaoException {
        try {
            entidad = entityManager.merge(entidad);
            return entidad;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException(DaoException.ERROR_ACTUALIZAR, ex.getMessage(), ex);
        }
    }

    @Override
    public List<T> listar(String nombreSentencia) throws DaoException {
        return listarPorParametros(nombreSentencia, new Object[0]);
    }

    @Override
    public List<T> listarPorParametros(String nombreSentencia, Object... parametros) throws DaoException {
        List<T> lista = null;
        Query query = null;
        int indice = 0;
        try {
            query = entityManager.createNamedQuery(nombreSentencia);
            if (parametros != null && parametros.length > 0) {
                for (Object parametro : parametros) {
                    indice++;
                    query.setParameter(indice, parametro);
                }
            }
            query.setHint(QueryHints.REFRESH, HintValues.TRUE);
            lista = query.getResultList();
            return lista;
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } catch (Exception e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            query = null;
            lista = null;
        }
    }

    @Override
    public long obtenerSecuencia(String nombreSentencia, Object... parametros) throws DaoException {
        Query query;
        int indice = 0;
        Object resultado;
        long secuencia;
        try {
            query = entityManager.createNamedQuery(nombreSentencia);
            if (parametros != null && parametros.length > 0) {
                for (Object parametro : parametros) {
                    indice++;
                    query.setParameter(indice, parametro);
                }
            }
            query.setHint(QueryHints.REFRESH, HintValues.TRUE);
            resultado = query.getSingleResult();
            secuencia = (resultado == null) ? 1 : Long.parseLong(resultado.toString()) + 1;
            return secuencia;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } catch (Exception e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            query = null;
            resultado = null;
        }
    }

    @Override
    public int borrarPorParametros(String nombreSentencia, Object... parametros) throws DaoException {
        Query query;
        int indice = 0;
        int registrosAfectados = 0;
        try {
            query = entityManager.createNamedQuery(nombreSentencia);
            if (parametros != null && parametros.length > 0) {
                for (Object parametro : parametros) {
                    indice++;
                    query.setParameter(indice, parametro);
                }
            }
            registrosAfectados = query.executeUpdate();
            return registrosAfectados;
        } catch (Exception ex) {
            throw new DaoException(DaoException.ERROR_BORRAR, ex.getMessage(), ex);
        } finally {
            query = null;
        }
    }

    @Override
    public EntityTransaction obtenerTransaccion() throws DaoException {
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            return entityTransaction;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException(DaoException.ERROR_INICIAR_TRANSACCION, ex.getMessage(), ex);
        } finally {
            entityTransaction = null;
        }
    }

    @Override
    public void terminarTransaccion(EntityTransaction entityTransaction) throws DaoException {
        try {
            entityTransaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException(DaoException.ERROR_TERMINAR_TRANSACCION, ex.getMessage(), ex);
        }
    }

    @Override
    public void revertirTransaccion(EntityTransaction entityTransaction) throws DaoException {
        entityTransaction.rollback();
    }

    @Override
    public void flush() throws DaoException {
        try {
            entityManager.flush();
        } catch (Exception ex) {
            throw new DaoException(DaoException.ERROR_EJECUTAR_FLUSH, ex.getMessage(), ex);
        }
    }

    @Override
    public List<T> listarPorParametrosPaginados(String nombreSentencia, int primerResultado, int maximoResultado, Object... parametros) throws DaoException {
        List<T> lista = null;
        int indice = 0;
        try {
            Query query = entityManager.createNamedQuery(nombreSentencia);
            if (parametros != null && parametros.length > 0) {
                for (Object parametro : parametros) {
                    indice++;
                    query.setParameter(indice, parametro);
                }
            }
            query.setHint(QueryHints.REFRESH, HintValues.TRUE);
            query.setHint(QueryHints.REFRESH_CASCADE, CascadePolicy.CascadeByMapping);
            query.setFirstResult(primerResultado);
            query.setMaxResults(maximoResultado);
            lista = query.getResultList();
            return lista;
        } catch (NoResultException e) {
            return lista;
        } catch (PersistenceException ex) {
            throw new DaoException(DaoException.ERROR_LISTAR, ex.getMessage(), ex);
        } finally {
            lista = null;
        }
    }

    @Override
    public Long obtenerCantidadResultados(String sentencia) throws DaoException {
        Query query = null;
        Object numResObj = null;
        long cero = 0;
        try {
            query = entityManager.createNamedQuery(sentencia);
            numResObj = query.getSingleResult();
            return numResObj != null ? Long.parseLong(numResObj.toString()) : cero;
        } catch (NoResultException e) {
            return cero;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            query = null;
            numResObj = null;
        }
    }

    @Override
    public Long obtenerCantidadResultados(String sentencia, Object... parametros) throws DaoException {
        long cero = 0;
        int indice = 0;
        Query query = null;
        Object numResObj = null;
        try {
            query = entityManager.createNamedQuery(sentencia);
            if (parametros != null && parametros.length > 0) {
                for (Object parametro : parametros) {
                    indice++;
                    query.setParameter(indice, parametro);
                }
            }
            numResObj = query.getSingleResult();
            return numResObj != null ? Long.parseLong(numResObj.toString()) : cero;
        } catch (NoResultException e) {
            return cero;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            query = null;
            numResObj = null;
        }
    }

    @Override
    public long obtenerSecuencia(String nombreSentencia) throws DaoException {
        long cero = 0;
        Query query = null;
        Object resultado = null;
        try {
            query = entityManager.createNamedQuery(nombreSentencia);
            query.setHint(QueryHints.REFRESH, HintValues.TRUE);
            resultado = query.getSingleResult();
            return resultado == null ? 0 : (Long.parseLong(resultado.toString()) + 1);
        } catch (NoResultException e) {
            return cero;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            query = null;
            resultado = null;
        }
    }

    @Override
    public Object crearQueryNativo(String queryNativo) throws DaoException {
        Query query = null;
        try {
            query = entityManager.createNativeQuery(queryNativo);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            query = null;
        }
    }

    @Override
    public List<Object[]> listarPorQueryNativo(String sqlnativo) throws DaoException {
        return listarPorQueryNativo(sqlnativo, 0, -1, null);
    }

    @Override
    public List<Object[]> listarPorQueryNativo(String sqlnativo, int primero, int maximo) throws DaoException {
        return listarPorQueryNativo(sqlnativo, primero, maximo, null);
    }

    @Override
    public List<Object[]> listarPorQueryNativo(String sqlnativo, List<Object> params) throws DaoException {
        return listarPorQueryNativo(sqlnativo, 0, -1, params);
    }

    @Override
    public List<Object[]> listarPorQueryNativo(String sqlnativo, int primero, int maximo, List<Object> params) throws DaoException {
        Query q = null;
        try {
            q = entityManager.createNativeQuery(sqlnativo);
            
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    q.setParameter(i + 1, params.get(i));
                }
            }
            
            int fr = primero < 0 ? 0 : primero;
            q.setFirstResult(fr);
            
            if (maximo > 0) {
                q.setMaxResults(maximo);
            }
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            q = null;
        }
    }
    
    @Override
    public List<Object[]> listarQueryArrayNativo(String nombreSentencia, Object... parametros) throws DaoException {
        int indice = 0;
        List<Object[]> lista = null;
        Query query = null;
        try {
            query = entityManager.createNativeQuery(nombreSentencia);

            if (parametros != null && parametros.length > 0) {
                for (Object parametro : parametros) {
                    indice++;
                    query.setParameter(indice, parametro);
                }
            }
            lista = query.getResultList();
            return lista;
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException e) {
            throw new DaoException(DaoException.ERROR_LISTAR, e.getMessage(), e);
        } finally {
            query = null;
        }
    }
}
