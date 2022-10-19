package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Interfaz extends JPanel
{
    Jugador personaje=new Jugador(this);
    Obstaculos bloque = new Obstaculos(this);
    Tablero fondo = new Tablero();

    public boolean terminarJuego = false;
    public boolean perderVida = false;
    public int puntos = 0;
    public int vidas = 3;
    public int niveles = 1;

    public Interfaz()
    {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setFocusable(true);
    }

    public void paintComponet(Graphics graficos)
    {
        super.paintComponent(graficos);
        Graphics2D graficas2=(Graphics2D)graficos;
        graficas2.setPaint(Color.WHITE);

        dibujar(graficas2);
        dibujarPuntaje(graficas2);
    }

    public void dibujar(Graphics2D graficos)
    {
        switch (niveles) {
            case 1 -> {
                graficos.setColor(Color.YELLOW);
                fondo.paint(graficos);
            }
            case 2 -> {
                graficos.setColor(Color.PINK);
                fondo.paint(graficos);
            }
            case 3 -> {
                graficos.setColor(Color.MAGENTA);
                fondo.paint(graficos);
            }
            case 4 -> {
                graficos.setColor(Color.CYAN);
                fondo.paint(graficos);
            }
            case 5 -> {
                graficos.setColor(Color.GREEN);
                fondo.paint(graficos);
            }
            case 6 -> {
                graficos.setColor(Color.WHITE);
                fondo.paint(graficos);
            }
        }

        graficos.setColor(Color.black);
        personaje.paint(graficos);

        graficos.setColor(Color.red);
        bloque.paint(graficos);

        bloque.mover();
        personaje.mover();

    }

    public void dibujarPuntaje(Graphics2D graficos)
    {
        Graphics2D graficas1=graficos, graficas2=graficos;
        Font score=new Font("Arial",Font.BOLD,30);
        graficos.setFont(score);
        graficos.setColor(Color.black);

        graficas1.drawString("Vidas: " + vidas,20,30);
        graficas1.drawString("Puntaje: " + puntos,1000,30);
        graficas1.drawString("Nivel: " +niveles,500,30);

        if(terminarJuego)
        {
            graficas2.setColor(Color.red);
            graficas2.drawString("Se te acabaron las oportunidades",((float)getBounds().getCenterX()/2)+170,70);
        }
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
