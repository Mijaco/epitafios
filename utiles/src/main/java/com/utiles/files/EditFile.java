/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utiles.files;

import static com.bytesw.util.program.Logger.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditFile {

    public final static String FILE_PRUEBA = "D:\\MIJAIL\\MAT\\FILES PRUEBA\\prueba2.txt";

    public void editarArchivo(String rutaArchivo) {
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            String verify, putData;
            file = new File(rutaArchivo);
            file.createNewFile();
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            bw.write("Some text here for a reason");

            bw.flush();
            bw.close();
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while ((verify = br.readLine()) != null) {
                if (verify != null) { //***edited
                    putData = verify.replaceAll("null", "GG");
                    bw.write(putData);
                }
            }
            br.close();

        } catch (IOException e) {printException( "[ EditFile ]" , e);
            printException("[ EditFile ]", e);

        }
    }
//bw.close() must be put before br.close()

    public static void main(String[] args) {
        EditFile editFile = null;
        try {
            editFile = new EditFile();
            editFile.editarArchivo(FILE_PRUEBA);
        } catch (Exception e) {printException( "[ EditFile ]" , e);
            printException("[ EditFile ]", e);
//          e.printStackTrace()
        }
    }

}
