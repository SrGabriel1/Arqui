/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Pruebas;

import Configuracion.CambioServidor;
import Interfaz.EnviarCorreo;

/**
 *
 * @author Equipo 3
 */
public class MailSender {

    /**
     * Método principal donde se ejecutan una prueba para el subsistema No es la
     * clase principal para el funcionamiento
     *
     * @param args Argumento de linea de comandos
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        //Para que funcione el envio de correo ocupas tener activado el Acceso de aplicaciones menos seguras en la cuenta de envio
        CambioServidor c = new CambioServidor();
        c.setTipoCorreo("gmail");
        EnviarCorreo i = c.getTipoCorreo();
        i.enviarCorreo("yohan.melendrez244907@potros.itson.edu.mx", "", "diego.alcantar247122@potros.itson.edu.mx", "prueba ", "prueba");
    }
}
