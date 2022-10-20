package gui;

import java.awt.*;

public class Tablero
{
    Interfaz juego;
    public Tablero(Interfaz juego)
    {
        this.juego=juego;
    }

    public void paint(Graphics2D graficos)

    {
        graficos.fillRect(0,0,1200,400);
    }
}