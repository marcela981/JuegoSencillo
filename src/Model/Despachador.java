package Model;

import View.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Despachador extends Thread
{
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    public Ventana gui = null;
    public ArrayList<Despachador> escritores = new ArrayList<>();
    public HashMap<String, Raqueta> jugadores = new HashMap<>();

    public Despachador(Socket socket) {
        try {
            this.in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.socket = socket;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void run(){
        try {
            leer();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void leer() throws IOException  {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Recibido: " + inputLine);

            if (gui != null) {  // Cliente
                procesarCliente(inputLine);
            } else {
                procesarServidor(inputLine);
            }
        }
    }

    public void procesarCliente(String entrada)
    {
        String[] datosJugadores = entrada.split("#");
        for (String jugador: datosJugadores) {
            System.out.println("leyendo jugador: " + jugador);
            String[] data = jugador.split(",");

            gui.canvas.jugadores.put(data[0] ,
                    new Raqueta(data[0],
                            getPriority(data[0]),
                            Integer.parseInt(data[1]),
                            Integer.parseInt(data[2])
                    )
            );
        }
        gui.canvas.repaint();
    }


    public void procesarServidor(String entrada)
    {
        String[] datos = entrada.split(":");
        if (datos[0].equals("login")) {
            jugadores.put(datos[1] , new Raqueta(datos[1], null, 10, 10));
        } else if (datos[0].equals("mover")) {
            String[] datosJugador = datos[1].split(",");
            jugadores.get(datosJugador[0]).x = Integer.parseInt(datosJugador[1]);
            jugadores.get(datosJugador[0]).y = Integer.parseInt(datosJugador[2]);
        }

        String[] lista = new String[jugadores.size()];
        int index = 0;
        for (Raqueta e: jugadores.values()) {
            lista[index++] = e.nickname + "," + e.x + "," + e.y;
        }

        for (Despachador e: escritores) {
            e.send(String.join("#", lista));
        }
    }

    public void send(String inputLine)
    {
        try {
            System.out.println("Enviando: " + inputLine);
            out.println(inputLine);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
