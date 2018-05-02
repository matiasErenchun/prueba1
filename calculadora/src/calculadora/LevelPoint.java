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
public class LevelPoint extends Point
{
    public Point startPoint;
    public double endPoint;
    public boolean statusLevel;
    public LevelPoint(float nivel, double coordenadaX, double CoordenadaY)
    {
        super(nivel, coordenadaX, CoordenadaY);
        this.statusLevel=true;
        this.startPoint = new Point( nivel,  coordenadaX, CoordenadaY);
        this.endPoint =coordenadaX;
    }
    
    public boolean compareStartAndEnd()
    {
        return this.startPoint.equals(this.endPoint);
    }

    public Point getStartPoint() 
    {
        return this.startPoint;
    }

    public void setStartPoint(Point startPoint) 
    {
        this.startPoint = startPoint;
    }

    public double getEndPoint() 
    {
        return this.endPoint;
    }

    public void setEndPoint(double endPoint) 
    {
        this.endPoint = endPoint;
    }
    
    public boolean isStatusLevel() 
    {
        return this.statusLevel;
    }

    public void setStatusLevel(boolean statusLevel) 
    {
        this.statusLevel = statusLevel;
    }
    public boolean levelIsInt(float level)
    {
        if((level%1.0)!=0)
        {
            System.out.println("tu mama");
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
