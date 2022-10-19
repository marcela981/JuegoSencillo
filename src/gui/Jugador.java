package gui;

import java.awt.*;

public class Jugador
{
    static final int Ancho=100;
     static final int Alto=100;
    int coordenadasEnX=50;
    int coordenadasEnY=250;

    int coordenadasEnY2=0;
    Interfaz juego;
    boolean saltar=false;
    boolean subir=false;
    boolean bajar=false;

    public Jugador(Interfaz juego)
    {
        this.juego=juego;
    }

    public void paint (Graphics2D graficos)
    {
        graficos.fillRect(coordenadasEnX,coordenadasEnY,Ancho,Alto);
    }



}
