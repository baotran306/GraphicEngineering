/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project.Objects2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ktdh_project.MyCanvas;

/**
 *
 * @author DoKhang
 */
public class Drawer {
    public static void clear(MyCanvas panel) {
        Graphics g = panel.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
         Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        for (int i = 0; i <= 800; i += 5) {
            g2d.drawLine(i, 0, i, 800);
            g2d.drawLine(0, i, 800, i);
        }
    }

    public static int diemDoiXung(int x, int Ox) {
        x = x - Ox;
        x = -x;
        x = x + Ox;
        return x;
    }

    public static int[] xoayQuaDiem(int centerX, int centerY, int x, int y, double angle) {
        int newX = (int) (centerX + (x - centerX) * Math.cos(angle) - (y - centerY) * Math.sin(angle));
        int newY = (int) (centerY + (x - centerX) * Math.sin(angle) + (y - centerY) * Math.cos(angle));
        int[] c = {newX, newY};
        return c;
    }

    public static void fillColor(int x, int y, MyCanvas panel,Color color) {
        x = x * 5;
        y = y * 5;
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.fillRect(x / 5 * 5, y / 5 * 5, 5, 5);

    }

    public static void midPoint(int x1, int y1, int x2, int y2, MyCanvas panel, Color color) {
        float dist = ((Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2) : Math.abs(y1 - y2));
        float now_x = x1, now_y = y1;
        int push_x, push_y;
        int push = 0, next = 0;
        for (int i = 0; i < dist; i++) {

            push_x = Math.round(now_x);
            push_y = Math.round(now_y);
            fillColor(push_x, push_y, panel,color);

            now_x += (x2 - x1) / dist;
            now_y += (y2 - y1) / dist;

        }
    }

    public static void putPixel(int c, int d, int e, int f, MyCanvas panel, Color color) {
        fillColor(c + e, d + f, panel,color);
        fillColor(c + e, -d + f, panel,color);
        fillColor(-c + e, d + f, panel,color);
        fillColor(-c + e, -d + f, panel,color);
        fillColor(d + e, c + f, panel,color);
        fillColor(d + e, -c + f, panel,color);
        fillColor(-d + e, c + f, panel,color);
        fillColor(-d + e, -c + f, panel,color);
    }

    public static void helicopter(int a, int b, int rx, int ry, MyCanvas panel) { // a,b la toa do tam elipse, rx,ry la                                                                                 // do phong to cua hinh                                                                                 // voi rx>ry va ti le dep nhat rx=2ry                                                                                 
        // DRAW ELIPSE
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
            // Print points based on 4-way symmetry
            fillColor(x + a, -y + b, panel,Color.RED);
            fillColor(-x + a, -y + b, panel,Color.RED);
            fillColor(x + a, y + b, panel,Color.RED);
            fillColor(-x + a, y + b, panel,Color.RED);
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
            // printing points based on 4-way symmetry

            fillColor(x + a, -y + b, panel,Color.RED);
            fillColor(-x + a, -y + b, panel,Color.RED);

            fillColor(x + a, y + b, panel,Color.RED);
            fillColor(-x + a, y + b, panel,Color.RED);

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

        // DRAW DUOI MAYBAY
        midPoint((a + rx), b, (a + rx + ry), b, panel,Color.RED);
        midPoint((a + rx + ry), (b - ry + 2), (a + rx + ry), (b + 5), panel,Color.RED);
        midPoint((a + rx + ry + ry / 2), (b - ry), (a + rx + ry + ry / 2), (b + 5), panel,Color.RED);
        midPoint((a + rx + ry), (b - ry + 2), (a + rx + ry + ry / 2), (b - ry), panel,Color.RED);
        midPoint((a + rx + ry), (b + 5), (a + rx + ry + ry / 2), (b + 5), panel,Color.RED);
        // DRAW BE DAP
        midPoint((a - rx * 2 / 3), (b + ry), (a + rx * 2 / 3), (b + ry), panel,Color.BLACK);
        midPoint((a - rx * 2 / 3), (b + ry + ry / 2), (a + rx * 2 / 3), (b + ry + ry / 2), panel,Color.BLACK);
        midPoint((a - rx * 2 / 3), (b + ry), (a - rx * 2 / 3), (b + ry + ry / 2), panel,Color.BLACK);
        midPoint((a + rx * 2 / 3), (b + ry), (a + rx * 2 / 3), (b + ry + ry / 2), panel,Color.BLACK);
        // DRAW CANH MAY BAY
        midPoint(a, (b - ry), a, (b - ry - ry * 1 / 3), panel,Color.BLACK);
        midPoint((a - rx), (b - ry - ry * 1 / 3), (a + rx), (b - ry - ry * 1 / 3), panel,Color.BLACK);
        midPoint((a - rx), (b - ry - ry * 2 / 3), (a + rx), (b - ry - ry * 2 / 3), panel,Color.BLACK);
        midPoint((a - rx), (b - ry - ry * 1 / 3), (a - rx), (b - ry - ry * 2 / 3), panel,Color.BLACK);
        midPoint((a + rx), (b - ry - ry * 1 / 3), (a + rx), (b - ry - ry * 2 / 3), panel,Color.BLACK);
        // DRAW HINH TRON

        int c, d;
        c = 0;
        d = rx * 1 / 4;
        int e = (a - rx * 1 / 3);
        int f = (b);

        putPixel(c, d, e, f, panel,Color.BLUE);
        int p = 1 - rx * 2 / 3;
        while (c < d) {
            if (p < 0) {
                p += 2 * c + 2;
            } else {
                p += 2 * (c - d) + 5;
                d--;
            }
            c++;

            putPixel(c, d, e, f, panel,Color.BLUE);

        }

    }

