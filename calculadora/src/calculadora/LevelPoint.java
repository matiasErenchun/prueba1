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
    public Point endPoint;
    public boolean statusLevel;
    public LevelPoint(float nivel, double coordenadaX, double CoordenadaY)
    {
        super(nivel, coordenadaX, CoordenadaY);
        this.statusLevel=true;
        this.startPoint = new Point( nivel,  coordenadaX, CoordenadaY);
        this.endPoint = new Point( nivel,  coordenadaX, CoordenadaY);
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

    public Point getEndPoint() 
    {
        return this.endPoint;
    }

    public void setEndPoint(Point endPoint) 
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
    public boolean levelIsInt()
    {
        if(this.nivel%1!=0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
