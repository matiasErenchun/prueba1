/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculador;

import java.math.BigInteger;
import java.text.DecimalFormat;
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
    
   public String calcular(String expresion) throws ScriptException
   {
       String resultado;
       if(this.contieneSimbolosAvanzados(expresion))
       {
           resultado=this.calcularAvanzado(expresion);
       }
       else
       {
           resultado=this.CalcularBasico(expresion);
       }
       resultado=this.cutFloat(resultado, 3);
       return resultado;
   }
   
   public boolean contieneSimbolosAvanzados(String expresion)// retorna falso si la expresion no contiene simbolos avanzados
   {
       
       if(expresion.matches("^[0-9\\-+/*\\(\\).]+$"))
       {
           return false;
       }
       return true;
   }
   
    
   
    public String CalcularBasico(String expresion) throws ScriptException
    {
        String resultado = "¡¿?!";
        Object operation = engine.eval(expresion);
        resultado = operation.toString();
        return resultado;
    }
    
    public String calculateBigFactorial(String factorial)// calcular factoriales mayores o iguales a 120!
    {
        BigInteger fac = new BigInteger(factorial);
        BigInteger i = new BigInteger("1");
        BigInteger answer = new BigInteger("1");
        BigInteger add1 = new BigInteger("1");
        
                /*
        Double i= new Double(1);
        Double resultado = new Double(1);
        */
        while(i.compareTo(fac)!=1)
        {
            
            answer=answer.multiply(i);
            
            i=i.add(add1);
        }
        
        System.out.println("resultado de "+factorial+" factorial ="+answer);
       return answer.toString();
        
    }
    
    public String calculateNormalFactorial(String factorial)//calcular factoriales menores que 120! 
    {
        Double answer=new Double(1);
        Integer index=1;
        while(index<=Double.parseDouble(factorial))
        {
            answer=answer*index;
            index++;
        }
        System.out.println("resultado de "+factorial+" factorial ="+answer);
        return answer.toString();
    }
    
    public String calculateFactorial(String factorial)
    {
        if(Integer.parseInt(factorial)<120)
        {
           // return this.calculateNormalFactorial(factorial);
            return this.calculateBigFactorial(factorial);
        }
        else
        {
            return this.calculateBigFactorial(factorial);
        }
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
            
            
        }
        
        
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
            
            if(contenedorAuxiliar.matches("^[0-9]+|[0-9]*(\\.[0-9]*)|\\.[0-9]+$"))
            {
                salida=contenedorAuxiliar;
            }
            else
            {
                continuarBuscando=false;
            }
            contador+=incremento;
        }
        if(salida.matches("^[0-9]+|[0-9]+(\\.[0-9]+)$"))// validamos que la salida sea o un entero o un numero seguido de un punto y a lo menos un numero despues del punto
        {
            return salida;
        }
        else
        {
            salida=".>1";// cuando da este error es porque el numero o expresion que se esta buscando cuenta  con mas de un punto 
                         //ejemplo 1.1.1.  este tipo de expresiones arrojaria esta respuesta 
        }
        return salida;
    }
   
    public String reconocerTrigonometrica( String expresion, int indice)
    {
        if(indice+2>=expresion.length())
        {
            return "error de escritura";
        } 
        
        String respuesta;
        String Trigonometrica= expresion.substring(indice, indice+3);
        switch(Trigonometrica)
        {
                case "Sen":
                    respuesta = "Sen";
                    break;
                
                case "Cos":
                    respuesta="Cos";
                    break;
                    
                case "Tan":
                    respuesta="Tan";
                    break;
           
                default:
                    respuesta="funcion erronea";
        }
        
        return respuesta;
    }
    
    // a esta funcion se le pasa  la expresion dentro del parentesis, ejmplo :Sen(9+3), se pasaria la expresion (9+3) y la trigonometica Sen
    // para asi calcular el valor correspondiente a al expresion y el seno de ese valor.
    public String calcularTrigonometricas(String trigonometrica, String expresion) throws ScriptException
    {
        String respuesta;
        Double contenedor;
        ContenedorTrigonometrica contenedorExpresion = new ContenedorTrigonometrica(expresion);
        String contenedorAuxiliar;
        Double aCalcular;
        // se revisa si la expresion  no contiene mas expresiones trigonometricas dentro en caso de tenerlas quiere decir que  se debe segir  resolviendo antes de resolver esta
        // por otra parte si no contiene mas expresiones trigonometricas  quiere decir que la expresion esta en grados y para el correcto funcionamiento de la 
        // libreria matematica esto se debe  pasar de grados a radianes.
        if(contenedorExpresion.isIsGrade())
        {
            
            contenedorAuxiliar=this.calcular(contenedorExpresion.getExpresion());//se pasa la exprecion a calcular 
            aCalcular =Double.parseDouble(contenedorAuxiliar);//como  la libreria matematica trabaja con double se pasa  el valor calculado a double
            aCalcular=(aCalcular*Math.PI)/180;// se transforma de grados a radianes
            switch(trigonometrica)
            {
                case "Sen":
                    contenedor = Math.sin(aCalcular);
                    respuesta = contenedor.toString();
                    break;
                
                case "Cos":
                    contenedor = Math.cos(aCalcular);
                    respuesta = contenedor.toString();
                    break;
                    
                case "Tan":
                    contenedor = Math.tan(aCalcular);
                    respuesta = contenedor.toString();
                    break;
           
                default:
                    respuesta="funcion erronea 2";
            }
            
        }
        else//esto se usa  ya que  la resoues que vamos a procesar es un escalar y no esta ni en grado ni radianes 
        {
            contenedorAuxiliar=this.calcular(expresion);
            aCalcular=Double.parseDouble(contenedorAuxiliar);
            switch(trigonometrica)
            {
                case "Sen":
                    contenedor = Math.sin(aCalcular);
                    respuesta = contenedor.toString();
                    break;
                
                case "Cos":
                    contenedor = Math.cos(aCalcular);
                    respuesta = contenedor.toString();
                    break;
                    
                case "Tan":
                    contenedor = Math.tan(aCalcular);
                    respuesta = contenedor.toString();
                    break;
           
                default:
                    respuesta="funcion erronea 2";
                    break;
            }
            
           
        }
        if(respuesta!="funcion erronea 2")
        {
            respuesta=this.cutFloat(respuesta, 3);

        }
         return respuesta;
    }
    public String searchResolverTrigonometric(String expression) throws ScriptException
    {
        String answer="";
        String trigonometricAnswer;
        Character character;
        String trigonometric;
        int index=0;
        while(index<expression.length())
        {
            character=expression.charAt(index);
            if(character=='T'|| character=='S'|| character=='C')
            {
                trigonometric=this.reconocerTrigonometrica(expression, index);
                trigonometricAnswer=this.buscarParDeParentesis(expression, index+3, 1);
                answer=answer+this.calcularTrigonometricas(trigonometric, trigonometricAnswer);
                index+=(trigonometricAnswer.length()+3);
                
            }
            else
            {
                answer=answer+character.toString();
                index++;
            }
        }
        System.out.println("answer = "+answer);
        return answer;
    }
    public String calcularAvanzado(String expression) throws ScriptException
    {
        String answer=" ";
        String contenedor="";
        String contenedor2;
       int contador =0;
       expression=this.searchResolverTrigonometric(expression);// se recorre la expresion y se resulvan todas las expresiones trigonometricas 
       while(contador<expression.length())
       {
           char caracter =expression.charAt(contador);
           switch (caracter)
           {
               case '(':
                   contenedor2=this.buscarParDeParentesis(expression, contador, 1);
                   contador+=contenedor2.length();
                   contenedor2=this.cortarParentesis(contenedor2);
                   answer=answer+this.calcular(contenedor2);
                   System.out.println("contador2 "+contenedor2);
                   System.out.println("respuesta "+answer);
                   break;
               case '^':
                   contenedor2=this.lookTowards(expression, contador, 1);
                   contenedor=this.lookTowards(expression, contador, -1);
                   answer=answer.substring(0, answer.length()-contenedor.length());
                   answer=answer+this.resolvePowers(expression, contador);
                   contador+=contenedor2.length()+1;
                   break;
               case'!':
                   contenedor2=this.lookTowards(expression, contador, -1);
                   answer=this.calculateFactorial(contenedor2);
                   contador+=contenedor2.length()+1;
                   break;
               default:// si el caracter no es ninguno d elos simbolos avanzados  se agrega a la respuesta.
               Character charr=caracter;
               answer=answer+charr.toString();  
               contador++;
               break;
           }
           
       }
       
       answer = this.CalcularBasico(answer);// una vez resueltas todas las operaciones avanzadas se  calcula todas la soperaciones basicas
        
        return answer;
    }
    public String buscarResolverFactorial(String expresion)
    {
        String respuesta=" ";
        return respuesta;
    }
    
