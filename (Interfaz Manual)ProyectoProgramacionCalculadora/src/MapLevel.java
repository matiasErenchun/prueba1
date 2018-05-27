
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matias.Erenchun
 */
public class MapLevel 
{
    private HashMap mapLevel;
    
    public MapLevel()
   {
        this.mapLevel = new HashMap();
    }
    public boolean levelExist(int level)
    {
        return this.mapLevel.containsKey(level);
    }
    
    public void AddLevel(int key,Level level)
    {
        this.mapLevel.putIfAbsent(key, level);
        
    }
    
    public Level getLevel(int level)
    {
        return (Level) this.mapLevel.get(level);
    }
    
    // si el nivel esta habierto retorna false  y si esta cerrado retorna true 
    public boolean LevelIsClosed(int level)
    {
        System.out.println(level);
        if(this.getLevel(level).isLevelStatus()==true)
        {
            return false;
        }
        return true;
    }
    
    public void startMap(double x, double y)
    {
        this.mapLevel.clear();
        Level miLevel0=new Level(0,x,y);
        this.AddLevel(0, miLevel0);
    }
    
    public void createLevel(double x, int levelNumber)
    {
        
        double miY=60*levelNumber;
        Level miLevel = new Level(levelNumber,x,miY);
        this.AddLevel(levelNumber, miLevel);
        
        
    }
    
    public boolean closeLevel(int level,boolean divide)
    {
        System.out.println("hola inicio");
        boolean isClosed=false;
        System.out.println(this.levelIsEven(level)+"es division");
        
        if(this.levelIsEven(level) && divide==true && level!=0)// niveles pares en general
        {
            System.out.println("divicion generica");
            if(this.getLevel(level).xStartIsDifferentXEnd())
            {
                System.out.println("hola35");
                System.out.println(this.getLevel(level)+"level");
                System.out.println(this.getLevel(level+1)+"level+1");
                System.out.println(this.getLevel(level-1)+"level-1");
                if(this.LevelIsClosed(level+1)&& this.LevelIsClosed(level-1))
                {
                     System.out.println("if si estan cerrados ");
                    this.getLevel(level).setLevelStatus(false);
                    isClosed=true;
                }
            }
        }
        else
        {
             System.out.println("si no es division ");
            if(level<0)
            { 
                System.out.println("si es mayor a 0");
                isClosed=this.closeUpDivideUp(level);
            }
            else
            {
                isClosed=this.closeDawDivideDawn(level);
            }
        }
        return isClosed;
    }
    
    
    // si el nivele s par es un nivel de divicion 
    public boolean levelIsEven(int level)
    {
        boolean isEven=false;
        if(level%2==0)
        {
            isEven=true;
        }
        return isEven;
    }
    
    private boolean closeUpDivideUp(int level)
    {
        boolean isClosed=false;
        if(this.levelExist(level-1))
        {
            if(this.LevelIsClosed(level-2))
            {
                this.getLevel(level).setLevelStatus(false);
                this.setEndOfThisLevel(level, level+1);
                this.setEndOfThisLevel(level, level-1);
                isClosed=true;
            }
        }
        else
        {
            this.getLevel(level).setLevelStatus(false);
            this.setEndOfThisLevel(level, level+1);
            isClosed=true;
        }
        return isClosed;
    }
    
    private boolean closeDawDivideDawn(int level)
    {
        boolean isClosed=false;
        if(this.levelExist(level+1))
        {
            if(this.LevelIsClosed(level+2))
            {
                this.getLevel(level).setLevelStatus(false);
                this.setEndOfThisLevel(level, level+1);
                this.setEndOfThisLevel(level, level-1);
                isClosed=true;
            }
        }
        else
        {
            
            this.getLevel(level).setLevelStatus(false);
            this.setEndOfThisLevel(level, level-1);
            
            isClosed=true;
        }
        return isClosed;
    }
    public void setEndOfThisLevel(int levelEndX, int levelToSet)
    {
        double xEnd =this.getLevel(levelEndX).getEndX();
        double xToSet =this.getLevel(levelToSet).getEndX();
        if(xEnd>xToSet)
        {
            this.getLevel(levelToSet).setEndX(xEnd);
        }
    }


}
