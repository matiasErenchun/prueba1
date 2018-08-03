/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculador;

import java.math.BigInteger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Matias.Erenchun
 */
public class NucleoDeCalculo 
{
    private ScriptEngineManager manager;
    private ScriptEngine engine;

    public NucleoDeCalculo() throws ScriptException 
    {
        this.manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("js");
        
        
    }
    
    public String CalcularBasico(String expresion) throws ScriptException
    {
        String resultado = "¡¿?!";
        Object operation = engine.eval(expresion);
        resultado = operation.toString();
        System.out.println(" resultado ="+resultado);
        return resultado;
    }
    
    public String calcularFactorial(String factorial)
    {
        BigInteger fac = new BigInteger(factorial);
        BigInteger i = new BigInteger("1");
        BigInteger resultado = new BigInteger("1");
        BigInteger sumar1 = new BigInteger("1");
        
                /*
        Double i= new Double(1);
        Double resultado = new Double(1);
        */
        while(i.compareTo(fac)!=1)
        {
            
            resultado=resultado.multiply(i);
            
            i=i.add(sumar1);
        }
        
        System.out.println("resultado de "+factorial+" factorial ="+resultado);
        String resuelto= resultado.toString();
        return resuelto;
    }
    
    public String buscarParDeParentesis(String expresion,int IndiceInicioBusqueda,int incremento)
    {
       
        String salida;
        char parentesis1;
        char parentesis2;
        int marcador1=0;
        int marcador2=0;
        boolean segirBuscando = true;
        int contador1 = 0;
        int contador2 = 0;
        if(incremento>0)
        {
            parentesis1='(';
            parentesis2=')';
        }
        else
        {
            parentesis1=')';
            parentesis2='(';
        }
        boolean primeraCoincidencia =false;
        while(-1<IndiceInicioBusqueda && IndiceInicioBusqueda<expresion.length()&& segirBuscando==true )
        {
            if(expresion.charAt(IndiceInicioBusqueda)==parentesis1)
            {
                if(primeraCoincidencia==false)
                {
                    marcador1=IndiceInicioBusqueda;
                    primeraCoincidencia=true;
                }
                contador1+=1;
            }
            if(expresion.charAt(IndiceInicioBusqueda)==parentesis2)
            {
                contador2+=1;
            }
            if(contador1-contador2==0 && primeraCoincidencia==true)
            {
                
                marcador2=IndiceInicioBusqueda;
                segirBuscando=false;
            }
            
            IndiceInicioBusqueda+=incremento;
            System.out.println("IndiceInicioBusqueda"+IndiceInicioBusqueda);
            
        }
        System.out.println("contador1"+contador1);
        System.out.println("contador2"+contador2);
        System.out.println("marcador1"+marcador1);
        System.out.println("marcador2"+marcador2);
        
        if(contador1-contador2==0)
        {
            if(marcador1<marcador2)
            {
                salida=expresion.substring(marcador1, marcador2+1);
            
            }
            else
            {
                if(marcador1>marcador2)
                {
                    salida=expresion.substring(marcador2, marcador1+1);
                }
                else
                {

                    salida="!(&&!)";//este error dice que no se encontraron parentesis
                }
                
            }
        }
        else
        {
            salida="1<2";
        }
        return salida;
    }
    
    public String buscarNumero(String expresion,int indiceDeBusqueda,int incremento)
    {
        String salida ="error";
        String contenedorAuxiliar;
        boolean continuarBuscando =true;
        int contador = indiceDeBusqueda;
        while(continuarBuscando && -1<contador && contador<expresion.length())
        {
            if(incremento>0)
            {
                contenedorAuxiliar=expresion.substring(indiceDeBusqueda, contador+1);
            }
            else
            {
                contenedorAuxiliar=expresion.substring(contador, indiceDeBusqueda+1);
            }
            
            if(contenedorAuxiliar.matches("^[0-9]*|[0-9]+(\\.[0-9]*)$"))
            {
                salida=contenedorAuxiliar;
            }
            else
            {
                continuarBuscando=false;
            }
            contador+=incremento;
        }
        System.out.println("salida ="+salida);
        return salida;
    }
        
    
}
