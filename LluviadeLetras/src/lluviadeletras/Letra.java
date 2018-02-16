/*
  Clase Letra: Es una clase de tipo botón que se gestiona a sí misma.
 */
package lluviadeletras;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Estheruchi
 */
public class Letra extends JButton {

    /*VARIABLES COMUNES*/
    private static final int ALTO = 50;
    private static final int ANCHO = 50;
    private static int AVANCE = 5;
    private static int SUBIENDO = 1;
    private static int BAJANDO = 0;

    /*VARIABLES DE CADA BOTÓN*/
    private Modelo modelo;
    private Color color;
    private String letra;
    private int direccion;

    private int velocidad;
    private int pulsaciones;

    private int posX;
    private int posY = - 50;
    private int id;

    /*CONSTRUCTOR*/
    public Letra(Modelo modelo, String letra) {
        this.modelo = modelo;
        this.letra = letra;
        this.direccion = BAJANDO;
        this.setBackground(Color.black);
        this.setOpaque(false);

        generarPosicion();
        generarVelocidad();
        generarPulsaciones();
        dibujarPanel();
    }

    public void generarVelocidad() {
        int n = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
        switch (n) {
            case 1:
                velocidad = 100;
                break;
            case 2:
                velocidad = 90;
                break;
            case 3:
                velocidad = 80;
                break;
            case 4:
                velocidad = 70;
                break;
            case 5:
                velocidad = 60;
                break;
        }
    }

    /**
     * Genera mediante un aletorio el numero de pulsaciones necesarios para
     * elimianr una letra.
     */
    public void generarPulsaciones() {
        this.pulsaciones = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
        generarColorPulsacion();
    }

    public void generarColorPulsacion() {
        switch (pulsaciones) {
            case 1:
                this.setForeground(Color.GREEN);
                break;
            case 2:
                this.setForeground(Color.ORANGE);
                break;
            case 3:
                this.setForeground(Color.RED);
                break;
        }
    }

    /**
     * Cambia la direccion de la letra. Sube o cae.
     */
    public void cambiarDireccion() {
        if (direccion == BAJANDO) {
            direccion = SUBIENDO;
        } else {
            direccion = BAJANDO;
        }
    }

    /**
     * Cambia la posicionY (vertical)
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Genera una posicionX (horizontal) de manera alearoría para que todas las
     * letras tengan una posicion diferente.
     */
    public void generarPosicion() {
        this.posX = (int) Math.floor(Math.random() * (500 - 50 + 1) + 50);
    }

    /**
     * Establece posicion, tamaño, fuente y color de la letra.
     */
    public void dibujarPanel() {
        this.setBounds(posX, posY, ALTO, ANCHO);
        this.setFont(new Font("Arial", 1, 18));
    }

    /**
     * Controla el movimiento de la letra en funcion de la direccion y los
     * límites de la ventana.
     */
    public void mover() {
        if (direccion == BAJANDO) {
            if (posY >= (modelo.altoVentana() - 100)) {
                modelo.fin();
            } else {
                posY += AVANCE;
            }
        } else {
            if (posY <= 0) {
                modelo.fin();
            } else {
                posY -= AVANCE;
            }
        }
        this.setLocation(posX, posY);
    }

    /**
     * Establece la nueva velocidad (pixeles) de moviemiento de la letra.
     *
     * @param AVANCE -> número de píxeles que "saltará" la letra al moverse.
     */
    public void setAVANCE(int AVANCE) {
        Letra.AVANCE = AVANCE;
    }

    /**
     *
     * @return direccion -> Devuelve la direccion actual de la letra.
     */
    public int getDireccion() {
        return direccion;
    }

    public int getPulsaciones() {
        return pulsaciones;
    }

    public void setPulsaciones(int pulsaciones) {
        this.pulsaciones = pulsaciones;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setIdTimer(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    
}
