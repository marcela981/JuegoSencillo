
package Messenger;


public class Messenger 
{
    public static Conector Servidor;
    public static void main(String[]args)
    { 
        VentanaServidor server=new VentanaServidor();
        server.main();
    }
    public static void iniciarserver()
    {
        Servidor = new Conector();
        Servidor.start();
    }
}