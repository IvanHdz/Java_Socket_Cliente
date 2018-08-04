
/**
 *
 * @author Jesus Ivan
 */
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {

    private Socket conexion;

    public ClienteTCP(String servidor, int puerto) {
        try {
            conexion = new Socket(servidor, puerto);
        } catch (IOException e) {
            System.out.println("Error de Conexion");
            System.exit(0);
        }
    }

    public void comunicarConServidor() {
        //Como se Ocupan Flujos se Necesita try{} catch(){}.
        try {
            //Flujo de entrada desde el Servidor.
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()));

            //Flujo de salida hacia el Servidor.
            BufferedWriter salida = new BufferedWriter(
                    new OutputStreamWriter(
                            conexion.getOutputStream()));
            //Siempre hay que poner salto de Linea.
            salida.write(InetAddress.getLocalHost() + "\n");
            salida.flush();
            System.out.println("Texto recibido del servidor");
            /*Este ciclo va a leer todo lo que le manda el servidor*/
            String cadena;
            do {
                cadena = entrada.readLine();
                System.out.println(cadena);
                //Mientras cadena no sea Nulo
            } while (cadena != null);
            entrada.close();
            salida.close();
            conexion.close();
        } catch (IOException e) {
            System.out.println("Error de conexion!!!");
        }
    }
}
