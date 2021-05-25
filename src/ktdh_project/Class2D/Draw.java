/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project.Class2D;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aa
 */
public class Draw {
    public static void LineWith2Point(Point2D point1,Point2D point2, JPanel g, Color c){
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        
        float dist = ((Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2) : Math.abs(y1 - y2));
        
        float now_x = x1, now_y = y1;
        int push_x, push_y;
        int push = 0, next = 0;
        double blank = 5, test1, test2;
        for(int i = 0; i < dist; i++){
            
            push_x = Math.round(now_x);
                push_y = Math.round(now_y);
                put_pixel(push_x, push_y, g,c);
            
            now_x += (x2 - x1) / dist;
            now_y += (y2 - y1) / dist;
            
        }
    }
    
    public static void LineWith2Point(Point2D point1,Point2D point2, Graphics g, Color c){
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        
        float dist = ((Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2) : Math.abs(y1 - y2));
        
        float now_x = x1, now_y = y1;
        int push_x, push_y;
        int push = 0, next = 0;
        double blank = 5, test1, test2;
        for(int i = 0; i < dist; i++){
            
            push_x = Math.round(now_x);
                push_y = Math.round(now_y);
                put_pixel(push_x, push_y, g,c);
            
            now_x += (x2 - x1) / dist;
            now_y += (y2 - y1) / dist;
            
        }
    }
    
    public static void DashWith2Point(Point2D point1,Point2D point2, JPanel g, Color c){
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        
        float dist = ((Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2) : Math.abs(y1 - y2));
        
        float now_x = x1, now_y = y1;
        int push_x, push_y;
        int push = 0, next = 0;
        double  test1, test2;
        for(int i = 0; i < dist; i++){
            
            push_x = Math.round(now_x);
            push_y = Math.round(now_y);
            
            if(i%6<3)
            {
                put_pixel(push_x, push_y, g,c);
            }
            
            
            now_x += (x2 - x1) / dist;
            now_y += (y2 - y1) / dist;
            
        }
    }
    public static void put_pixel(int x, int y, JPanel panel, Color c){
        x = x * 5 + 400;
        y = y * -5 + 400;
        Graphics g = panel.getGraphics();
        g.setColor(c);
        g.fillRect(x / 5 * 5, y / 5 * 5, 5, 5);
    }
    
    public static void put_pixel(int x, int y, Graphics g, Color c){

        x = x * 5 + 400;
        y = y * -5 + 400;
        g.setColor(c);
        g.setColor(c);
        g.fillRect(x / 5 * 5, y / 5 * 5, 5, 5);
    }
}
