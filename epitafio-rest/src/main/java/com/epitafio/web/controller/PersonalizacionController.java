/*
 * Copyright 2016 JuglarM.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.epitafio.web.controller;

import com.epitafio.beans.html.HTMLMain;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.origen.spring.jpa.service.PersonalizadorService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.core.impl.provider.entity.ByteArrayProvider;
import com.sun.jersey.core.impl.provider.entity.DocumentProvider;
import com.sun.jersey.core.impl.provider.entity.FileProvider;
import com.sun.jersey.core.impl.provider.entity.FormProvider;
import com.sun.jersey.core.impl.provider.entity.MimeMultipartProvider;
import com.sun.jersey.multipart.FormDataParam;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
@Path("/personalizacion")
public class PersonalizacionController {

    @Autowired
    private PersonalizadorService userService;

    /**
     *
     * @param distrito
     * @param idbussines
     *
     * @return
     */
    @Path("obtenerHtmlMain")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public HTMLMain obtenerHtmlMain(@FormParam("distrito") String distrito, @FormParam("idbussines") String idbussines) {

        System.out.println("distrito >>>> " + distrito);
        System.out.println("idbussines >>>> " + idbussines);
        HTMLMain main = userService.obtenerHtmlPersonalizado(distrito, idbussines);

        try {
            System.out.println("HTMLMain >>>> " + main);
            if (main != null) {
                System.out.println("getCabecera : " + main.getCabecera());
                if (main.getCabecera() != null) {
                    System.out.println("Titulo : " + main.getCabecera().getTitulo());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return main;
    }
    
    @Path("salvarImagenLogo")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String salvarImagenLogo(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {
        System.out.println("Creando Imagen  en me'todo cargarImagenLogo");
        
        String uploadedFileLocation = "C:\\mytemp\\" + fileDetail.getFileName();
        saveToFile(uploadedInputStream, uploadedFileLocation);

        return "Imagen Creada en Servidor";

    }
    @Path("salvarImagenLogo2")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String salvarImagenLogo2(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {
        System.out.println("Creando Imagen  en me'todo cargarImagenLogo");
        
        String uploadedFileLocation = "C:\\mytemp\\" + fileDetail.getFileName();
        saveToFile(uploadedInputStream, uploadedFileLocation);

        return "Imagen Creada en Servidor";

    }
    @Path("salvarImagenLogo3")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response UploadFile2(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {
        System.out.println("Creando Imagen  en UploadFile2");
        String uploadedFileLocation = "C:\\mytemp\\" + fileDetail.getFileName();

        // save it
        saveToFile(uploadedInputStream, uploadedFileLocation);

           String output = "File uploaded via Jersey based RESTFul Webservice to: " + uploadedFileLocation;
 
        return Response.status(200).entity(output).build();

    }

    // save uploaded file to new location
    private void saveToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {

        try {
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @Path("upload3")
    @POST
    public @ResponseBody
    String UploadFile3(@RequestParam("file") MimeMultipartProvider file) {
        try {
            System.out.println("Creando MimeMultipartProvider en Local" + file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Uploaded: " + 1 + " bytes";

    }

    @Path("upload4")
    @POST
    public @ResponseBody
    String UploadFile4(@RequestParam("file") DocumentProvider file) {
        try {
            System.out.println("Creando DocumentProvider en Local");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Uploaded: " + 1 + " bytes";

    }

    @RequestMapping(value = "/singleSave", method = RequestMethod.POST)
    public @ResponseBody
    String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc) {
        System.out.println("File Description:" + desc);
        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream
                        = new BufferedOutputStream(new FileOutputStream(new File("F:/cp/" + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {

        System.out.println("Descargandoooooooooooooo");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }

    /**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadMultipleFileHandler(@RequestParam("name") String[] names,
            @RequestParam("file") MultipartFile[] files) {

        if (files.length != names.length) {
            return "Mandatory information missing";
        }

        String message = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                message = message + "You successfully uploaded file=" + name
                        + "<br />";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return message;
    }

}
