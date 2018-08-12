/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculador;

/**
 *
 * @author Matias.Erenchun
 */
public class Validator 
{
    public boolean containTrigonometricas(String expresion)
    {
        if(expresion.contains("Sen"))
        {
            return true;
        }
        if(expresion.contains("Cos"))
        {
            return true;
        }
         if(expresion.contains("Tan"))
        {
            return true;
        }
        return false;
    }
}
