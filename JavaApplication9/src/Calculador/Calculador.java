/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculador;

import javax.script.ScriptException;

/**
 *
 * @author Matias.Erenchun
 */
public class Calculador {

    /**
     * @param args the command line arguments
     */
    private static NucleoDeCalculo miCalculador;
    public static void main(String[] args) throws ScriptException 
    {
        miCalculador=new NucleoDeCalculo();
        miCalculador.CalcularBasico("(5/12)+3*2");
        String aux=miCalculador.buscarParDeParentesis("(4+5*(7*(150/56)))", 0, 1);
        aux=miCalculador.CalcularBasico(aux);
        
        System.out.println("aux ="+aux);
        miCalculador.calcularFactorial("70");
        miCalculador.buscarNumero("9/99+678/", 5, 1);
        miCalculador.buscarNumero("9/9+678", 2, -1);
        // TODO code application logic here
    }
    
}
