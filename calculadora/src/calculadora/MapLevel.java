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
    public boolean levelExist(int level)
    {
        return this.mapLevel.containsKey(level);
    }
    
    public void AddLevel(int key,LevelPoint levelPoint)
    {
        this.mapLevel.put(key, levelPoint);
        
    }
    
    public LevelPoint getLevelPoint(int level)
    {
        return (LevelPoint) this.mapLevel.get(level);
    }
    
    //metodo para cerra un nivel 
    // si es un nivel de division  confirma que primero esten cerrados el nivel superior a este y el inferior, si se pudo cerrar el nivel retorna true de lo contrario es false.
    public boolean ClosedLevel(int level)
    {
        boolean isClosed = false;
       if(this.levelIsLevelDivide(level)) 
       {
           if(this.levelIsClosed(level-1) && this.levelIsClosed(level+1))
           {
               this.getLevelPoint(level).setStatusLevel(false);
               isClosed = true;
           }
           else
           {
               System.out.println("no se puede cerrar ya que su nivel superior o inferior no estan cerrados");
           }
           //inserte mensaje o pantalla de mensaje donde diga que no se puede cerra ya que no estan completos los otros dos niveles
       }
       else
       {
           this.getLevelPoint(level).setStatusLevel(false);
           isClosed = true;
       }
       
       return isClosed;
       
    }
    
    public boolean levelIsClosed(int level1)// valida si un nivel esta cerrado.
    {
        return this.getLevelPoint(level1).getStatusLevel();
    }
    
    public boolean levelIsLevelDivide(int level)// valida si un nivel es par o no
    {
        if(level%2.0==0)
        {
            return true;
        }
        return false;
    }
    
    public void setEndXOfUpAndDawn(int level)//ingresa un nivel y setea  su level up y dawn  con su endX !!solo usar cuando se cierra un nivel¡¡¡
    {
        if(this.levelIsLevelDivide(level))
            //ademas de validar que los niveles existan tambien se valida que el valor del endX
            //del nivel actual es mayor a los de los niveles a setear.
        {
            if(this.levelExist(level+2))
            {
                if(this.getLevelPoint(level+2).getEndX()<this.getLevelPoint(level).getEndX())
                {
                    this.getLevelPoint(level+2).setEndX(this.getLevelPoint(level).getEndX());
                }
            }
            if(this.levelExist(level-2))
            {
                if(this.getLevelPoint(level-2).getEndX()<this.getLevelPoint(level).getEndX())
                {
                    this.getLevelPoint(level-2).setEndX(this.getLevelPoint(level).getEndX());
                }
                
            }
        }
        else
        {
            if(this.levelExist(level+1))
            {
                 if(this.getLevelPoint(level+1).getEndX()<this.getLevelPoint(level).getEndX())
                {
                    this.getLevelPoint(level+1).setEndX(this.getLevelPoint(level).getEndX());
                }
                
            }
            if(this.levelExist(level-1))
            {
                 if(this.getLevelPoint(level-1).getEndX()<this.getLevelPoint(level).getEndX())
                {
                    this.getLevelPoint(level-1).setEndX(this.getLevelPoint(level).getEndX());
                }
                
            }
            
        }
    }
    
}
