/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project.Main;

import ktdh_project.Class3D.Point3D;
import ktdh_project.Class2D.Point2D;

/**
 *
 * @author Tran Quoc Bao
 */
public class Test {
    public static void main(String args[]){
        Point2D p1 = new Point2D(4, 5);
        System.out.println(p1.getX());
        Point3D p2 = new Point3D(5, 7, 8);
        Point3D p3 = new Point3D(p2);
        System.out.println(p3.getZ());
        System.out.println(p3.getX());
        
    }
}
