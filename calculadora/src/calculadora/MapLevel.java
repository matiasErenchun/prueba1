/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.HashMap;

/**
 *
 * @author Matias.Erenchun
 */
public class MapLevel 
{
    public HashMap mapLevel;
    public MapLevel()
    {
        this.mapLevel = new HashMap();
    }
    public boolean levelExist(float level)
    {
        return this.mapLevel.containsKey(level);
    }
    
    public void AddLevel(float key,LevelPoint levelPoint)
    {
        this.mapLevel.put(key, levelPoint);
        
    }
    
    public LevelPoint getLevelPoint(float level)
    {
        return (LevelPoint) this.mapLevel.get(level);
    }
    
    //retorna false si alguno de los dos niveles ingresados no esta cerrado
    public boolean levelsClose(float level1,float level2)
    {
        if(false==this.getLevelPoint(level2).isStatusLevel()&&false==this.getLevelPoint(level1).isStatusLevel())
        {
            return true;
       
        }
         return false;
    }
    
    public void moveEndPointX(float level)
    {
        double temporalX=this.getLevelPoint(level).getCoordenadaX();
        temporalX+=100;
        this.getLevelPoint(level).setEndPoint(temporalX);
    }
}
