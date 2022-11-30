/*
  Archivo: MotorGrafico.java
  Autor: Marcela Mazo, Hassen Ortiz
  Email: <marcela.mazo@correounivalle.edu.co> <hasse.ortiz@correounivalle.edu.co>
  Modificado por: Marcela Mazo. Hassen Ortiz
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-11-30
  Versión: 2.0
  Licencia: GPL
*/

/*
 CLASE: MotorGrafico
 INTENCIÓN: Motor del escenario del juego. Necesario para desarrollar un optimo mabiente del juego, en caso de que este tenga una falla se cerrará
 - Pintar el juego
 - Mostrar errores
 RELACIONES:
 - conoce el tablero
 - Conoce la pelota
 */


package Controles;

import View.Tablero;
import View.Pelota;
public class MotorGrafico extends Thread {

    private final Tablero canvas;

    public MotorGrafico(Tablero canvas) {
        this.canvas = canvas;
    }

    @Override
    public void run() {
        while (!Pelota.finJuego) {
            canvas.repaint();
            try {
                //Paint Velocity
                Thread.sleep(5);
            } catch (Exception ex) {
                System.out.println("error in graphics engine: " + ex.getMessage());
            }
        }
    }
}
