
package Messenger;
import java.net.*;
import java.io.*;
import Messenger.Messenger;

public class Conector extends Thread
{
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;  
    private DataOutputStream salida;          
    private BufferedReader entrada;           
    final int puerto = 8000;   
    
    
    public Conector()
    {
        try{
           ss=new ServerSocket(puerto);   
           s=ss.accept();
           entradaSocket=new InputStreamReader(s.getInputStream());
           entrada=new BufferedReader(entradaSocket);     
           salida=new DataOutputStream(s.getOutputStream());   
        }catch(Exception e){};
    
    }
    public Conector(String ip)
    {
        try{

           s=new Socket(ip,this.puerto);      
           entradaSocket = new InputStreamReader(s.getInputStream());
           entrada = new BufferedReader(entradaSocket);       
           salida = new DataOutputStream(s.getOutputStream());

         }catch(Exception e){};
     }
     public void run()
     {             
         String texto="text";
         while(true)
         {
             try{
                  texto=entrada.readLine();
                  VentanaCliente.jTextArea1.setText(VentanaCliente.jTextArea1.getText()+"\n"+texto);
                }catch(IOException e){};
         }
     }
     public void enviarMSG(String msg)    //method for send a messages
     {
        try{
            salida.writeUTF(msg+"\n");
        }catch(IOException e){};
     }
   
     public String leerMSG()                //method for read a messages
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