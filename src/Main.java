import gui.Interfaz;
import gui.Jugador;
import gui.Obstaculos;

import javax.swing.*;
import javax.swing.JFrame;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.Obstaculos;

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
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex );
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
