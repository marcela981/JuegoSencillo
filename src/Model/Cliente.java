package Model;

import View.Tablero;
import View.Ventana;

import java.net.*;

public class Cliente
{
    public Despachador conectar (Ventana gui,Tablero tablero)
    {
        String hostName = "localHost";
        int portNumber = 1234;

        try
        {
            Socket kkSocket = new Socket(hostName, portNumber);

            Despachador lector = new Despachador(kkSocket);
            lector.gui = gui;
            lector.start();

            return lector;
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }

}
