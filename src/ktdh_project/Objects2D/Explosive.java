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
public class Explosive {
    private int x;
    private int y;
    private int r;

    public Explosive() {
    }

    public Explosive(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
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

    public int getR() {
        return r;
    }

    public void setW(int r) {
        this.r = r;
    }       
     public void changeSize(int dw){
        this.r += dw;
    }
}
