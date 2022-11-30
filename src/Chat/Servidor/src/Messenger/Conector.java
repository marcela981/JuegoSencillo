
package Messenger;

import java.net.*;
import java.io.*;
import Messenger.Messenger;

public class Conector extends Thread
{
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;   //the socket entry
    private DataOutputStream salida;           //data output for send messages
    private BufferedReader entrada;            //data entry for read messages
    final int puerto=8000;            // computer port 
 
    public Conector()                    
    {
        try{
           ss=new ServerSocket(puerto);       
           s=ss.accept();   
            //creacion de entrada de datos para lectura de mensajes     
           entradaSocket=new InputStreamReader(s.getInputStream());
           entrada=new BufferedReader(entradaSocket);
           salida=new DataOutputStream(s.getOutputStream());
           this.salida.writeUTF("****** CONECTADO *******\n \n");
        }catch(Exception e){};
    
    }
    
    public Conector(String ip)
    {
        try{

           s=new Socket(ip,this.puerto);   
           entradaSocket=new InputStreamReader(s.getInputStream());
           entrada=new BufferedReader(entradaSocket);    
           salida=new DataOutputStream(s.getOutputStream());
         }catch(Exception e){};
     }
    
    public void run()
    {
      String texto="text";
      while(true)
      {
        try{
          texto=entrada.readLine();
          VentanaServidor.textAereaServer.setText(VentanaServidor.textAereaServer.getText()+"\n"+texto);
        }catch(IOException e){};
      }
    }
    
     public void enviarMSG(String msg)      //method for send a messages
     {
        try{
            salida.writeUTF(msg+"\n");
        }catch(IOException e){};
     }
      
     public String leerMSG()              //method for read a messages
     { 
       try{
            return entrada.readLine();
          }catch(IOException e){};
       return null;
     }
     
     public void desconectar()     
     {  
        try{
            s.close();
           }catch(IOException e){};
        try{
            ss.close();
            }catch(IOException e){};
     }   
}