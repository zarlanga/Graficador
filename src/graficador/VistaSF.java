/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author tyt
 */
public class VistaSF {

    JFrame f;
    MyPanel gra;
    JTextField[] text;

    public void iniciar() {

        f = new JFrame("Swing Paint Demo");
        gra = new MyPanel();
        JPanel ecuacion = new JPanel();
        text = new JTextField[4];
        FlowLayout testLayout = new FlowLayout();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecuacion.setLayout(testLayout);

        for (int i = 0; i < text.length; i++) {
            text[i] = new JTextField();
            text[i].setText(i + "");
            text[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            ecuacion.add(text[i]);

        }

        f.add(ecuacion, BorderLayout.NORTH);
        f.add(gra, BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);

    }
}

class MyPanel extends JPanel {

    int i;

    int escalaX = 50;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(720, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        i++;
        graficarEje(g);
        graficarFuncionSeno(g, 0.5, 200, 0);

//        g.drawString("Altura " + this.getHeight() + "\n Ancho " + this.getWidth(), 10, 20);
    }

    public void graficarEje(Graphics g) {
        int y = this.getHeight() / 2;
        g.drawLine(0, y, this.getWidth(), y);
        int x = 0;
        
        while (x < this.getWidth()) {
            g.drawLine(x*escalaX, y + 4, x*escalaX, y - 4);
            x ++;
            g.drawString(x+"", x*escalaX -2, y-10);
        }

    }

    public void graficarFuncionSeno(Graphics g, double fr, int amp, int fase) {
        int y;
        int yAnt = calcularYSeno(0, fr, amp, fase);
        g.setColor(Color.red);
        for (int x = 1; x < this.getWidth(); x++) {
            y=calcularYSeno(x, fr, amp, fase);
            g.drawLine(x, yAnt, x + 1, y);
            yAnt=y;

        }

    }

    public int calcularYSeno(int x, double fr, int amp, int fase) {
        return this.getHeight() / 2 - (int) (amp * Math.sin(fase + fr * (x / (180 / Math.PI))));
    }
}
