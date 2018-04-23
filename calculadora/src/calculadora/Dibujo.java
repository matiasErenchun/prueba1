/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import javafx.scene.shape.PathElement;

/**
 *
 * @author Matias.Erenchun
 */
public abstract class Dibujo 
{
    public float factorResize;
    public Double topPoint;
    public Double dawnPoint;
    public Double startPoint;
    public Double endPoint;
    private ArrayList<ControlPoint> listControlPoint;
    private ArrayList<PathElement> listCurves;
    public String element;
    public float level;

    public Dibujo(float f, float level) 
    {
        this.factorResize= (float) f;
        this.level = level;
        this.listControlPoint = new ArrayList<>();
        this.listCurves = new ArrayList<>();
    }

    public float getLevel() 
    {
        return this.level;
    }

    public void setLevel(float level) {
        this.level = level;
    }
    
    

    public float getFactorResize() 
    {
        return this.factorResize;
    }

    public void setFactorResize(float factorResize) 
    {
        this.factorResize = factorResize;
    }

    
    
    public Double getTopPoint() 
    {
        return this.topPoint;
    }

    public void setTopPoint(Double topPoint) 
    {
        this.topPoint = topPoint;
    }

    public Double getDawnPoint() 
    {
        return this.dawnPoint;
    }

    public void setDawnPoint(Double dawnPoint) 
    {
        this.dawnPoint = dawnPoint;
    }

    public Double getStartPoint() 
    {
        return this.startPoint;
    }

    public void setStartPoint(Double startPoint) 
    {
        this.startPoint = startPoint;
    }

    public Double getEndPoint() 
    {
        return this.endPoint;
    }

    public void setEndPoint(Double endPoint) 
    {
        this.endPoint = endPoint;
    }

    public String getElement() 
    {
        return this.element;
    }

    public void setElement(String element) 
    {
        this.element = element;
    }
    
    public int longListControlPoint()
    {
        return this.listControlPoint.size();
    }
    
    public int longListCurves()
    {
        return this.listCurves.size();
    }
   
    public ControlPoint getControlPointList(int index)
    {
       return this.listControlPoint.get(index);
    }
   
    public PathElement getPathElementList(int index )
    {
        return this.listCurves.get(index);
    }
    
    public ControlPoint removeControlPointList(int index)
    {
        return this.listControlPoint.remove(index);
    }
    
    public PathElement removePathElementList(int index)
    {
        return this.listCurves.remove(index);
    }
    
    public boolean isEmptyControlPointList()
    {
        return this.listControlPoint.isEmpty();
    }
    
    public boolean isEmtyPathElementList()
    {
        return this.listCurves.isEmpty();
    }
    
    public boolean addControlPointList(ControlPoint point)
    {
        return this.listControlPoint.add(point);
    }
    
    public boolean addPathElementList(PathElement element)
    {
        return this.listCurves.add(element);
    }
    
}
