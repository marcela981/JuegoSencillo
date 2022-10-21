/*
  Archivo: Obstaculos.java
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
 CLASE: Obstaculos
 INTENCIÓN: Tiene como fin representar los diferentes obstaculos del juego
 - Describe el obstaculo Bloque
 RELACIONES:
 - conoce el jugador
 */



package gui;

import java.awt.*;


public class Obstaculos
{
    //Variables que delimitan el obstaculo
    //Tamaño del obstaculo
    static final int Ancho=50;
    static final int Alto=100;
    //Coordenadas del obstaculo en la interfaz
    public static int coordenadasEnX;
    public static int obstaculoX=-5;
    static int coordenadaEnX=1200;
    int coordenadaEnY=250;

    Interfaz juego;

    public Obstaculos(Interfaz juego)
    {
        this.juego=juego;
    }

    //Cada vez que el personaje colisione conn un obstaculo este genera puntos
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
        //Si este colisiona cierta cantidas de veces el uego termina
        {
            if(colision())
            {
                if(juego.vidas==0)
                {
                    juego.finJuego();
                }
                else
                //Si el jugador colisiona con el obeto pierde una vida
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
