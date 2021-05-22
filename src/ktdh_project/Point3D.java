/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project;

/**
 *
 * @author Tran Quoc Bao
 */
public class Point3D extends Point2D{
    private int z;

    public Point3D(){
        
    }
    public Point3D(int z) {
        this.z = z;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    
    public Point3D(Point3D other){
        super(other.getX(), other.getY());
        this.z = other.z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    @Override
    public int getX(){
        return super.getX();
    }

    @Override
    public void setY(int y) {
        super.setY(y); 
    }

    @Override
    public int getY() {
        return super.getY(); 
    }

    @Override
    public void setX(int x) {
        super.setX(x); 
    }
    
}
