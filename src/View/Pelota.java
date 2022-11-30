/*
  Archivo: Pelota.java
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
 CLASE: Pelota
 INTENCIÓN: Modelamos la pelota con la que interactuará la raqueta
 Este se moverá atra vez del tablero del juego y será el medio del juego
 - Pelota pintafa
 - Rebota con las raquetas
 - Interactua en el ambiente
 RELACIONES:
 -
 */


package View;

import java.applet.AudioClip;
import java.awt.geom.Rectangle2D;
import Recursos.Audio;

public class Pelota {

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private static double y = 0;
    private double dx = 1;
    private double dy = 1;

    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;

    Audio audio = new Audio();
    AudioClip rebote_1=audio.getAudio("/recursos/rebote_pelota1.wav");
    AudioClip rebote_2=audio.getAudio("/recursos/rebote_pelota2.wav");
    AudioClip falta=audio.getAudio("/recursos/falta.wav");


    //retorna la pelota (Rectangle2D implementa la interface Shape)
    public Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, TAMX, TAMY);
    }

    public void moverPelota(Rectangle2D limites, boolean colisionR1, boolean colisionR2) {
        x += dx;
        y += dy;



        if (colisionR1) {
            dx = -dx;
            x = 20;
            rebote_1.play();
        }
        if (colisionR2) {
            dx = -dx;
            x = 755;
            rebote_1.play();
        }

        if (x < limites.getMinX()) {
            score2++; //el puntaje del jugador2 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            falta.play();
        }

        if (x + TAMX >= limites.getMaxX()) {
            score1++; //el puntaje del jugador1 aumenta en uno

            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            audio.getAudio("/recursos/falta.wav").play();
        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();

            dy = -dy;
            rebote_2.play();
        }

        if (y + TAMY >= limites.getMaxY()) {

            y = limites.getMaxY() - TAMY;

            dy = -dy;
            rebote_2.play();
        }

    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }



}
