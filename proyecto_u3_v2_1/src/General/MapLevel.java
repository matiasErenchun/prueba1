package General;


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
    // metodo que cierra un nivel si es que es valido  y retorna si se cerro o no, mediante un boolean.
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
                    this.setEndXOfDivide(level);
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
    // metodo que resive dos niveles y setea el endX de unoi con el del segundo, si es que es mayor 
    public void setEndOfThisLevel(int levelEndX, int levelToSet)
    {
        double xEnd =this.getLevel(levelEndX).getEndX();
        double xToSet =this.getLevel(levelToSet).getEndX();
        if(xEnd>xToSet)
        {
            this.getLevel(levelToSet).setEndX(xEnd);
        }
    }
    /*
    metodo que valida si puedo dibujar en un nivel par, resive el nivel.
    */
    public boolean iCanDrawInEven(int level)
    {
        boolean iCanDraw=false;
        if(this.LevelIsClosed(level+1)&& this.LevelIsClosed(level-1) && !this.LevelIsClosed(level))
        {
            iCanDraw=true;
        }
        return iCanDraw;
    }
    /*
    metodo que resive un nivel y el voleano de si existe una division y verifica si el nivel es valido para escribir en el.
    */
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
    /*
    metodo que resive el nivel maximo y a partir de este genera la expresion que representa la parte superior de la division.
    */
    
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
                dividendo="("+"(("+dividendo+")/("+divisor+"))"+elementosDelNivel+")";
                maximun+=2;
            }
            topPart=dividendo;
        }
        System.out.println(topPart+"topPart");
        return topPart;
        
    }
    /*
    metodo que resive el nivel minimo y genera un string con la exprecion de la parte inferior de la division
    */
    
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
                dividendo="("+"(("+divisor+")/("+dividendo+"))"+elementosDelNivel+")";
                minimun-=2;
            }
            bottomPart=dividendo;
        }
        System.out.println(bottomPart+"bottomPart");
        return bottomPart;
    }
    /*
    metodo que resive un nivel par y setea los niveles pares mas proximos al nivel 0.
    */
    private void setEndXOfDivide(int level)
    {
        double miEndX=this.getLevel(level).getEndX();
        if(level>0)
        {
            while(level-2>=0)
            {
                if(miEndX>this.getLevel(level-2).getEndX())
                {
                    this.getLevel(level-2).setEndX(miEndX);
                }
                level-=2;
            }
        }
        else
        {
            while(level+2<=0)
            {
                if(miEndX>this.getLevel(level+2).getEndX())
                {
                    this.getLevel(level+2).setEndX(miEndX);
                }
                
                level+=2;
            }
        }
    }
    
}
