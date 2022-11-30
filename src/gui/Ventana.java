/*
  Archivo: Ventana.java
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
 CLASE: Tablero
 INTENCIÓN: El tablero tiene como intención ser el fondo de la pantalla del juego
 - Da el tamaño del fondo
 - Titulo del juego
 - Escucha los eventos del teclado
 RELACIONES:
 - conoce el Tablero
 - conoce la pelota
 - Reconoce los eventos del teclado
 */

package gui;

import Controles.MotorGrafico;
import Juego.Tablero;
import Juego.Pelota;
import Juego.EventoTeclado;

import javax.swing.*;



public class Ventana extends JFrame {

    Tablero canvas;
    Pelota p = new Pelota();

    public Ventana() {
        setTitle("Pong");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        canvas = new Tablero();
        add(canvas);

        addKeyListener(new EventoTeclado());
        new MotorGrafico(canvas).start();
    }

}
