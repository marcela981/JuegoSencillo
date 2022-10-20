/*
  Archivo: Tablero.java
  Autor: Marcela Mazo
  Email: marcela.mazo@correounivalle.edu.co
  Modificado por: Marcela Mazo
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-10-19
  Versión: 1.2.1
  Licencia: GPL
*/

/*
 CLASE: Tablero
 INTENCIÓN: El tablero tiene como intención ser el fondo de la pantalla del juego
 - Pinta el fondo

 RELACIONES:
 - conoce los obstaculos
 - conoce el jugador
 */

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