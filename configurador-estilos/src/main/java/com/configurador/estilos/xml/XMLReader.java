/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.configurador.estilos.xml;

import com.configurador.estilos.constantes.ConstantesEstilos;
import com.epitafio.beans.html.HTMLBody;
import com.epitafio.beans.html.HTMLHeader;
import com.epitafio.beans.html.HTMLMain;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.util.cadena.CadenaHelper;
import java.math.BigDecimal;

/**
 *
 * @author JuglarM
 */
public class XMLReader implements ConstantesEstilos {

    public static void main(String argv[]) {

        
        try {
        Map<String,HTMLMain> listaConfig = obtenerMapaConfiguracionesXML(DIRECTORIO_CONFIGURACIONES_WINDOWS);
        BigDecimal bd = new BigDecimal("-11.9700542");   
        System.out.println("bd : " + bd);
        System.out.println(" > " + listaConfig);
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
        
        
        
//        for (HTMLMain hTMLMain : listaConfig.values()) {
//            System.out.println("---------------------------------------------------------------------------------------");
//            System.out.println(hTMLMain);
//        }
    }
    

    public static Map<String, HTMLMain> obtenerMapaConfiguracionesXML(String pathConfig) {

        File[] archivosConfig;
        HTMLMain htmlMain;
        File directorioConfig;
        Map<String, HTMLMain> mapasHTMLMain = new HashMap<String, HTMLMain>();
        try {
            directorioConfig = new File(pathConfig);
            archivosConfig = directorioConfig.listFiles();
            if (archivosConfig != null) {
                for (File configuracionXml : archivosConfig) {
                    htmlMain = leerConfiguracionXML(configuracionXml);
                    if (htmlMain != null) {
                        mapasHTMLMain.put(htmlMain.getNombre(), htmlMain);
                    }

                }
            }
            return mapasHTMLMain;

        } catch (Exception e) {
            e.printStackTrace();
            return mapasHTMLMain;
        } finally {

            archivosConfig = null;
            htmlMain = null;
            directorioConfig = null;
            mapasHTMLMain = null;
        }
    }

    public static List<HTMLMain> obtenerListaConfiguracionesXML(String pathConfig) {

        File[] archivosConfig;
        HTMLMain htmlMain;
        File directorioConfig;
        List<HTMLMain> listaHTMLMain = new ArrayList<HTMLMain>();
        try {
            directorioConfig = new File(pathConfig);
            archivosConfig = directorioConfig.listFiles();
            if (archivosConfig != null) {
                for (File configuracionXml : archivosConfig) {
                    htmlMain = leerConfiguracionXML(configuracionXml);
                    if (htmlMain != null) {
                        listaHTMLMain.add(htmlMain);
                    }

                }
            }
            return listaHTMLMain;

        } catch (Exception e) {
            e.printStackTrace();
            return listaHTMLMain;
        } finally {
            archivosConfig = null;
            htmlMain = null;
            listaHTMLMain = null;
        }
    }

    public static HTMLMain leerConfiguracionXML(File fXmlFile) {
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc;
        String nombrePlantilla;
        String idPlantilla;
        HTMLMain htmlMain = null;
        HTMLHeader htmlHeader;
        HTMLBody htmlBody;
        try {
            if(fXmlFile==null || fXmlFile.getName()==null){
                return null;
            }
            
            nombrePlantilla = fXmlFile.getName();
            
            htmlMain = new HTMLMain();
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento Principal: " + doc.getDocumentElement().getNodeName());
            System.out.println("Root element :" + doc.getDocumentElement().getAttribute("id"));
            
            idPlantilla = doc.getDocumentElement().getAttribute("id");
            System.out.println("------------EXTRAYENDO CABECERA ----------------");
            NodeList nList = doc.getElementsByTagName(CABECERA_TAG_XML_PRINCIPAL);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                htmlHeader = new HTMLHeader();
                htmlBody = new HTMLBody();
                System.out.println("Elemento Cabecera :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String titulo;
                    String rutaLogo;
                    String medidaLogo;
                    String colorFondo;
                    String classMenu;
                    String coordenadas;
                    try {
                        titulo = eElement.getElementsByTagName(CABECERA_TAG_XML_TITULO).item(0).getTextContent();
                        rutaLogo = eElement.getElementsByTagName(CABECERA_TAG_XML_RUTA_LOGO).item(0).getTextContent();
                        medidaLogo = eElement.getElementsByTagName(CABECERA_TAG_XML_MEDIDA_LOGO).item(0).getTextContent();
                        colorFondo = eElement.getElementsByTagName(CABECERA_TAG_XML_COLOR_FONDO).item(0).getTextContent();
                        classMenu = eElement.getElementsByTagName(CABECERA_TAG_XML_CLASS_MENU).item(0).getTextContent();

                        htmlHeader.setTitulo(titulo);
                        htmlHeader.setRutaLogo(rutaLogo);
                        htmlHeader.setMedidaLogo(medidaLogo);
                        htmlHeader.setColorFondo(colorFondo);
                        htmlHeader.setClassMenu(classMenu);

                        htmlMain.setCabecera(htmlHeader);
                        
                        htmlBody.setClassBody(classMenu);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    } finally {
                        titulo = null;
                        rutaLogo = null;
                        medidaLogo = null;
                        colorFondo = null;
                        classMenu = null;
                        eElement = null;
                    }

                }
            }

            System.out.println("------------EXTRAYENDO BODY ----------------");
            nList = doc.getElementsByTagName(CUERPO_TAG_XML_PRINCIPAL);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                htmlBody = new HTMLBody();
                System.out.println("ElementO Cuerpo :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String classBody;
                    String[] coordenadas;
                    BigDecimal longitud;
                    BigDecimal latitud;
                    try {

                        classBody = eElement.getElementsByTagName(CUERPO_TAG_XML_CLASS_BODY).item(0).getTextContent();
                        coordenadas = eElement.getElementsByTagName(CUERPO_TAG_XML_COORDENADAS).item(0).getTextContent().split(",");
                        System.out.println("coordenadas[0]: " + coordenadas[0]);
                        latitud = new BigDecimal(coordenadas[0]);
                        longitud = new BigDecimal(coordenadas[1]);
                        
                        htmlBody.setClassBody(classBody);
                        htmlBody.setLatitud(latitud);
                        htmlBody.setLongitud(longitud);
                        
                        htmlMain.setCuerpo(htmlBody);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    } finally {
                        classBody = null;
                        eElement = null;
                        coordenadas = null;
                        longitud = null;
                        latitud = null;
                    
                    }

                }
            }
            
            nombrePlantilla = CadenaHelper.obtenerNombreSinExtension(nombrePlantilla, ".xml");
        
            htmlMain.setNombre(nombrePlantilla);
            htmlMain.setId(idPlantilla);

            return htmlMain;
        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
        } finally {
            return htmlMain;
        }
    }
}
