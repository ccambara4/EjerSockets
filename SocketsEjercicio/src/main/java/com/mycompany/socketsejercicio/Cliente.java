/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.socketsejercicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author PREDATOR
 */
public class Cliente {

    public static void main(String[] args)
    {
        
        try {
            String host = "127.0.0.1";
            int puerto = 6000;
            
            DataInputStream in;
            DataOutputStream out;

            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
            
            Socket socket = new Socket(host, puerto);
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            //enviar mensaje
            out.writeUTF("Cliente Carlos Cámbara se conectó desde Cliente desde el puerto " + puerto + formatoFecha.format(LocalDateTime.now()));
            
            //leer mensaje servidor
            String mensaje = in.readUTF();
            
                    
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
    }   
}

