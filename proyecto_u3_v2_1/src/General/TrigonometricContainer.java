/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

/**
 *
 * @author Matias.Erenchun
 */
public class TrigonometricContainer 
{
    private String expression;
    private boolean isGrade;
    private Validator validator;

    public TrigonometricContainer(String expression) {
        this.expression = expression;
        this.validator = new Validator();
        this.isGrade = this.isIsGrade();
    }

    public String getExpresion() 
    {
        return expression;
    }

    public void setExpresion(String expresion) 
    {
        this.expression = expresion;
    }

    public boolean isIsGrade() 
    {
        if(validator.containTrigonometricas(this.expression))
        {
            return false;
        }
        return true;
    }

    
    
    
}
