/*
  Archivo: Audio.java
  Autor: Marcela Mazo, Hassen Ortiz
  Email: <marcela.mazo@correounivalle.edu.co> <hasse.ortiz@correounivalle.edu.co>
  Modificado por: Marcela Mazo, Hassen Ortiz
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-11-30
  Versión: 1.0
  Licencia: GPL
*/

/*
 CLASE: Audio
 INTENCIÓN: Modelamos el audio que interactua con el ambiente del juego
 Cada rebote con las raquetas sonará, cada falta sonará.
 Este se moverá atra vez del tablero del juego y será el medio del juego
 - Interactua con la pelota y la raqueta
 RELACIONES:
 -Conoce el sonido
 */

package Recursos;

import java.applet.AudioClip;


public class Audio {

    public AudioClip getAudio(String direccion) {
        return java.applet.Applet.newAudioClip(getClass().getResource(direccion));
    }

}
