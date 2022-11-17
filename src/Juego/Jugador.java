/*
  Archivo: Jugador.java
  Autor: Marcela Mazo
  Email: <marcela.mazo@correounivalle.edu.co> <hasse.ortiz@correounivalle.edu.co>
  Modificado por: Marcela Mazo
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-11-16
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

package Juego;

import gui.Ventana;

import java.awt.*;
import java.awt.event.KeyEvent;


//Modela la clase
public class Jugador
{
    //Atributos del jugador

    static final int ancho = 100;
    static final int alto = 100;
    public static int coordenadasEnX = 50;
    public static int coordenadasEnY = 250;
    int coordenadasEnY2 = 0;

    Ventana juego;

    public static boolean saltar = false;
    boolean subir = false;
    boolean bajar = false;

    public Jugador(Ventana juego)
    {
        this.juego = juego;
    }

    public void mover()
    {
        if(saltar)
        {
            if(coordenadasEnY==250)
            {
                //El jugador salta y se queda en el aire
                subir = true;
                coordenadasEnY2 = -5;
                bajar = false;
            }
            if(coordenadasEnY==50)
            {
                //El jugador llega al limite del salto
                bajar = true;
                coordenadasEnY2 = 5;
                subir = false;
            }
            if(subir)
            {
                coordenadasEnY+=coordenadasEnY2;
                if(coordenadasEnY==250)
                {
                    saltar=false;
                }
            }
        }
    }

    public void keyPressed(KeyEvent e)
    {
        // Inicializa la accón de saltar
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            saltar = true;
        }
    }

    public static void paint(Graphics2D graficos)
    {
        graficos.fillRect(coordenadasEnX,coordenadasEnY,ancho,alto);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(coordenadasEnX,coordenadasEnY,ancho,alto);
    }
}
