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

import gui.*;

import javax.swing.*;
import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.Interfaz;

public class Main
{
    public static int reiniciarJuego=-1;

    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null,"¿Preparado?");
        JFrame ventana = new JFrame("Dash");
        Interfaz juego = new Interfaz();
        ventana.add(juego);
        ventana.setSize(1200,400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true)
        {

            if(juego.terminarJuego)
            {
                reiniciarJuego=JOptionPane.showConfirmDialog(null,"PERDISTE, ¿Deseas reiniciar el juego?","PERDISTE", JOptionPane.YES_NO_OPTION);
                if(reiniciarJuego==0)
                {
                    juego.terminarJuego=false;
                    Obstaculos.obstaculoX=-5;
                    Obstaculos.coordenadasEnX=1200;
                    juego.puntos=0;
                    juego.niveles=1;
                    juego.vidas=3;
                    reiniciarJuego=-1;
                }
                else if(reiniciarJuego==1)
                {
                    System.exit(0);
                }
            }
            else
            {
                juego.repaint();
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex );
                }

                if (juego.perderVida)
                {
                    JOptionPane.showMessageDialog(null,"¡HEY! Presta más atención");
                    juego.perderVida=false;
                    juego.vidas--;
                    Obstaculos.coordenadasEnX=1200;
                    Jugador.saltar=false;
                    Jugador.coordenadasEnY=250;
                }
            }

        }

    }
}
