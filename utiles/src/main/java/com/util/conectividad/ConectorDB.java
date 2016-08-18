/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.conectividad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.commons.dbcp.BasicDataSource;
import org.json.JSONObject;

/**
 *
 * @author Mijail
 */
public class ConectorDB {
    
    
    public static void main(String[] args) {
        insertarDatosAuditoria();
    }
    
   
     public static void insertarDatosAuditoria() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
         JSONObject idPrueba = new JSONObject();
         
         String fecha="2016-06-20 09:57:49.000008";
        try {
                idPrueba.put("LOG_IDUSER", "maymara");
                connection = obtenerConexionBasica();
                System.out.println("connection : " + connection.isClosed());
                preparedStatement = connection.prepareStatement("INSERT INTO INTLOGSEGU VALUES (to_timestamp(?,'YYYY-MM-DD HH24:MI:SS.FF'),'maymara','tbs-user','192.168.21.98','INTUSUARIO_SEG','I',null,null,null,?)");
                preparedStatement.setObject(1, fecha);
                preparedStatement.setObject(2, idPrueba.toString());
                boolean ejecutado = preparedStatement.execute();
                System.out.println("ejecutado : " + ejecutado);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }finally{
                    connection =null;
                }
            }
        }
    }
    
    public static Connection obtenerConexionBasica() {
        Connection conexion = null;
        BasicDataSource basicDataSource = null;
        try {
            System.out.println("conexion ..... ");
            basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            basicDataSource.setUrl("jdbc:oracle:thin:@192.168.21.241:1521/pdb1");// local
//            basicDataSource.setUrl("jdbc:oracle:thin:@172.28.80.32:1525/INTERAT1");// test
            basicDataSource.setUsername("interacttdp");// local
//            basicDataSource.setUsername("USR_INTERACT_APP");
            basicDataSource.setPassword("interacttdp99");// local
//            basicDataSource.setPassword("RT87TY");
            basicDataSource.setInitialSize(5);
            basicDataSource.setMaxActive(2);
            conexion = basicDataSource.getConnection();
            System.out.println("conexion : " + conexion.isClosed());
            
//            basicDataSource.

            return conexion;
        } catch (Exception e) {
            e.printStackTrace();
            return conexion;
        } finally {
            basicDataSource = null;
            conexion = null;
        }
    }
}
