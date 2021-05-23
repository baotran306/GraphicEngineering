/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Tran Quoc Bao
 */
public class MyLibrary {
    public static boolean selectMode(int point, LineMode mode){
        if (mode == LineMode.DASH){
            return point % 5 != 0;
        }
        return true;
    }
    
    public static int convert2DX(int x){
        return x * 5 + 400;
    }
    
    public static int convert2DY(int y){
        return y * -5 + 400;
    }
    
    public static void fillColor(Point2D point, JPanel panel){
        Graphics g = panel.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(convert2DX(point.getX()) / 5 * 5, convert2DY(point.getY()) / 5 * 5, 5, 5);
    }
    
    public static boolean checkInside(int x, int y){
        if(x >= 0 && x <= 800 && y >= 00 && y <= 800){
            return true;
        }
        return false;
    }
    
    public static void drawLine2D(Point2D startPoint, Point2D endPoint, LineMode mode, JPanel panel){
        float dist = ((Math.abs(startPoint.getX() - endPoint.getX()) > Math.abs(startPoint.getY() - endPoint.getY()))
                ? Math.abs(startPoint.getX() - endPoint.getX()) : Math.abs(startPoint.getY() - endPoint.getY()));
        float now_x = startPoint.getX(), now_y = startPoint.getY();
        int push_x, push_y;
        int push = 0, next = 0;
        for (int i = 0; i < dist; i++) {
            
            push_x = Math.round(now_x);
            push_y = Math.round(now_y);
            if (checkInside(convert2DX(push_x), convert2DY(push_y)) && selectMode(i, mode)){
                System.out.println(push_x + " " + push_y);
                fillColor(new Point2D(push_x, push_y), panel);
            }
                
            now_x += (endPoint.getX() - startPoint.getX()) / dist;
            now_y += (endPoint.getY() - startPoint.getY()) / dist;

        }
    }
    
}
