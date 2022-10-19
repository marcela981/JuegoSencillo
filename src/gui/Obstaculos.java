package gui;

import java.awt.*;

public class Obstaculos
{
    static final int Ancho=50;
    static final int Alto=100;
    static int obstaculoX=-5;
    static int coordenadaEnX=1200;
    int coordenadaEnY=250;

    Interfaz juego;

    public Obstaculos(Interfaz juego)
    {
        this.juego=juego;
    }

    public void mover()
    {
        if(coordenadaEnX<=-50)
        {
            juego.puntos++;
            coordenadaEnX=1200;
            if(juego.puntos==3 | juego.puntos==6 | juego.puntos==9 |  juego.puntos==12 |  juego.puntos==15)
            {

                obstaculoX+=-2;
                juego.niveles++;
            }
        }
        else
        {
            coordenadaEnX+=obstaculoX;
        }

    }

    public void paint(Graphics2D graficos)
    {
        graficos.fillRect(coordenadaEnX,coordenadaEnY,Ancho,Alto);
    }
}
