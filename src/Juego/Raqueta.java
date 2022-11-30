/*
  Archivo: Raqueta.java
  Autor: Marcela Mazo, Hassen Ortiz
  Email: <marcela.mazo@correounivalle.edu.co> <hasse.ortiz@correounivalle.edu.co>
  Modificado por: Marcela Mazo, Hassen Ortiz
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-11-30
  Versión: 2.0
  Licencia: GPL
*/

/*
 CLASE: Raqueta
 INTENCIÓN: Medio por el cual interactuamos en el juego, cada raqueta es un jugador. La función es atajar la pelota
 - Describe la raqueta con la que el jugador interactua
 */

package Juego;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class Raqueta {

    private int x, y;
    static final int ANCHO = 10, ALTO = 60;

    public Raqueta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getRaqueta() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void moverR1(Rectangle limites) {
        if (EventoTeclado.w && y > limites.getMinY()) {
            y--;
        }
        if (EventoTeclado.s && y < limites.getMaxY()-ALTO) {
            y++;
        }
    }

    public void moverR2(Rectangle limites) {
        if (EventoTeclado.up && y > limites.getMinY()) {
            y--;
        }
        if (EventoTeclado.down && y < limites.getMaxY()-ALTO) {
            y++;
        }
    }
}