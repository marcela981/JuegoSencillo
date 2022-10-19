import gui.Interfaz;

import javax.swing.*;
import javax.swing.JFrame;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            juego.repaint();
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex );
            }
        }

    }
}
