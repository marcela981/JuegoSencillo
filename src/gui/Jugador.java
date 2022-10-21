/*
  Archivo: Jugador.java
  Autor: Marcela Mazo, Hassen Ortiz
  Email: <marcela.mazo@correounivalle.edu.co> <hasse.ortiz@correounivalle.edu.co>
  Modificado por: Marcela Mazo
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-10-19
  Versión: 1.2.1
  Licencia: GPL
*/

/*
 CLASE: Jugador
 INTENCIÓN: Modelamos el personaje que itnteractua en el juego, este podrá que manejado con las flechas del techado
 - Rescatngulo pintado
 - Se puede mover con flechas
 - Puede saltar y caer
 RELACIONES:
 - conoce los obstaculos
 */


package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

//Modela la clase jugador
public class Jugador
{
    //Atributos del jugador
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
