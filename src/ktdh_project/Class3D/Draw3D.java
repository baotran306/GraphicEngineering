/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project.Class3D;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import ktdh_project.Draw;
import ktdh_project.Point2D;

/**
 *
 * @author aa
 */
public class Draw3D {
    private MyCanvas3D panel;
    public Draw3D(MyCanvas3D panel)
    {
        this.panel = panel;
        this.panel.setVisible(true);
    }
    
    // circle 
    public void CircleMidPoint(int R, int z, JPanel panel){
        int x, y;
        x = 0;
        y = R;
        Put8Pixel(new Point3D(x,y,z), panel);
        int p = 1 - R;
        while(x < y){
            if (p < 0){
                p += 2 * x + 3;
            }
            else{
                p += 2 *(x - y) + 5;
                y--;
            }
            x++;
            if(x % 2 == 0)
                Put8Pixel(new Point3D(x,y,z), panel);
//            System.out.println("1");
        }
        

    }
    private void Put8Pixel(Point3D point, JPanel panel){
        
        int x = point.getX();
        int y = point.getY();
        int z = point.getZ();
        
        fillColor(Point3D.CabinetConvert(new Point3D(x, y, z)), panel);
        fillColor(Point3D.CabinetConvert(new Point3D(x, -y, z)), panel);
        fillColor(Point3D.CabinetConvert(new Point3D(-x, y, z)), panel);
        fillColor(Point3D.CabinetConvert(new Point3D(-x, -y, z)), panel);
        fillColor(Point3D.CabinetConvert(new Point3D(y, x, z)), panel);
        fillColor(Point3D.CabinetConvert(new Point3D(y, -x, z)), panel);
        fillColor(Point3D.CabinetConvert(new Point3D(-y, x, z)), panel);
        fillColor(Point3D.CabinetConvert(new Point3D(-y, -x, z)), panel);
        
        
        
      
    }
    
    public static void fillColor(Point2D p, JPanel panel) {
        int x = p.getX() * 5 + 400;
        int y = p.getY() * -5 + 400;

        Graphics g = panel.getGraphics();
        g.setColor(Color.red);
        g.fillRect(x / 5 * 5, y / 5 * 5, 5, 5);
        System.out.println("hello");

    }
    // cubic 
    public static void DrawRectangular(int x,int y,int z, JPanel panel)
    {
//        Graphics g = panel.getGraphics();
//         g.clearRect(0, 0, 800, 800);
//         panel.paintComponent(g);
        Point3D point1 = new Point3D(0,0,0);
        Point3D point2 = new Point3D(x,0,0);
        Point3D point3 = new Point3D(x,y,0);
        Point3D point4 = new Point3D(0,y,0);
        Point3D point5 = new Point3D(0,0,z);
        Point3D point6 = new Point3D(x,0,z);
        Point3D point7 = new Point3D(x,y,z);
        Point3D point8 = new Point3D(0,y,z);
        
        Point2D p2d1 = Point3D.CabinetConvert(point1);
        Point2D p2d2 = Point3D.CabinetConvert(point2);
        Point2D p2d3 = Point3D.CabinetConvert(point3);
        Point2D p2d4 = Point3D.CabinetConvert(point4);
        Point2D p2d5 = Point3D.CabinetConvert(point5);
        Point2D p2d6 = Point3D.CabinetConvert(point6);
        Point2D p2d7 = Point3D.CabinetConvert(point7);
        Point2D p2d8 = Point3D.CabinetConvert(point8);
//        
//        p2d1.print();
//        p2d2.print();
//        p2d3.print();
//        p2d4.print();
//        p2d5.print();
//        p2d6.print();
//        p2d7.print();
//        p2d8.print();
        
        
        Draw.DashWith2Point(p2d1, p2d2, panel, Color.red);
        Draw.LineWith2Point(p2d2, p2d3, panel, Color.red);
        Draw.LineWith2Point(p2d3, p2d4, panel, Color.red);
        Draw.DashWith2Point(p2d4, p2d1, panel, Color.red);
        
        Draw.LineWith2Point(p2d5, p2d6, panel, Color.red);
        Draw.LineWith2Point(p2d6, p2d7, panel, Color.red);
        Draw.LineWith2Point(p2d7, p2d8, panel, Color.red);
        Draw.LineWith2Point(p2d8, p2d5, panel, Color.red);
        
        Draw.LineWith2Point(p2d2, p2d6, panel, Color.red);
        Draw.LineWith2Point(p2d3, p2d7, panel, Color.red);
        Draw.LineWith2Point(p2d4, p2d8, panel, Color.red);
        Draw.DashWith2Point(p2d1, p2d5, panel, Color.red);
    }
    
    //line
    public void midPoint(int x1, int y1, int x2, int y2) {
        float dist = ((Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2) : Math.abs(y1 - y2));
        float now_x = x1, now_y = y1;
        int push_x, push_y;
        int push = 0, next = 0;
        for (int i = 0; i < dist; i++) {
            
            push_x = Math.round(now_x);
            push_y = Math.round(now_y);
            fillColor(new Point2D(push_x, push_y), panel);
            now_x += (x2 - x1) / dist;
            now_y += (y2 - y1) / dist;

        }
    }
    
