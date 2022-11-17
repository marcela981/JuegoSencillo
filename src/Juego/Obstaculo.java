/*
  Archivo: Obstaculo.java
  Autor: Marcela Mazo
  Email: <marcela.mazo@correounivalle.edu.co> <hasse.ortiz@correounivalle.edu.co>
  Modificado por: Marcela Mazo
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-11-16
  Versión: 1.3.1
  Licencia: GPL
*/

/*
 CLASE: Obstaculos
 INTENCIÓN: Tiene como fin representar los diferentes obstaculos del juego
 - Describe el obstaculo Bloque
 RELACIONES:
 - conoce el jugador
 */

package Juego;

import java.awt.*;


public class  Obstaculo
{
    //Variables que delimitan el obstaculo
    //Tamaño del obstaculo
    static final int ancho=50;
    static final int alto=50;

    //Coordendas del obstaculo
    public static int coordenadasEnX;
    public static int obstaculoX=-5;
    static int getcoordenadasEnX=1200;
    public static int coordenadasEnY=250;

    Tablero juego;

    public Obstaculo(Tablero juego)
    {
        this.juego=juego;
    }

    //Cada vez que el personaje impacte el obstaculo este genera puntos
    public void mover()
    {
        if (coordenadasEnX<=-50)
        {
            juego.puntos++;
            coordenadasEnX=1200;
            if(juego.puntos==3 | juego.puntos==6 | juego.puntos ==9 | juego.puntos==12)
            {
                obstaculoX+=-2;
                juego.niveles++;
            }
        }
        else//Si este colisiona cierta cantidad de veces el juego termina
        {
            if(colision())
            {
                if(juego.vidas==0)
                {
                    juego.finjuego();
                }
                //Si el jugadir colisiona con el objeto pierde una vida
                else
                {
                    juego.perderVida();
                }
            }
            else
            {
                coordenadasEnX+=obstaculoX;
            }
        }
    }

    private boolean colision()
    {

        return false;
    }

    public boolean colison()
    {
        return juego.personaje.getBounds().intersects(getBouds());
    }

    public Rectangle getBouds()
    {
        return new Rectangle(coordenadasEnX-5,coordenadasEnY,ancho,alto);
    }

    public static void paint(Graphics2D graficos)
    {
        graficos.fillRect(coordenadasEnX,coordenadasEnY,ancho,alto);
    }

}