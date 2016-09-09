///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.utiles.files;
//
//import static com.bytesw.util.program.Logger.printException;
//import static com.utiles.constantes.UtilesFilesConstantes.*;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import org.apache.commons.io.FileUtils;
//import static org.apache.commons.io.FileUtils.*;
//
///**
// *
// * @author Mijail Aymara
// */
//public class MetodosFiles {
//
//    public final static String FILE_PRUEBA = "D:\\MIJAIL\\MAT\\FILES PRUEBA\\prueba2.txt";
//    public final static String FILE_PRUEBA_TEMPORAL = "D:\\MIJAIL\\MAT\\FILES PRUEBA\\tmp_prueba2.txt";
//    public final static String CADENA_SYSTEM_OUT_PRINT = "System.out.print";
//
//    public void eliminarSystemOuts(String rutaFile) {
//        // Open the file
//        boolean existeSystemOut = false;
//        try {
//            
//            
//            FileInputStream fstream = new FileInputStream(rutaFile);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//
//            String strLine;
//            while ((strLine = br.readLine()) != null) {
//                existeSystemOut = strLine.toLowerCase().contains(CADENA_SYSTEM_OUT_PRINT.toLowerCase());
//                if (!existeSystemOut) {
//                }
//                if (strLine.trim().startsWith("//")) {
//                }
//            }
//            br.close();
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//        }
//    }
//
//    public void eliminarComentariosClase(String directorio) {
//        File fileDirectorio = null;
////        FileUtils fileUtils;
//        try {
//
//            fileDirectorio = new File(directorio);
//            if (fileDirectorio.isDirectory()) {
//                listFiles(fileDirectorio, null, null);
//            }
//
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//        }
//    }
//
//    /**
//     *
//     * @param directorio
//     */
//    public void listarArchivosDeDirectorio(final File directorio) {
//
//        try {
//
//            for (final File archivo : directorio.listFiles()) {
//                if (archivo.isDirectory()) {
//                    listarArchivosDeDirectorio(archivo);
//                } else {
//                    //TODO
//                    String rutaArchivoJava = archivo.getAbsolutePath();
//                    if (validarExtensionJava(rutaArchivoJava)) {
//
////                      agregarPrintException(archivo.getAbsolutePath());
//                        eliminarSystemOuts(rutaArchivoJava);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//        }
//
//    }
//
//    public void agregarPrintException(String rutaClaseJava) {
////        String rutaClaseJava = FILE_PRUEBA;
//        String tmpFileName = FILE_PRUEBA_TEMPORAL;
//
//        BufferedReader br = null;
//        BufferedWriter bw = null;
//        String nombreClase = null;
//        boolean existePrintException;
//        boolean existeSystemOut;
//        boolean existeLineaComentada;
//        boolean existePrintStack;
//        boolean existeCatch;
//        boolean existenEspaciosEnBlanco;
//        try {
//            br = new BufferedReader(new FileReader(rutaClaseJava));
//            bw = new BufferedWriter(new FileWriter(tmpFileName));
//            String line;
//            while ((line = br.readLine()) != null) {
//
//                if (nombreClase == null) {
//                    nombreClase = detectarNombreClase(line);
//                }
//
//                existePrintException = validarExistenciaEnInicioDeLinea(line, IDENTIFICADOR_PRINT_EXCEPTION);
//                existeSystemOut = validarExistenciaEnInicioDeLinea(line, IDENTIFICADOR_SYSTEM_OUT);
//                existeLineaComentada = validarLineaSinComentario(line);
//                existenEspaciosEnBlanco = validarExistenciaLineaEnBlanco(line);
//                existePrintStack = validarExistenciaPrintStack(line);
//                existeCatch = validarExisteCatch(line);
//
//                if (existeCatch) {
//                    bw.write(line + armarCadenaPrintException(nombreClase) + "\n");
//                } else {
//                    if (!existePrintStack && !existePrintException && !existeSystemOut && !existeLineaComentada && !existenEspaciosEnBlanco) {
//                        bw.write(line + "\n");
//                        System.out.println(line + " " + existeLineaComentada + "\n");
//                    }
//                }
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//            return;
//        } finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//            } catch (IOException e) {
//                printException("[ MetodosFiles ]", e);
//            }
//            try {
//                if (bw != null) {
//                    bw.close();
//                }
//            } catch (IOException e) {
//                printException("[ MetodosFiles ]", e);
//                //
//            }
//        }
//        // Once everything is complete, delete old file..
//        File oldFile = new File(rutaClaseJava);
//        oldFile.delete();
//
//        // And rename tmp file's name to old file name
//        File newFile = new File(tmpFileName);
//        newFile.renameTo(oldFile);
//
//    }
//
//    public boolean validarExisteCatch(String linea) {
//        boolean existeCatch = false;
//        String lineaSinEspacio = null;
//        try {
//            linea = linea.replaceAll(" ", "");
//            lineaSinEspacio = linea;
//            if (!validarLineaSinComentario(linea)) {
//                if (lineaSinEspacio.startsWith(IDENTIFICADOR_CATCH)) {
//                    existeCatch = true;
//                }
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//        }
//        return existeCatch;
//    }
//
////    }
////    public boolean ingresarPrintException(String adjuntoPrintException) {
////        boolean printExIngresado = false;
////        boolean existeCatch;
////        try {
////            if (validarExisteCatch(linea)) {
////
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return printExIngresado;
////    }
//    public String armarCadenaPrintException(String nombreClase) {
//        String cadenaPrintException = null;
//        try {
////            cadenaPrintException = "printException( [ " + nombreClase + " ]" + "," + " "[ obtenerLibroReportePorServicio ] " , e);";
//            cadenaPrintException = "printException( \"[ " + nombreClase + " ]\" , e);";
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//
//        }
//        return cadenaPrintException;
//    }
//
//    public String detectarNombreClase(String lineaCodigo) {
//        String lineaSinEspacio = null;
//        String nombreClase = null;
//        int ultimoIndiceNombreClase;
//        try {
//            lineaCodigo = lineaCodigo.replaceAll(" ", "");
//            lineaSinEspacio = lineaCodigo;
//            if (!validarLineaSinComentario(lineaCodigo)) {
//                if (lineaSinEspacio.startsWith(IDENTIFICADOR_PREFIJO_NOMBRE_CLASE_SIN_ESPACIO)) {
//                    if (lineaCodigo.contains(IDENTIFICADOR_LLAVE_CIERRE)) {
//                        ultimoIndiceNombreClase = lineaSinEspacio.indexOf(IDENTIFICADOR_LLAVE_CIERRE);
//                    } else {
//                        ultimoIndiceNombreClase = lineaSinEspacio.length();
//                    }
//                    nombreClase = lineaCodigo.substring(LONGITUD_PREFIJO_CLASE, ultimoIndiceNombreClase);
//                }
//            }
//
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//
//        }
//        return nombreClase;
//    }
//
//    public void eliminarPrintStack() {
//
//    }
//
//    public boolean validarExistenciaPrintStack(String linea) {
//        boolean existePrintStack = false;
//        String lineaSinEspacio = null;
//        try {
//            linea = linea.replaceAll(" ", "");
//            lineaSinEspacio = linea;
//            if (!validarLineaSinComentario(linea)) {
//                if (lineaSinEspacio.startsWith(IDENTIFICADOR_PRINT_STACK)) {
//                    existePrintStack = true;
//                }
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//
//        }
//        return existePrintStack;
//    }
//
//    public boolean validarExistenciaLineaEnBlanco(String linea) {
//        boolean esLineaBlanca = false;
//        try {
//            if (linea != null) {
//                if (linea.isEmpty()) {
//                    esLineaBlanca = true;
//                }
//            }
//        } catch (Exception e) {
//        }
//        return esLineaBlanca;
//    }
//
//    public boolean validarExistenciaValorEnLinea(String linea, String valor) {
//        boolean existeValor = false;
//        String lineaSinEspacio = null;
//        try {
//            linea = linea.replaceAll(" ", "");
//            lineaSinEspacio = linea;
//            if (!validarLineaSinComentario(linea)) {
//                if (lineaSinEspacio.contains(valor)) {
//                    existeValor = true;
//                }
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//
//        }
//        return existeValor;
//    }
//
//    public boolean validarExistenciaEnInicioDeLinea(String linea, String valor) {
//        boolean existeValor = false;
//        String lineaSinEspacio = null;
//        try {
//            linea = linea.replaceAll(" ", "");
//            lineaSinEspacio = linea;
//            if (!validarLineaSinComentario(linea)) {
//                existeValor = lineaSinEspacio.startsWith(valor);
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//
//        }
//        return existeValor;
//    }
//
//    public String detectarLineaException(String lineaCodigo) {
//        String lineaSinEspacio = null;
//        String nombreClase = null;
//        int ultimoIndice;
//        try {
//            lineaCodigo = lineaCodigo.replaceAll(" ", "");
//            lineaSinEspacio = lineaCodigo;
//            if (!validarLineaSinComentario(lineaCodigo)) {
//                if (lineaSinEspacio.startsWith(IDENTIFICADOR_PREFIJO_NOMBRE_CLASE_SIN_ESPACIO)) {
//                    if (lineaCodigo.contains(IDENTIFICADOR_LLAVE_CIERRE)) {
//                        ultimoIndice = lineaSinEspacio.indexOf(IDENTIFICADOR_LLAVE_CIERRE);
//                    } else {
//                        ultimoIndice = lineaSinEspacio.length();
//                    }
//                    nombreClase = lineaCodigo.substring(LONGITUD_PREFIJO_CLASE, ultimoIndice);
//                }
//            }
//
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//
//        }
//        return nombreClase;
//    }
//
//    public static boolean validarExtensionJava(String rutaArchivo) {
//        try {
//            if (rutaArchivo != null) {
//                if (rutaArchivo.endsWith(".java")) {
//                    File file = new File(rutaArchivo);
//                    if (file.isFile()) {
//                        return true;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//
//        }
//        return false;
//    }
//
//    public boolean validarLineaSinComentario(String linea) {
//        String lineaSinEspacios = null;
//        boolean lineaComentario = false;
//        try {
//            lineaSinEspacios = linea.trim();
//            lineaComentario = lineaSinEspacios.startsWith(IDENTIFICADOR_COMENTARIO);
//            if (lineaComentario) {
//
//            }
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//        }
//        return lineaComentario;
//    }
//    
//     public String obtenerXmlCadena(String ruta){
//           StringBuilder sb = new StringBuilder();
//        try {
//            InputStream in = new FileInputStream(ruta);
//            BufferedReader r = new BufferedReader(new InputStreamReader(in));
//            String str = null;
// 
//           
//            while ((str = r.readLine()) != null) {
//                sb.append(str).append("\n");
//            }
//            
//            
//            
//            return sb.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//            
//    }
//     
//     public static void copiarDirectorio(){
//         try {
//             FileUtils.copyDirectory(new File("D:\\MIJAIL\\MAT\\OTROS\\ORIGEN"), new File("D:\\MIJAIL\\MAT\\OTROS\\DESTINO"));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         
//     }
//
//    public static void main(String[] args) {
//        MetodosFiles metodosFiles = new MetodosFiles();
//        String nombreClase;
//        try {
////            File directorio = new File(DIRECTORIO_PRUEBA);
////            metodosFiles.eliminarSystemOuts(FILE_PRUEBA);
////            metodosFiles.agregarPrintException(FILE_PRUEBA);
////            nombreClase = metodosFiles.detectarNombreClase("   public class GestionReporteHelper   {");
////            System.out.println("nombreClase-->" + nombreClase);
////            metodosFiles.armarCadenaPrintException("ClasePrueba");
////            metodosFiles.listarArchivosDeDirectorio(directorio);
////            System.out.println("--> " + metodosFiles.validarLineaSinComentario("//File directorio = new File(DIRECTORIO_PRUEBA);"));
//
////           metodosFiles.eliminarSystemOuts(nombreClase);
////            File directorio = new File("D:\\dev\\Netbeans\\Interact-Web\\reportes-jasper-util\\");
////            if (directorio.isDirectory()) {
////                metodosFiles.listarArchivosDeDirectorio(directorio);
////            }
//            
//            copiarDirectorio();
//
//        } catch (Exception e) {
//            printException("[ MetodosFiles ]", e);
//        }
//    }
//}
