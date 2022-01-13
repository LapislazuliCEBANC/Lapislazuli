package demoClienteServidor;

import java.io.*;
import java.net.*;

public class DemoClienteServidor {
    public static void main(String[] args) { 
        Socket cliente;
        ObjectOutputStream nombre;
        ObjectInputStream entrada;
        String resp;
        try {
            //CreaciÃ³n del objeto cliente para la comunicaciÃ³n con el servidor
            //En este caso tanto la aplicaciÃ³n cliente como la servidora se
            //encuentran en el mismo ordenador (localhost)
            cliente=new Socket("localhost",6000);
            //Creamos el objeto nombre para enviar el nombre al servidor
            nombre= new ObjectOutputStream(cliente.getOutputStream());
        
            nombre.writeObject("María");
            System.out.println("Esperando respuesta...");
            //Creamos el objeto entrada para poder leer el objeto que manda el servidor
            entrada=new ObjectInputStream(cliente.getInputStream());
            //Leemos lo que nos ha envÃ­ado el servidor
            resp = (String) entrada.readObject();
            //Lo mostramos en pantalla
            System.out.println("Ha llegado el mensaje del servidor: "+ resp);
            nombre.close();
            entrada.close();
            cliente.close();
            System.out.println("El cliente ha cerrado su conexión");
        }catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
