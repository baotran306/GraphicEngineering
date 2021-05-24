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
public class Helicopter {
    private int x;
    private int y;
    private int w;
    private int h;
    private boolean direction;
    
    public Helicopter() {
    }

    public Helicopter(int x, int y, int w, int h, boolean direction) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.direction = direction;
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

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void changeDirection(){
        this.direction = !this.direction;
    }
    
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
}
