package General;

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
    private String stringLevel;
    private String stringBeforeDivide;
    private boolean drawBefore;

    public Level(int levelNumber, double xLevel, double yLevel)
    {
        this.drawBefore=false;
        if(levelNumber%2==0)
        {
            this.drawBefore=true;
        }
        this.stringBeforeDivide ="";
        this.levelNumber = levelNumber;
        this.xLevel = xLevel;
        this.yLevel = yLevel;
        this.endX = xLevel;
        this.levelStatus = true;
        this.stringLevel="";
    }

    public String getStringBeforeDivide() 
    {
        return stringBeforeDivide;
    }

    public void setStringBeforeDivide(String stringBeforeDivide) 
    {
        this.stringBeforeDivide = stringBeforeDivide;
    }
    
    public void AddStringToStringBefore(String string)
    {
        String stringAuxiliar = this.stringBeforeDivide+string;
        this.setStringBeforeDivide(stringAuxiliar);
    }
    

    public boolean getDrawBefore() 
    {
        return drawBefore;
    }

    public void setDrawBefore(boolean drawBefore) {
        this.drawBefore = drawBefore;
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
    
    /*
    metodo que verifica si se a escrito algo en el nivel 
    */
    public boolean xStartIsDifferentXEnd()
    {
        boolean isDifferent=false;
        if(this.endX!=this.xLevel)
        {
            isDifferent=true;
        }
        
        return isDifferent;
        
    }
    /*
    metodo que retorna el string con los elemnetos del nivel
    */
    
    public String getStringLevel()
    {
        String miString=this.stringLevel+"";
        System.out.println(miString+"salida");
        return miString;
    }
    
    public void setStringLevel(String string)
    {
        this.stringLevel="";
    }
    /*
    metodo que concatena un string que representa un elemento agregado al nivel con los otros elementos ya existentes en este nivel.
    */
    
    public void addStringToStringLevel(String caracter)
    {
        String contenedor = this.stringLevel+caracter;
        this.stringLevel=contenedor;
        System.out.println(this.stringLevel+"resultado");
    }
    
    
}
