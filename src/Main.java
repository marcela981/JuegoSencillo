/*
  Archivo: Interfaz.java
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
 HISTORIA:
  Crear un juego el cual cuente con un jugador(personaje), obstaculos(Bloques), un tablero (fondo), y que este jugador pueda desplazarse por la pantalla
  atraves del teclado. El jugador puede colisionar con obstaculos. El jugador tiene caracteristicas como vida y puntaje.
 */

import gui.Tablero;


public class Main
{
    public static void main(String[] args)
    {
       Tablero ventana = new Tablero();
       ventana.setVisible(true);

    }
}
