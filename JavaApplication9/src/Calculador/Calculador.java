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
        System.out.println(" parentesis final (dsggdgsd(fh)bxb)");
        System.out.println("parentesis "+miCalculador.cortarParentesis("(dsggdgsd(fh)bxb)"));
        
        miCalculador.CalcularBasico("(5/12)+3*2");
        String aux=miCalculador.buscarParDeParentesis("(4+5*(7*(150/56)))", 0, 1);
        aux=miCalculador.CalcularBasico(aux);
        System.out.println(miCalculador.calcular("(80^3)+(6!)/Sen(2*7)"));
        System.out.println(miCalculador.searchResolverTrigonometric("Tan((80+3))+15/Sen(2*7)"));
        System.out.println(miCalculador.calcular("(0.0021)/2"));
        System.out.println(miCalculador.cutFloat("0.12",3));
        Double dou=Math.pow(7, -8);
        System.out.println(dou.toString());
        System.out.println(miCalculador.cutFloat(dou.toString(),3));
        
        
        
        System.out.println(miCalculador.resolvePowers("(3)^(2*2)", 3));
        
        System.out.println("aux ="+aux);
        String fac=miCalculador.calculateFactorial("13");
        System.out.println(miCalculador.cutFloat(miCalculador.calculateFactorial("13"),3));
        boolean contiene =miCalculador.contieneSimbolosAvanzados("9/99+6666.8+(4+5*(7*(150/56)))");
        System.out.println("contiene "+contiene);
        miCalculador.CalcularBasico("(5/12)+"+fac+"+3*2");
        
        
        System.out.println(miCalculador.buscarNumero("9/99+6666.8/", 5, 1));
        System.out.println(miCalculador.buscarNumero("9.9+6.8", 2, -1));
        // TODO code application logic here
    }
    
}
