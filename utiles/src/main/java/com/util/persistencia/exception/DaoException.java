/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.persistencia.exception;

/**
 *
 * @author Mijail Aymara
 */
public class DaoException extends Exception{
  private ErrorDao errorDao;
    public static final int ERROR_INSERTAR = 1001;
    public static final int ERROR_ACTUALIZAR = 1002;
    public static final int ERROR_BORRAR = 1003;
    public static final int ERROR_LISTAR = 1004;
    public static final int ERROR_BUSCAR = 1005;
    public static final int ERROR_INICIAR_TRANSACCION = 1006;
    public static final int ERROR_TERMINAR_TRANSACCION = 1007;
    public static final int ERROR_REVERTIR_TRANSACCION = 1008;
    public static final int ERROR_EJECUTAR_FLUSH = 1009;
    
    public DaoException(Throwable e) {
        super(e);
    }

    public DaoException(int codigoError, String mensaje, Throwable throwable) {
        super(mensaje, throwable);
        errorDao = new ErrorDao(codigoError, mensaje);
    }

    public ErrorDao getErrorDao() {
        return errorDao;
    }

    public void setErrorDao(ErrorDao errorDao) {
        this.errorDao = errorDao;
    }    
}
