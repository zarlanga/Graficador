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
        text = new JTextField[4];
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < text.length; i++) {
            text[i] = new JTextField();
//            System.out.println(text[i]);
//            text[i].setBounds(0, i*30, f.getWidth(), 30);
            text[i].setText(i + "");
            f.getContentPane().add(text[i], BorderLayout.NORTH);

        }

        f.getContentPane().add(gra, BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);

    }
}

class MyPanel extends JPanel {

    int i;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(720, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        i++;
        
        int y0 = this.getHeight()/2;
        int y1;
        
        g.drawLine(0, y0 , this.getWidth(), y0);
        g.setColor(Color.red);
//        System.out.println(Math.sin(Math.PI/2));
        for (int x0=1; x0 < this.getWidth(); x0++ ) {
            y1=y0 + (int) ((this.getHeight()/4) * Math.sin(x0/(180/Math.PI))) ;
//            y1=2*x0;
          g.drawLine(x0, y1 , x0+1, y1);
//            System.out.println("x0="+ x0 +  "\ny1=" + y1);
        }

//        g.drawLine(0, 30, 60, 60);
        // Draw Text
        g.drawString("Altura " + this.getHeight() + "\n Ancho " + this.getWidth(), 10, 20);
    }
    
    public void graficarFuncion(){
        
    }
}
