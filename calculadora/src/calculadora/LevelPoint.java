/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Matias.Erenchun
 */
public class LevelPoint 
{
    public double startX;
    public double endX;
    public double startY;
    public boolean statusLevel;
    
    public LevelPoint( double coordenadaX, double CoordenadaY)
    {
        this.startX=coordenadaX;
        this.endX=coordenadaX;
        this.startY = CoordenadaY;
        this.statusLevel=true;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public boolean getStatusLevel() {
        return statusLevel;
    }

    public void setStatusLevel(boolean statusLevel) {
        this.statusLevel = statusLevel;
    }
    
    
   
    
}
