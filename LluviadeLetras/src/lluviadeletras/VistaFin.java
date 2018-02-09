/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lluviadeletras;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Estheruchi
 */
public class VistaFin extends JFrame {

    /*CONSTANTES*/
    private static final int ALTO = 600;
    private static final int ANCHO = 600;

    private Controlador control;

    public VistaFin(Controlador control) {
        this.control = control;
        crearInterfaz();
        this.setLocation(400, 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
    }

    public void crearInterfaz() {
        JLabel titulo = new JLabel("GAME OVER");
        this.add(titulo);
        
        
        CustomLetra cl = new CustomLetra();
        titulo.setBounds(40, 60, 600, 300);
        titulo.setFont(cl.MyFont(1,60f));
        titulo.setForeground(Color.red);
        
        JButton reintentar = new JButton("REINTENTAR");
        reintentar.addActionListener(control);
        reintentar.setBounds(200, 300, 150, 50);
        this.add(reintentar);

        this.setLayout(null);
        this.setSize(ANCHO, ALTO);
        this.setResizable(false);
    }

}
