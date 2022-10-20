package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Jugador
{
    static final int Ancho=100;
     static final int Alto=100;
    int coordenadasEnX=50;
    public static int coordenadasEnY=250;

    int coordenadasEnY2=0;
    Interfaz juego;
    public static boolean saltar=false;
    boolean subir=false;
    boolean bajar=false;

    public Jugador(Interfaz juego)
    {
        this.juego=juego;
    }

    public void mover()
    {
        if(saltar)
        {
            if (coordenadasEnY==250)
            {
                //El jugaro está estatico
                subir=true;
                coordenadasEnY2=-5;
                bajar=false;
            }
            if (coordenadasEnY==50)
            {
                //El jugador llega al limite del salto
                bajar=true;
                coordenadasEnY2=5;
                subir=false;
            }

            if(subir)
            {
                coordenadasEnY+=coordenadasEnY2;
            }
            if (bajar)
            {
                coordenadasEnY+=coordenadasEnY2;
                if(coordenadasEnY==250)
                {
                    saltar=false;
                }
            }
        }
    }


    public void paint (Graphics2D graficos)
    {
        graficos.fillRect(coordenadasEnX,coordenadasEnY,Ancho,Alto);
    }

    public void keyPressed(KeyEvent e)
    {
        //Inicializa la acción de saltar con la barra espaciadora
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            saltar=true;
        }
    }

    public Rectangle getBounds()
    {

        return new Rectangle(coordenadasEnX,coordenadasEnY,Ancho,Alto);
    }

}
