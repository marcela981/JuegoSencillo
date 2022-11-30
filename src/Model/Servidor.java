package Model;

import java.net.*;
import java.util.ArrayList;

public class Servidor
{
    public Servidor()
    {
        int portNumber = 1234;
        ArrayList<Despachador> escritores = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true)
            {
                Socket clientSocket = serverSocket.accept();

                Despachador lector = new Despachador(clientSocket);
                escritores.add(lector);
                lector.escritores = escritores;
                lector.start();

                //clientSocket.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
