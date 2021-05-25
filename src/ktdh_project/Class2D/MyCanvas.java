/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project.Class2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Tran Quoc Bao
 */
public class MyCanvas extends JPanel{
    @Override
    public void paintComponent(Graphics g) {

        // draw and display the line
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, 800, 800);
        for (int i = 0; i <= 800; i += 5) {
            g2d.drawLine(i, 0, i, 800);
            g2d.drawLine(0, i, 800, i);
        }
        
        g2d.setColor(Color.BLUE);
        g.fillRect(400, 0, 5, 800);
        g.fillRect(0, 400, 800, 5);
    }
}
