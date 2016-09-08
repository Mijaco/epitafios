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
import java.util.List;

/**
 *
 * @author JuglarM
 */
public class XMLReader {

    public static void main(String argv[]) {

        List<HTMLMain> listaConfig = leerConfiguracionesXML(ConstantesEstilos.DIRECTORIO_CONFIGURACIONES_WINDOWS);

        for (HTMLMain hTMLMain : listaConfig) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println(hTMLMain);
        }
    }

    public static List<HTMLMain> leerConfiguracionesXML(String pathConfig) {

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
                    if(htmlMain!=null){
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
        HTMLMain htmlMain=null;
        HTMLHeader htmlHeader;
        HTMLBody htmlBody;
        try {
//      File fXmlFile = new File("D:\\conf\\estilos\\default.xml");
            htmlMain = new HTMLMain();
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento Principal:" + doc.getDocumentElement().getNodeName());

            System.out.println("------------EXTRAYENDO CABECERA ----------------");
            NodeList nList = doc.getElementsByTagName("cabecera");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                htmlHeader = new HTMLHeader();
                htmlBody = new HTMLBody();
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String titulo;
                    String rutaLogo;
                    String medidaLogo;
                    String colorFondo;
                    String classMenu;
                    try {
                         titulo = eElement.getElementsByTagName("titulo").item(0).getTextContent();
                         rutaLogo = eElement.getElementsByTagName("ruta-logo").item(0).getTextContent();
                         medidaLogo = eElement.getElementsByTagName("medida-logo").item(0).getTextContent();
                         colorFondo = eElement.getElementsByTagName("color-fondo").item(0).getTextContent();
                         classMenu = eElement.getElementsByTagName("class-menu").item(0).getTextContent();

                        htmlHeader.setTitulo(titulo);
                        htmlHeader.setRutaLogo(rutaLogo);
                        htmlHeader.setMedidaLogo(medidaLogo);
                        htmlHeader.setColorFondo(colorFondo);
                        htmlHeader.setClassMenu(classMenu);

                        htmlMain.setCabecera(htmlHeader);
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
            nList = doc.getElementsByTagName("cuerpo");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                htmlBody = new HTMLBody();
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String classBody;
                    try {

                        classBody = eElement.getElementsByTagName("class-body").item(0).getTextContent();

                        htmlBody.setClassBody(classBody);
                        htmlMain.setCuerpo(htmlBody);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    } finally {
                        classBody = null;
                        eElement = null;
                    }

                }
            }
            
            return htmlMain;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            return htmlMain;
        }
    }
}
