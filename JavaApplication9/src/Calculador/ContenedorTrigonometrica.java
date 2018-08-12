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
public class ContenedorTrigonometrica 
{
    private String expresion;
    private boolean isGrade;
    private Validator validator;

    public ContenedorTrigonometrica(String expresion) {
        this.expresion = expresion;
        this.validator = new Validator();
        this.isGrade = this.isIsGrade();
    }

    public String getExpresion() 
    {
        return expresion;
    }

    public void setExpresion(String expresion) 
    {
        this.expresion = expresion;
    }

    public boolean isIsGrade() 
    {
        if(validator.containTrigonometricas(this.expresion))
        {
            return false;
        }
        return true;
    }

    
    
    
}
