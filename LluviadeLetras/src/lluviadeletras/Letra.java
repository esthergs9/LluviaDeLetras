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
        this.velocidad = (int) Math.floor(Math.random() * (5 - 1 + 1) + 1);
    }

    public void generarPulsaciones() {
        this.pulsaciones = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
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
        this.setForeground(Color.RED);
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

}
