
/**
 *
 * @author Jesus Ivan
 */
public class Cliente {

    public static void main(String[] args) {
        //Localhost va Pegado ya que es una sentencia Fija para saber tu Ip
        ClienteTCP c = new ClienteTCP("Localhost", 3000);
        c.comunicarConServidor();
    }
}
