/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socketsejercicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PREDATOR
 */
public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket socket = null;
        
        int puerto = 6000;
        DataInputStream in;
        DataOutputStream out;
        
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
                
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Inicio del servidor " + formatoFecha.format(LocalDateTime.now()));
            System.out.println("Puerto " + puerto);
            


            while (true) {                
                //espera de conexion o solicitud
            socket = servidor.accept();
            
            System.out.println("El cliente Carlos Cámbara se ha conectado a las: " + formatoFecha.format(LocalDateTime.now()));
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            String mensaje = in.readUTF();
            System.out.println("El " + mensaje);
  
            
            System.out.println("Cliente se desconectó a las: " + formatoFecha.format(LocalDateTime.now()));
            System.out.println("");
            }
                    
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        
    }
}
