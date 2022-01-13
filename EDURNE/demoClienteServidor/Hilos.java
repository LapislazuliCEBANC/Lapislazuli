package demoClienteServidor;

import java.io.*;
import java.net.*;

public class Hilos extends Thread {
    ServerSocket servidor;
    Socket clientenuevo;
    ObjectInputStream entrada;
    String nom, saludo;
    ObjectOutputStream resp;

    public void run() {
        try {
            // Se crea el objeto servidor para escuchar las peticiones por el puerto 6000
            servidor = new ServerSocket(6000);
            // Se crea el objeto clientenuevo para realizar la comunicación individualizada
            // con cada cliente
            System.out.println("El server se queda en espera a que le llegue alguna petición de algún cliente...");
            for (int i = 0; i < 3; i++) {
                clientenuevo = servidor.accept();
                // Visualizamos la dirección IP de la máquina a la que nos hemos conectado
                System.out.println("Se conectaron desde la IP: " + clientenuevo.getInetAddress());
                // Creamos el objeto entrada para poder leer objetos a través de la red
                entrada = new ObjectInputStream(clientenuevo.getInputStream());
                System.out.println("Ha llegado el mensaje del cliente " + (i + 1) + " al servidor");
                // leemos lo que el cliente nos ha enviado
                nom = (String) entrada.readObject();
                // Mostramos en pantalla lo leído
                System.out.println("Nombre: " + nom);
                System.out.println("Preparando respuesta...");
                // Creamos el objeto resp para poder escribir objetos en la red
                resp = new ObjectOutputStream(clientenuevo.getOutputStream());
                saludo = "Hola " + nom + ", la hora en milisegundos del sistema es " + System.currentTimeMillis();
                // escribimos la respuesta para el cliente
                resp.writeObject(saludo);
                System.out.println("Saludo enviado...");
                clientenuevo.close();
                entrada.close();
                resp.close();
            }
            servidor.close();
            System.out.println("El servidor ha cerrado la conexión");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
