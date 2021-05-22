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
public class MyLibrary {
    public static boolean selectMode(int point, LineMode mode){
        if (mode == LineMode.DASH){
            return point % 5 == 0 && point != 0;
        }
        return true;
    }
    
    public static int convert2DX(int x){
        return x * 5 + 400;
    }
    
    public static int convert2DY(int y){
        return y * -5 + 400;
    }
}
