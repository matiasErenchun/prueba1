
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
        
        boolean isClosed=false;
       
        if(this.levelIsEven(level) && divide==true && level!=0)// niveles pares en general
        {
            if(this.getLevel(level).xStartIsDifferentXEnd())
            {
                if(this.iCanDrawInEven(level))
                {
                    this.getLevel(level).setLevelStatus(false);
                    isClosed=true;
                }
            }
        }
        else
        {
            if(level<0)
            { 
                isClosed=this.closeUpDivideUp(level);
            }
            else
            {
                isClosed=this.closeDawDivideDawn(level);
            }
        }
        return isClosed;
    }
    
    
    // si el nivele es par es un nivel de divicion 
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
    
    public boolean iCanDrawInEven(int level)
    {
        boolean iCanDraw=false;
        if(this.LevelIsClosed(level+1)&& this.LevelIsClosed(level-1) && !this.LevelIsClosed(level))
        {
            iCanDraw=true;
        }
        return iCanDraw;
    }
    
    public boolean validateLevelToWrite(int level,boolean divide)
    {
        boolean isValid = false;
        if(this.levelIsEven(level)&& divide==true)
        {
            if(this.iCanDrawInEven(level))
            {
                isValid=true;
            }
        }
        else
        {
            if(true!=this.LevelIsClosed(level))
            {
                isValid=true;
            }
        }
        return isValid;
    }

    public String getStringDivide(int maximun,int minimun)
    {
        String finalString="("+this.TopOfString(maximun)+"/"+this.bottomOfString(minimun)+")";
        
        return finalString;
        
    }
    
    private String TopOfString(int maximun)
    {
        String topPart;
        if(maximun+1==0)
        {
            topPart=this.getLevel(maximun).getStringLevel();
        }
        else
        {
            String dividendo=this.getLevel(maximun).getStringLevel();
            while((maximun+1)<0)
            {
                String elementosDelNivel=this.getLevel(maximun+1).getStringLevel();
                String divisor=this.getLevel(maximun+2).getStringLevel();
                dividendo="("+"("+dividendo+"/"+divisor+")"+elementosDelNivel+")";
                maximun+=2;
            }
            topPart=dividendo;
        }
        System.out.println(topPart+"topPart");
        return topPart;
        
    }
    
    private String bottomOfString(int minimun)
    {
        String bottomPart;
        if(minimun-1==0)
        {
            bottomPart=this.getLevel(minimun).getStringLevel();
        }
        else
        {
            int level=2;
            String dividendo=this.getLevel(minimun).getStringLevel();
            while((minimun-1)>0)
            {
                String elementosDelNivel=this.getLevel(minimun-1).getStringLevel();
                String divisor=this.getLevel(minimun-2).getStringLevel();
                dividendo="("+"("+divisor+"/"+dividendo+")"+elementosDelNivel+")";
                minimun-=2;
            }
            bottomPart=dividendo;
        }
        System.out.println(bottomPart+"bottomPart");
        return bottomPart;
    }
}
