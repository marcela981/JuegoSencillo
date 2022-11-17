/*
  Archivo: Tablero.java
  Autor: Marcela Mazo
  Email: <marcela.mazo@correounivalle.edu.co> <hasse.ortiz@correounivalle.edu.co>
  Modificado por: Marcela Mazo
  <marcela.mazo@correounivalle.edu.co>
  Fecha creación: 2022-10-16
  Fecha última modificación: 2022-11-16
  Versión: 1.3.1
  Licencia: GPL
*/

/*
 CLASE: Tablero
 INTENCIÓN: Modelar las interacciones del juego
 - Mover personaje
 - Interaccion obstaculo
 - Puede saltar y caer
 RELACIONES:
 - conoce la ventana
 */

package Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Tablero
{
    public boolean terminarJuego = false;
    public boolean perderVida = false;
    public int puntos = 0;
    public int vidas = 3;
    public int niveles = 1;
    public Jugador personaje;

    public Tablero()
    {
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e)
            //Salta cada vez que se preiona la barra espaciadora
            {
                personaje.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });

        setFocusable(true);
    }

    private void setFocusable(boolean b)
    {
    }

    public void finJuego()
    {
        terminarJuego = true;
    }

    public void perderVida()
    {
        perderVida = true;
    }

    public void finjuego()
    {
    }
}