  public static void DrawCylinder(int r,int h, JPanel panel)
  {
      
//      Graphics g = panel.getGraphics();
//      g.clearRect(0, 0, 800, 800);
//      panel.paintComponent(g);
      int ry = (int) (r/Math.sqrt(8));
      MidEllipse(r,ry,h, panel);
      MidDashEllipse(r,ry , 0, panel);
      Draw.LineWith2Point( new Point2D(r,0),new Point2D(r,h), panel, Color.red);
      Draw.LineWith2Point( new Point2D(-r,0),new Point2D(-r,h), panel, Color.red);
      Draw.LineWith2Point( new Point2D(r,h),new Point2D(0,h), panel, Color.red);
      Draw.DashWith2Point(new Point2D(0,0),new Point2D(0,h), panel, Color.red);
      Draw.DashWith2Point(new Point2D(0,0),new Point2D(r,0), panel, Color.red);
  }
  public static void MidEllipse(int rx, int ry,int z, JPanel panel) {
        float dx, dy, d1, d2;
        int x, y;
        x = 0;
        y = ry;
        // Initial decision parameter of region 1
        d1 = (ry * ry) - (rx * rx * ry) + (0.25f * rx * rx);
        dx = 2 * ry * ry * x;
        dy = 2 * rx * rx * y;

        // For region 1
        while (dx < dy) {
            System.out.println(x / 4 % 2 + " ");
            // Print points based on 4-way symmetry
            // Put4Pixel(x,y);

           
            fillColor(new Point2D(x, y+z), panel);
            fillColor(new Point2D(-x, y+z), panel);
            fillColor(new Point2D(x, -y+z), panel);
            fillColor(new Point2D(-x, -y+z), panel);

            // Checking and updating value of
            // decision parameter based on algorithm
            if (d1 < 0) {
                x++;
                dx = dx + (2 * ry * ry);
                d1 = d1 + dx + (ry * ry);
            } else {
                x++;
                y--;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d1 = d1 + dx - dy + (ry * ry);
            }
        }

        // Decision parameter of region 2
        d2 = ((ry * ry) * ((x + 0.5f) * (x + 0.5f))) + ((rx * rx) * ((y - 1) * (y - 1))) - (rx * rx * ry * ry);

        // Plotting points of region 2
        while (y >= 0) {
            System.out.println("dt2" + "  " + dx + " " + dy + " " + x + " " + y + " " + d2 + " ");
            System.out.println(x / 4 % 2 + " ");
            // printing points based on 4-way symmetry
            
            fillColor(new Point2D(x, y+z), panel);
            fillColor(new Point2D(-x, y+z), panel);
            fillColor(new Point2D(x, -y+z), panel);
            fillColor(new Point2D(-x, -y+z), panel);

            // Checking and updating parameter
            // value based on algorithm
            if (d2 > 0) {
                y--;
                dy = dy - (2 * rx * rx);
                d2 = d2 + (rx * rx) - dy;
            } else {
                y--;
                x++;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d2 = d2 + dx - dy + (rx * rx);
            }
        }
    }
  public static void MidDashEllipse(int rx, int ry,int z, JPanel panel) {
        float dx, dy, d1, d2;
        int x, y;
        x = 0;
        y = ry;
        // Initial decision parameter of region 1
        d1 = (ry * ry) - (rx * rx * ry) + (0.25f * rx * rx);
        dx = 2 * ry * ry * x;
        dy = 2 * rx * rx * y;

        // For region 1
        while (dx < dy) {
            System.out.println(x / 4 % 2 + " ");
            // Print points based on 4-way symmetry
            // Put4Pixel(x,y);

            if (x / 4 % 2 == 1) {
                fillColor(new Point2D(x, y+z), panel);
                fillColor(new Point2D(-x, y+z), panel);

            }
            fillColor(new Point2D(x, -y+z), panel);
            fillColor(new Point2D(-x, -y+z), panel);

            // Checking and updating value of
            // decision parameter based on algorithm
            if (d1 < 0) {
                x++;
                dx = dx + (2 * ry * ry);
                d1 = d1 + dx + (ry * ry);
            } else {
                x++;
                y--;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d1 = d1 + dx - dy + (ry * ry);
            }
        }

        // Decision parameter of region 2
        d2 = ((ry * ry) * ((x + 0.5f) * (x + 0.5f))) + ((rx * rx) * ((y - 1) * (y - 1))) - (rx * rx * ry * ry);

        // Plotting points of region 2
        while (y >= 0) {
            System.out.println("dt2" + "  " + dx + " " + dy + " " + x + " " + y + " " + d2 + " ");
            System.out.println(x / 4 % 2 + " ");
            // printing points based on 4-way symmetry
            if (y / 4 % 2 == 1) {
                fillColor(new Point2D(x, y+z), panel);
                fillColor(new Point2D(-x, y+z), panel);

            }
            fillColor(new Point2D(x, -y+z), panel);
            fillColor(new Point2D(-x, -y+z), panel);

            // Checking and updating parameter
            // value based on algorithm
            if (d2 > 0) {
                y--;
                dy = dy - (2 * rx * rx);
                d2 = d2 + (rx * rx) - dy;
            } else {
                y--;
                x++;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d2 = d2 + dx - dy + (rx * rx);
            }
        }
    }

    
    
    
}