    public static void helicopter(Helicopter helicopter, MyCanvas panel) { // a,b la toa do tam elipse, rx,ry la
        // do phong to cua hinh
        // voi rx>ry va ti le dep nhat rx=2ry

        int a = helicopter.getX();
        int b = helicopter.getY();
        int rx = helicopter.getW();
        int ry = helicopter.getH();
        // DRAW ELIPSE
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
            // Print points based on 4-way symmetry
            fillColor(x + a, -y + b, panel,Color.RED);
            fillColor(-x + a, -y + b, panel,Color.RED);
            fillColor(x + a, y + b, panel,Color.RED);
            fillColor(-x + a, y + b, panel,Color.RED);
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
            // printing points based on 4-way symmetry

            fillColor(x + a, -y + b, panel,Color.RED);
            fillColor(-x + a, -y + b, panel,Color.RED);

            fillColor(x + a, y + b, panel,Color.RED);
            fillColor(-x + a, y + b, panel,Color.RED);

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

        // DRAW DUOI MAYBAY
        int a0 = (helicopter.isDirection()) ? (a + rx) : diemDoiXung((a + rx), a);
        int a1 = (helicopter.isDirection()) ? (a + rx + ry) : diemDoiXung((a + rx + ry), a);
        int a2 = (helicopter.isDirection()) ? (a + rx + ry + ry / 2) : diemDoiXung((a + rx + ry + ry / 2), a);

        midPoint(a0, b, a1, b, panel,Color.RED);
        midPoint(a1, (b - ry + 2), a1, (b + 5), panel,Color.RED);
        midPoint(a2, (b - ry), a2, (b + 5), panel,Color.RED);
        midPoint(a1, (b - ry + 2), a2, (b - ry), panel,Color.RED);
        midPoint(a1, (b + 5), a2, (b + 5), panel,Color.RED);

        // DRAW BE DAP
        midPoint((a - rx * 2 / 3), (b + ry), (a + rx * 2 / 3), (b + ry), panel,Color.BLACK);
        midPoint((a - rx * 2 / 3), (b + ry + ry / 2), (a + rx * 2 / 3), (b + ry + ry / 2), panel,Color.BLACK);
        midPoint((a - rx * 2 / 3), (b + ry), (a - rx * 2 / 3), (b + ry + ry / 2), panel,Color.BLACK);
        midPoint((a + rx * 2 / 3), (b + ry), (a + rx * 2 / 3), (b + ry + ry / 2), panel,Color.BLACK);
        // DRAW CANH MAY BAY
        midPoint(a, (b - ry), a, (b - ry - ry * 1 / 3), panel,Color.BLACK);
        midPoint((a - rx), (b - ry - ry * 1 / 3), (a + rx), (b - ry - ry * 1 / 3), panel,Color.BLACK);
        midPoint((a - rx), (b - ry - ry * 2 / 3), (a + rx), (b - ry - ry * 2 / 3), panel,Color.BLACK);
        midPoint((a - rx), (b - ry - ry * 1 / 3), (a - rx), (b - ry - ry * 2 / 3), panel,Color.BLACK);
        midPoint((a + rx), (b - ry - ry * 1 / 3), (a + rx), (b - ry - ry * 2 / 3), panel,Color.BLACK);
        // DRAW HINH TRON

        int c, d;
        c = 0;
        d = rx * 1 / 4;
        // vi tri cua so

        int e = (helicopter.isDirection()) ? (a - rx * 1 / 3) : (a + rx * 1 / 3);
        int f = (b);

        putPixel(c, d, e, f, panel,Color.BLUE);
        int p = 1 - rx * 2 / 3;
        while (c < d) {
            if (p < 0) {
                p += 2 * c + 2;
            } else {
                p += 2 * (c - d) + 5;
                d--;
            }
            c++;

            putPixel(c, d, e, f, panel,Color.BLUE);

        }

    }

