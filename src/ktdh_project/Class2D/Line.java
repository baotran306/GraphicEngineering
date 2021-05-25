/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_project.Class2D;

/**
 *
 * @author Tran Quoc Bao
 */
public class Line {
    private Point2D startPoint;
    private Point2D endPoint;

    public Line() {
        
    }

    public Line(Point2D startPoint, Point2D endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }

    public Point2D getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
    }
    
    public void setLine(){
        
    }
    
}
