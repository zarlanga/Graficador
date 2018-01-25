/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author tyt
 */
public class VistaSF {

//    JFrame f;
    public void iniciar() {

        JFrame f = new JFrame("Graficador");
        MyPanel gra = new MyPanel();

//        f.setSize(600, 600);
        f.add(gra, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.pack();
        f.setVisible(true);

    }
}

class MyPanel extends JPanel {

    int escalaX = 30;
    JSpinner[] text;
    JLabel[] nombreVar;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        JButton graficar = new JButton("graficar");
        JPanel ecuacion = new JPanel();
        text = new JSpinner[3];
        nombreVar = new JLabel[3];
        String[] descVar = {"Frecuencia", "Amplitud", "fase"};
//        int[] valVar={ 1, 200, 0};

        FlowLayout testLayout = new FlowLayout();
        ecuacion.setLayout(testLayout);

        for (int i = 0; i < text.length; i++) {
            nombreVar[i] = new JLabel();
            nombreVar[i].setText(descVar[i]);
            ecuacion.add(nombreVar[i]);

            text[i] = new JSpinner();
//            text[i].setValue(valVar[i]);
            ecuacion.add(text[i]);

        }
        text[0].setModel(new SpinnerNumberModel(1.0, 0, 1000.0, 0.1));
        text[1].setModel(new SpinnerNumberModel(200, 0, 1000, 1));
        text[2].setModel(new SpinnerNumberModel(0, -1000, 1000, 1));

        graficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        ecuacion.add(graficar, BorderLayout.EAST);

        this.add(ecuacion, BorderLayout.NORTH);
    }

    public Dimension getPreferredSize() {
        return new Dimension(720, 600);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.print(text[0].getModel().toString());
        graficarEje(g);
        graficarFuncionSeno(g, (double) text[0].getValue() / 1.0,
                (int) text[1].getValue(), (int) text[2].getValue());
//        graficarFuncionSeno(g, 1, 200, 0);

//        g.drawString("Altura " + this.getHeight() + "\n Ancho " + this.getWidth(), 10, 20);
    }

    public void graficarEje(Graphics g) {
        int y = this.getHeight() / 2;
        g.drawLine(0, y, this.getWidth(), y);
        int x = 0;

        while (x < this.getWidth()) {
            g.drawLine(x * escalaX, y + 4, x * escalaX, y - 4);
            x++;
            g.drawString(x + "", x * escalaX - 2, y - 10);
        }

    }

    public void graficarFuncionSeno(Graphics g, double fr, int amp, int fase) {
        int y;
        int yAnt = calcularYSeno(0, fr, amp, fase);
        g.setColor(Color.red);
        for (int x = 1; x < this.getWidth(); x++) {
            y = calcularYSeno(x, fr, amp, fase);
            g.drawLine(x, yAnt, x + 1, y);
            yAnt = y;

        }

    }

    public int calcularYSeno(int x, double fr, int amp, int fase) {
        return this.getHeight() / 2 - (int) (amp * Math.sin(fase + fr * (x / (double) escalaX)));

//resultado en grados
//        return this.getHeight() / 2 - (int) (amp * Math.sin(fase + fr * ((x/(double) escalaX) / (180 / Math.PI)))); 
    }

}
