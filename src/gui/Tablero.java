/*
  Archivo: Tablero.java
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
 CLASE: Tablero
 INTENCIÓN: El tablero tiene como intención ser el fondo de la pantalla del juego
 - Pinta el fondo

 RELACIONES:
 - conoce los obstaculos
 - conoce el jugador
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablero extends JFrame {
    public static int reiniciarJuego = -1;
    Container panel;
    Interfaz lienzo;

    public Tablero() {

        super("Dash");
        setSize(1200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        Interfaz juego = new Interfaz();
        panel.add(juego);

        panel.add(lienzo);


        /*
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
                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE,null,ex );
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

    Interfaz juego;
    public Tablero(Interfaz juego)
    {
        this.juego=juego;
    }

    public void paint(Graphics2D graficos)
    {
        graficos.fillRect(0,0,1200,400);
    }

    */

    }
}