//funcion que corta los parentesis d elso extremos en caso de ser nesesario     
    public String cortarParentesis(String expresion)
    {
        
        if(expresion.charAt(0)=='(')
        {
            expresion=expresion.substring(1, expresion.length());
        }
            
        if(expresion.charAt(expresion.length()-1)==')')
        {
           expresion=expresion.substring(0, expresion.length()-1);   
        }
       
        return expresion;
    }
    
    // función que da formato a los numeros  que en caso de ser de tipo flotante los  deja solo con una cantidad determinado  de digitos  despues del punto.
    public String cutFloat(String expression,int quantityFloatDigits)
    {
        if(Double.parseDouble(expression)<0.001)// si el numero es menor a 0.001 se concidera que es 0
        {
            expression="0.000";
        }
        if(expression.contains("."))// esto es para ver si la respuesta tiene un punto 
        {   
            expression=this.cortarParentesis(expression);
            String answer="";
            int i=0;
            int j=0;
            boolean foundThePoint=false;
            while(i<expression.length()&& j<quantityFloatDigits)// esto se ejecutara mientras  no se alcanse la cantidad de 
            {                                                    //digitos luego del punto o  mientras no se llegue al alrgo de caracteres del numero
            
                Character character=expression.charAt(i);
                answer=answer+character.toString();
                if(foundThePoint==true)
                {
                    j++;
                }
                if(character=='.')// cuando encuentra el punto  se empesara a contar cuantos caracteres tenemso despues del punto.
                {
                    foundThePoint=true;
                }
                i++;
            }
            return answer;
        }
        
        return expression;
    }
    
    // busca y calcula la potencia 
    public String resolvePowers(String expression,int index) throws ScriptException
    {
        String answerRight=this.lookTowards(expression, index, -1);//base//buscamos la base hacia la izquierda
        String answerLeft=this.lookTowards(expression, index, 1);//exponente//buscamos el exponenete  hacia la derecha 
        Double base =Double.parseDouble(this.cutFloat(answerRight, 3));// se da formato al numero en caso de que se  de punto flotante con 3 digitos luego del 0
        Double exponent =Double.parseDouble(this.cutFloat(answerLeft, 3));
        Double answer=Math.pow(base, exponent);
        
        String answerFinal=this.cutFloat(answer.toString(), 3);// se le da formato al numeor 
        return answerFinal;
    }
    
    //si el incremento es 1 buscara hacia la derecha  y si es -1 buscara hacia la  izquierda.
    public String lookTowards(String expression,int index, int increase) throws ScriptException
    {
        char character =expression.charAt(index+increase);
        String answer;
        if(increase>0)
        {
            if(character =='(')// si el lemento que encuentra a la derecha del indice es un (  buscara y resolvera lo que este dentro de ese parentesis
            {
                answer=this.buscarParDeParentesis(expression, index+increase, increase);
                answer=this.calcular(answer);
            }
            else
            {
                answer=this.buscarNumero(expression, index+increase, increase);// si es un numero buscara el numero completo
            }
        }
        else
        {
             if(character ==')')// si el lemento que encuentra a la derecha del indice es un )  buscara y resolvera lo que este dentro de ese parentesis
            {
                answer=this.buscarParDeParentesis(expression, index+increase, increase);
                answer=this.calcular(answer);
            }
            else
            {
                answer=this.buscarNumero(expression, index+increase, increase);// si es un numero buscara el numero completo
            }
        }
        return answer;
    }
    
}
