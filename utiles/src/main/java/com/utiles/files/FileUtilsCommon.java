///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.utiles.files;
//
//import static com.bytesw.util.program.Logger.printDebug;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.Charset;
//import org.apache.commons.io.FileUtils;
//
///**
// *
// * @author UserTBS1
// */
//public class FileUtilsCommon {
//
//    public FileUtilsCommon() {
//    }
//
//        
//    public static void main(String[] args) {
//        try {
//          File rpta=  new File("/btf/ggwp");
//        System.out.println("file ?  : " + rpta.isFile());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        
//
//    }
//        
//    private static String obtenerResponseModoPrueba(String pathResponse){
//        String responseContent=null;
//        try {
//             responseContent = FileUtils.readFileToString(new File(pathResponse), "UTF-8");
//             return responseContent;    
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//            return responseContent;       
//        }finally{
//            responseContent = null;
//        }
//    }
//    
//    
//}
