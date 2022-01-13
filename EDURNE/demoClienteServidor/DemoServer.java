package demoClienteServidor;

/*Aplicación cliente/servidor en la cual el cliente se conecta al sever, le envia
 * su nombre (un string) y este le devuelve un saludo personalizado (otro string).
 * Tener encuenta que siempre deberá ejecutarse en primer lugar el programa servidor.
 * Este se quedará bloqueado a la espera de recibir peticiones de clientes.
 */

import java.io.*;
import java.net.*;

public class DemoServer {
    public static void main(String[] args) {
        Hilos h1 = new Hilos();
        Hilos h2 = new Hilos();

        h1.start();
        h2.start();
    }
}
