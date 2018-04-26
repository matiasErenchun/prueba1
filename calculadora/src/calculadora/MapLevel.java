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
}
