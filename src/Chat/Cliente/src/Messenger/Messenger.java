package Messenger;

public class Messenger 
{
    public static Conector Cliente;
    public static void main(String[]args)
    {     
        VentanaCliente server=new VentanaCliente();
        server.main();
    }
    
    public static void iniciarcliente()
    {
        Cliente = new Conector();
       
    }
    
    public static void iniciarcliente(String ip)
    {
        Cliente = new Conector(ip);
        Cliente.start();
    }
}
