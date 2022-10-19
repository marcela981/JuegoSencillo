package gui;

import java.awt.*;

public class Obstaculos
{
    static final int Ancho=50;
    static final int Alto=100;
    public static int coordenadasEnX;
    public static int obstaculoX=-5;
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
            if(colision())
            {
                if(juego.vidas==0)
                {
                    juego.finJuego();
                }
                else
                {
                    juego.perderVida();
                }
            }
            else
            {
                coordenadaEnX+=obstaculoX;
            }

        }

    }

    public boolean colision()
    {
        return juego.personaje.getBounds().intersects(getBouds());
    }

    public void paint(Graphics2D graficos)
    {
        graficos.fillRect(coordenadaEnX,coordenadaEnY,Ancho,Alto);
    }

    public Rectangle getBouds()
    {
        return new Rectangle(coordenadaEnX-5,coordenadaEnY,Ancho,Alto);
    }

}
