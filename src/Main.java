/*
  Archivo: Main.java
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
 HISTORIA:
  Crear un juego el cual cuente con dos jugadores(Raqueta), medio del juego(pelota),
  una interfaz que pinte las caracteristicas del juego (Tablero), un panel que sirva para mostrar el juego en pantalla (Ventana)
  Este juego tiene como intension que dos jugadores interactuen a traves de la pantalla, ambos interactuaran con una pelota
  y esta rebotará en la raqueta de cada jugador. Gana La persona con menos vidas perdidas
  Habrá funciones con el teclado, sistema de puntos pintados, rebote en la pelota y sonido casda vez que esta toque una de las raquetas
  Sirve para dos jugadores locales.
 */

import View.Ventana;
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
