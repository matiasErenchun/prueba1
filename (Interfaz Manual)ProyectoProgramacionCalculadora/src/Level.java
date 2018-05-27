/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matias.Erenchun
 */
public class Level 
{
    private int levelNumber;
    private double xLevel;
    private double yLevel;
    private double endX;
    private boolean levelStatus;

    public Level(int levelNumber, double xLevel, double yLevel)
    {
        this.levelNumber = levelNumber;
        this.xLevel = xLevel;
        this.yLevel = yLevel;
        this.endX = xLevel;
        this.levelStatus = true;
    }

    public int getLevelNumber() 
    {
        return this.levelNumber;
    }

    public void setLevelNumber(int levelNumber) 
    {
        this.levelNumber = levelNumber;
    }

    public double getxLevel() 
    {
        return this.xLevel;
    }

    public void setxLevel(double xLevel) 
    {
        this.xLevel = xLevel;
    }

    public double getyLevel() 
    {
        return this.yLevel;
    }

    public void setyLevel(double yLevel) 
    {
        this.yLevel = yLevel;
    }

    public double getEndX() {
        return this.endX;
    }

    public void setEndX(double endX) 
    {
        this.endX = endX;
    }

    public boolean isLevelStatus() 
    {
        return this.levelStatus;
    }

    public void setLevelStatus(boolean levelStatus) 
    {
        this.levelStatus = levelStatus;
    }
    public boolean xStartIsDifferentXEnd()
    {
        boolean isDifferent=false;
        if(this.endX!=this.xLevel)
        {
            isDifferent=true;
        }
        
        return isDifferent;
        
    }
    
    
    
}
