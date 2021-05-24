/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project.Objects2D;

/**
 *
 * @author Tran Quoc Bao
 */
public class Rocket {
    private int x;
    private int y;
    private int w;
    private int h;
    private double angle;

    public Rocket() {
    }

    public Rocket(int x, int y, int w, int h, double angle) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.angle = angle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    
    public void changeAngle(double da){
        this.angle += da;
    }
    
    public void changeSize(int dw, int dh){
        this.w += dw;
        this.h += dh;
    }
}