    public static void rocket(int a, int b, int rx, int ry, double angle, MyCanvas panel) {// ti le rx ry thi ry>rx dep nhat la ry=2rx
        // DRAW ELIPSE
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
            // Print points based on 4-way symmetry
            int[] c = xoayQuaDiem(a, b, x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);

//            fillColor(x + a, -y + b, panel);
//            fillColor(-x + a, -y + b, panel);
//            fillColor(x + a, y + b, panel);
//            fillColor(-x + a, y + b, panel);
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
            // printing points based on 4-way symmetry

            int[] c = xoayQuaDiem(a, b, x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
//            fillColor(x + a, -y + b, panel);
//            fillColor(-x + a, -y + b, panel);
//            fillColor(x + a, y + b, panel);
//            fillColor(-x + a, y + b, panel);

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
        // DRAW LINE
        int temp = ry / rx;
        int dolech = ry / (temp + 4);
        int[] c1 = xoayQuaDiem(a, b, (a - rx + dolech), (b - ry * 2 / 3), angle);
        int[] c2 = xoayQuaDiem(a, b, (a + rx - dolech + 1), (b - ry * 2 / 3), angle);
        //midPoint((a - rx + dolech), (b - ry * 2 / 3), (a + rx - dolech + 1), (b - ry * 2 / 3), panel);
        midPoint(c1[0], c1[1], c2[0], c2[1],panel,Color.RED);
        // DRAW DUOI
        c1 = xoayQuaDiem(a, b, (a - rx), (b + ry), angle);

        c2 = xoayQuaDiem(a, b, (a + rx), (b + ry), angle);
        midPoint(c1[0], c1[1], c2[0], c2[1], panel,Color.RED);

        c2 = xoayQuaDiem(a, b, (a - rx + dolech), (b + ry - dolech), angle);
        midPoint(c1[0], c1[1], c2[0], c2[1], panel,Color.RED);

        c1 = xoayQuaDiem(a, b, (a + rx), (b + ry), angle);
        c2 = xoayQuaDiem(a, b, (a + rx - dolech), (b + ry - dolech), angle);
        midPoint(c1[0], c1[1], c2[0], c2[1], panel,Color.RED);

//        midPoint((a - rx), (b + ry), (a + rx), (b + ry), panel);
//        midPoint((a - rx), (b + ry), (a - rx + dolech), (b + ry - dolech), panel);
//        midPoint((a + rx), (b + ry), (a + rx - dolech), (b + ry - dolech), panel);
        // draw hinh tron
        int c, d;
        c = 0;
        d = rx * 1 / 3;

        putPixel(c, d, a, b, panel,Color.BLUE);
        int p = 1 - rx * 2 / 3;
        while (c < d) {
            if (p < 0) {
                p += 2 * c + 2;
            } else {
                p += 2 * (c - d) + 5;
                d--;
            }
            c++;

            putPixel(c, d, a, b, panel,Color.BLUE);
        }
    }

    public static void rocket(Rocket rocket, MyCanvas panel) {// ti le rx ry thi ry>rx dep nhat la ry=2rx
        // DRAW ELIPSE
        int a = rocket.getX();
        int b = rocket.getY();
        int rx = rocket.getW();
        int ry = rocket.getH();
        double angle = rocket.getAngle();

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
            // Print points based on 4-way symmetry
            int[] c = xoayQuaDiem(a, b, x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);

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
            // printing points based on 4-way symmetry

            int[] c = xoayQuaDiem(a, b, x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, -y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
            c = xoayQuaDiem(a, b, -x + a, y + b, angle);
            fillColor(c[0], c[1], panel,Color.RED);
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
        // DRAW LINE
        int temp = ry / rx;
        int dolech = ry / (temp + 4);
        int[] c1 = xoayQuaDiem(a, b, (a - rx + dolech), (b - ry * 2 / 3), angle);
        int[] c2 = xoayQuaDiem(a, b, (a + rx - dolech + 1), (b - ry * 2 / 3), angle);
        //midPoint((a - rx + dolech), (b - ry * 2 / 3), (a + rx - dolech + 1), (b - ry * 2 / 3), panel);
        midPoint(c1[0], c1[1], c2[0], c2[1], panel,Color.RED);
        // DRAW DUOI
        c1 = xoayQuaDiem(a, b, (a - rx), (b + ry), angle);

        c2 = xoayQuaDiem(a, b, (a + rx), (b + ry), angle);
        midPoint(c1[0], c1[1], c2[0], c2[1], panel,Color.RED);

        c2 = xoayQuaDiem(a, b, (a - rx + dolech), (b + ry - dolech), angle);
        midPoint(c1[0], c1[1], c2[0], c2[1], panel,Color.RED);

        c1 = xoayQuaDiem(a, b, (a + rx), (b + ry), angle);
        c2 = xoayQuaDiem(a, b, (a + rx - dolech), (b + ry - dolech), angle);
        midPoint(c1[0], c1[1], c2[0], c2[1], panel,Color.RED);

        // draw hinh tron
        int c, d;
        c = 0;
        d = rx * 1 / 3;

        putPixel(c, d, a, b, panel,Color.RED);
        int p = 1 - rx * 2 / 3;
        while (c < d) {
            if (p < 0) {
                p += 2 * c + 2;
            } else {
                p += 2 * (c - d) + 5;
                d--;
            }
            c++;

            putPixel(c, d, a, b, panel,Color.RED);
        }
    }

    public static void struck(RocketStruck struck, MyCanvas panel) {
        int a = struck.getX();
        int b = struck.getY();
        int rx = struck.getW();
        int ry = struck.getH();
        midPoint((a - rx), (b - ry * 1 / 4), (a + rx-(rx-5)), (b - ry * 1 / 4), panel,Color.BLUE);
        midPoint((a - rx), (b + ry), (a + rx), (b + ry), panel,Color.BLUE);
        midPoint((a + rx), (b + ry), (a + rx), (b-1  - ry),panel,Color.BLUE);
        midPoint((a + rx-(rx-5)), (b + ry), (a + rx-(rx-5)), (b   - ry), panel,Color.BLUE);
        midPoint((a - rx), (b + ry), (a - rx), (b - ry * 1 / 4), panel,Color.BLUE);
        midPoint((a +(rx+5) - rx), (b - ry ), (a + rx), (b - ry ), panel,Color.BLUE);

        //ve banh truoc
        int c, d;
        c = 0;
        d = rx * 1 / 4;

        putPixel(c, d, a +12, b + ry +(ry-5), panel,Color.BLACK);
        int p = 1 - rx * 2 / 3;
        while (c < d) {
            if (p < 0) {
                p += 2 * c + 2;
            } else {
                p += 2 * (c - d) + 5;
                d--;
            }
            c++;

            putPixel(c, d, a +12, b + ry +(ry-5), panel,Color.BLACK);
        }
        //ve banh sau
        c = 0;
        d = rx * 1 / 4;
        putPixel(c, d, a -12, b + ry +(ry-5), panel,Color.BLACK);
        p = 1 - rx * 2 / 3;
        while (c < d) {
            if (p < 0) {
                p += 2 * c + 2;
            } else {
                p += 2 * (c - d) + 5;
                d--;
            }
            c++;

            putPixel(c, d, a -12, b + ry +(ry-5), panel,Color.BLACK);
        }
    }

    public static void sun(int a, int b, int r, MyCanvas panel) {
        for (int i = 0; i < r; i++) {
            int c, d;
            c = 0;
            d = i;

            putPixel(c, d, a, b, panel,Color.YELLOW);
            int p = 1 - i;
            while (c < d) {
                if (p < 0) {
                    p += 2 * c + 2;
                } else {
                    p += 2 * (c - d) + 5;
                    d--;
                }
                c++;

                putPixel(c, d, a, b, panel,Color.YELLOW);
            }
        }

    }
     public static void Explosive( MyCanvas panel,Explosive explosive) {
        int a = explosive.getX();
        int b= explosive.getY();
        int r = explosive.getR();
        for (int i = 0; i < r; i++) {
            int c, d;
            c = 0;
            d = i;

            putPixel(c, d, a, b, panel,Color.RED);
            int p = 1 - i;
            while (c < d) {
                if (p < 0) {
                    p += 2 * c + 2;
                } else {
                    p += 2 * (c - d) + 5;
                    d--;
                }
                c++;

                putPixel(c, d, a, b, panel,Color.RED);
            }
        }

    }

    public static void cloud(MyCanvas panel,Cloud cloud) {
        int rx = cloud.getW() - cloud.getH();
        int ry = 0;
        int a = cloud.getX();
        int b= cloud.getY();
        while (rx < cloud.getW()) {

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
                // Print points based on 4-way symmetry
                fillColor(x + a, -y + b, panel,Color.WHITE);
                fillColor(-x + a, -y + b, panel,Color.WHITE);
                fillColor(x + a, y + b, panel,Color.WHITE);
                fillColor(-x + a, y + b, panel,Color.WHITE);
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
                // printing points based on 4-way symmetry

                fillColor(x + a, -y + b, panel,Color.WHITE);
                fillColor(-x + a, -y + b, panel,Color.WHITE);
                fillColor(x + a, y + b, panel,Color.WHITE);
                fillColor(-x + a, y + b, panel,Color.WHITE);

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
            rx++;
            ry++;
        }

    }

    static void Explosive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
