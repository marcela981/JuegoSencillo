/*
  Archivo: Ventana.java
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
 INTENCIÓN: El tablero tiene como intención ser el fondo de la pantalla del juego
 - Pinta el fondo

 RELACIONES:
 - conoce los obstaculos
 - conoce el jugador
 */

package gui;

import Juego.Jugador;


import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Graphics;

import static java.awt.Color.*;


public class Ventana extends javax.swing.JFrame
{
    Jugador personaje = new Jugador(this);


    private Container panel;
    private JTextField hola;


    public boolean terminarJuego = false;
    public boolean perderVida = false;
    public int puntos = 0;
    public int vidas = 3;
    public int niveles = 1;


    public Ventana()
    {
        super("Dash");
        setSize(1200, 400);
        setLayout(null);
        panel = getContentPane();

        this.getContentPane().setBackground(yellow);

    }

    public Ventana(Object main)
    {
    }

/*
    private void dibujarPuntaje(Graphics2D graficos)
    {
        Graphics2D graficas1=graficos, graficas2=graficos;
        Font score=new Font("Arial",Font.BOLD,30);
        graficos.setFont(score);
        graficos.setColor(black);

        graficas1.drawString("Vidas: " + vidas,20,30);
        graficas1.drawString("Puntaje: " + puntos,1000,30);
        graficas1.drawString("Nivel: " +niveles,500,30);

        if(terminarJuego)
        {
            graficas2.setColor(red);
            graficas2.drawString("Se te acabaron las oportunidades",((float)getBounds().getCenterX()/2)+170,70);
        }
        setVisible(true);

    }

    public void finJuego()
    {
        terminarJuego=true;
    }

    public void perderVida()
    {
        perderVida=true;
    }

}










    /*
    public Jugador personaje = new Jugador(this);
    Obstaculo bloque = new Obstaculo(this);
    Ventana fondo = new Ventana();

    private Container panel;
    public boolean terminarJuego = false;
    public boolean perderVida = false;
    public int puntos = 0;
    public int vidas = 3;
    public int niveles = 1;



    public Ventana()
    {

        super("Dash");
        JOptionPane.showMessageDialog(null, "¿Preparado?");

        setSize(1200, 400);
        setLayout(null);
        panel = getContentPane();


        //Variables del juego



    public void paintComponet(Graphics graficos)
    {
        super.paint(graficos);
        Graphics2D graficas2 = (Graphics2D) graficos;
        dibujar(graficas2);
        dibujarPuntaje(graficas2);

        graficas2.setPaint(Color.WHITE);

    }

    public void dibujar(Graphics2D graficos)
    {
        switch (niveles)
        {
            case 1 ->
            {
                graficos.setColor(Color.YELLOW);
                fondo.paint(graficos);
            }
            case 2 ->
            {
                graficos.setColor(Color.PINK);
                fondo.paint(graficos);
            }
            case 3 ->
            {
                graficos.setColor(Color.MAGENTA);
                fondo.paint(graficos);
            }
            case 4 ->
            {
                graficos.setColor(Color.CYAN);
                fondo.paint(graficos);
            }
            case 5 ->
            {
                graficos.setColor(Color.GREEN);
                fondo.paint(graficos);
            }
            case 6 ->
            {
                graficos.setColor(Color.WHITE);
                fondo.paint(graficos);
            }
        }

        graficos.setColor(Color.black);
        Personaje.paint(graficos);

        graficos.setColor(Color.red);
        Bloque.paint(graficos);

        bloque.mover();
        personaje.mover();

    }

    public void dibujarPuntaje(Graphics2D graficos) {
        Graphics2D graficas1 = graficos, graficas2 = graficos;
        Font score = new Font("Arial", Font.BOLD, 30);
        graficos.setFont(score);
        graficos.setColor(Color.black);

        graficas1.drawString("Vidas: " + vidas, 20, 30);
        graficas1.drawString("Puntaje: " + puntos, 1000, 30);
        graficas1.drawString("Nivel: " + niveles, 500, 30);

        if (terminarJuego) {
            graficas2.setColor(Color.red);
            graficas2.drawString("Se te acabaron las oportunidades", ((float) getBounds().getCenterX() / 2) + 170, 70);
        }
    }
*/

}





