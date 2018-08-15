/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.math.BigInteger;
import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Matias.Erenchun
 */
public class CalculationCore 
{
    private ScriptEngineManager manager;
    private ScriptEngine engine;

    public CalculationCore() throws ScriptException 
    {
        this.manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("js");
        
        
    }
    public String deleteDegreesSymbol(String expression)
    {
        expression=expression.replaceAll("º", "");
        return expression;
    }
    
    public String deletePoint(String expression)
    {
        int index=0;
        while(index<expression.length()&&expression.charAt(index)!='.')
        {
            index++;
        }
        expression=expression.substring(0, index);
        return expression;
    }
   public String calculate(String expression) throws ScriptException
   {
       String answer;
       expression=this.deleteDegreesSymbol(expression);
       if(this.containsAdvancedSymbols(expression))
       {
           
           answer=this.calculateAdvanced(expression);
       }
       else
       {
           answer=this.calculateBasic(expression);
           
       }
      
       answer=this.cutFloat(answer, 3);
       
       return answer;
   }
   
   public boolean containsAdvancedSymbols(String expression)// retorna falso si la expresion no contiene simbolos avanzados
   {
       
       if(expression.matches("^[0-9\\-+/*\\(\\).]+$"))
       {
           return false;
       }
       return true;
   }
   
    
   
    public String calculateBasic(String expresion) throws ScriptException
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
        factorial=this.deletePoint(factorial);
        Integer iFactorial=Integer.parseInt(factorial);
        if(iFactorial<0)
        {
            return "F<0";
        }
        else
        {
            if(iFactorial<120)
            {
                // return this.calculateNormalFactorial(factorial);
                return this.calculateBigFactorial(iFactorial.toString());
            }
            else
            {
                return this.calculateBigFactorial(iFactorial.toString());
            }
        }
    }
    
    public String findParentheses(String expression,int searchStartIndex,int increase)
    {
       
        String answer;
        char Parentheses1;
        char Parentheses2;
        int mark1=0;
        int mark2=0;
        boolean keepLooking = true;
        int container1 = 0;
        int container2 = 0;
        if(increase>0)
        {
            Parentheses1='(';
            Parentheses2=')';
        }
        else
        {
            Parentheses1=')';
            Parentheses2='(';
        }
        boolean firstCoincidence =false;
        while(-1<searchStartIndex && searchStartIndex<expression.length()&& keepLooking==true )
        {
            if(expression.charAt(searchStartIndex)==Parentheses1)
            {
                if(firstCoincidence==false)
                {
                    mark1=searchStartIndex;
                    firstCoincidence=true;
                }
                container1+=1;
            }
            if(expression.charAt(searchStartIndex)==Parentheses2)
            {
                container2+=1;
            }
            if(container1-container2==0 && firstCoincidence==true)
            {
                
                mark2=searchStartIndex;
                keepLooking=false;
            }
            
            searchStartIndex+=increase;
            
            
        }
        
        
        if(container1-container2==0)
        {
            if(mark1<mark2)
            {
                answer=expression.substring(mark1, mark2+1);
            
            }
            else
            {
                if(mark1>mark2)
                {
                    answer=expression.substring(mark2, mark1+1);
                }
                else
                {

                    answer="!(&&!)";//este error dice que no se encontraron parentesis
                }
                
            }
        }
        else
        {
            answer="1<2";
        }
        return answer;
    }
    
    public String searchNumber(String expression,int searchIndex,int increase)
    {
        String answer ="error";
        String auxiliaryContainer;
        boolean ContinueSearching =true;
        int accountant = searchIndex;
        while(ContinueSearching && -1<accountant && accountant<expression.length())
        {
            if(increase>0)
            {
                auxiliaryContainer=expression.substring(searchIndex, accountant+1);
            }
            else
            {
                auxiliaryContainer=expression.substring(accountant, searchIndex+1);
            }
            if(auxiliaryContainer.matches("^[-]|[-]{0,1}[0-9]+|[-]{0,1}[0-9]+(\\.[0-9]*)|\\.[0-9]+$"))
            {
                answer=auxiliaryContainer;
            }
            else
            {
                ContinueSearching=false;
            }
            accountant+=increase;
        }
        if(answer.matches("^[-]{0,1}[0-9]+|[-]{0,1}[0-9]+(\\.[0-9]+)$"))// validamos que la salida sea o un entero o un numero seguido de un punto y a lo menos un numero despues del punto
        {
            return answer;
        }
        else
        {
            answer=".>1";// cuando da este error es porque el numero o expresion que se esta buscando cuenta  con mas de un punto 
                         //ejemplo 1.1.1.  este tipo de expresiones arrojaria esta respuesta 
        }
        return answer;
    }
   
    public String recognizeTrigOperations( String expression, int indix)
    {
        if(indix+2>=expression.length())
        {
            return "error de escritura";
        } 
        
        String answer;
        String Trigonometrica= expression.substring(indix, indix+3);
        switch(Trigonometrica)
        {
                case "sen":
                    answer = "sen";
                    break;
                
                case "cos":
                    answer="cos";
                    break;
                    
                case "tan":
                    answer="tan";
                    break;
           
                default:
                    answer="funcion erronea";
        }
        
        return answer;
    }
    
    // a esta funcion se le pasa  la expresion dentro del parentesis, ejmplo :Sen(9+3), se pasaria la expresion (9+3) y la trigonometica Sen
    // para asi calcular el valor correspondiente a al expresion y el seno de ese valor.
    public String calculateTrigOperations(String trigonometric, String expression) throws ScriptException
    {
        String answer;
        Double container;
        TrigonometricContainer containerExpression = new TrigonometricContainer(expression);
        String auxiliaryContainer;
        Double toCalculate;
        // se revisa si la expresion  no contiene mas expresiones trigonometricas dentro en caso de tenerlas quiere decir que  se debe segir  resolviendo antes de resolver esta
        // por otra parte si no contiene mas expresiones trigonometricas  quiere decir que la expresion esta en grados y para el correcto funcionamiento de la 
        // libreria matematica esto se debe  pasar de grados a radianes.
        if(containerExpression.isIsGrade())
        {
            
            auxiliaryContainer=this.calculate(containerExpression.getExpresion());//se pasa la exprecion a calcular 
            toCalculate =Double.parseDouble(auxiliaryContainer);//como  la libreria matematica trabaja con double se pasa  el valor calculado a double
            toCalculate=(toCalculate*Math.PI)/180;// se transforma de grados a radianes
            switch(trigonometric)
            {
                case "sen":
                    container = Math.sin(toCalculate);
                    answer = container.toString();
                    break;
                
                case "cos":
                    container = Math.cos(toCalculate);
                    answer = container.toString();
                    break;
                    
                case "tan":
                    container = Math.tan(toCalculate);
                    answer = container.toString();
                    break;
           
                default:
                    answer="funcion erronea 2";
            }
            
        }
        else//esto se usa  ya que  la resoues que vamos a procesar es un escalar y no esta ni en grado ni radianes 
        {
            auxiliaryContainer=this.calculate(expression);
            toCalculate=Double.parseDouble(auxiliaryContainer);
            switch(trigonometric)
            {
                case "sen":
                    container = Math.sin(toCalculate);
                    answer = container.toString();
                    break;
                
                case "cos":
                    container = Math.cos(toCalculate);
                    answer = container.toString();
                    break;
                    
                case "tan":
                    container = Math.tan(toCalculate);
                    answer = container.toString();
                    break;
           
                default:
                    answer="funcion erronea 2";
                    break;
            }
            
           
        }
        if(answer!="funcion erronea 2")
        {
            answer=this.cutFloat(answer, 3);

        }
         return answer;
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
            if(character=='t'|| character=='s'|| character=='c')
            {
                trigonometric=this.recognizeTrigOperations(expression, index);
                trigonometricAnswer=this.findParentheses(expression, index+3, 1);
                answer=answer+this.calculateTrigOperations(trigonometric, trigonometricAnswer);
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
    
    public String searchResolveParenthesis(String expression) throws ScriptException
    {
        String answer="";
        String parenthesis;
        Character character;
        int index=0;
        while(index<expression.length())
        {
            character = expression.charAt(index);
            if(character=='(')
            {
                parenthesis=this.findParentheses(expression, index, 1);
                parenthesis=this.cutParentheses(parenthesis);
                answer=answer+this.calculate(parenthesis);
                index+=(parenthesis.length()+2);
            }
            else
            {
                answer=answer+character.toString();
                index++;
            }
        }
        return answer;
    }
    public String searchResolvePowers(String expression) throws ScriptException
    {
        String answer="";
        String powers;
        String container1;
        String container2;
        Character character;
        int index=0;
        while(index<expression.length())
        {
            character = expression.charAt(index);
            if(character=='^')
            {
                container2=this.lookTowards(expression, index, 1);
                container1=this.lookTowards(expression, index, -1);
                answer=answer.substring(0, answer.length()-container1.length());
                answer=answer+this.resolvePowers(expression, index);
                index+=container2.length()+1;
            }
            else
            {
                answer=answer+character.toString();
                index++;
            }
        }
        return answer;
    }
    
    public String searchResolveFactorial(String expression) throws ScriptException
    {
        String answer="";
        String factorial;
        String container1;
        Character character;
        int index=0;
        while(index<expression.length())
        {
            character = expression.charAt(index);
            if(character=='!')
            {
                container1=this.lookTowards(expression, index, -1);
                if((answer.length()-container1.length())==0)
                {
                    answer="";
                }
                else
                {
                    answer=answer.substring(0, answer.length()-container1.length());
                }
                System.out.println("container1 "+container1);
                answer=answer+this.calculateFactorial(container1);
                index++;
            }
            else
            {
                answer=answer+character.toString();
                index++;
            }
        }
        return answer;
    }
    public String calculateAdvanced(String expression) throws ScriptException
    {
        String answer=" ";
       expression=this.searchResolverTrigonometric(expression);// se recorre la expresion y se resulvan todas las expresiones trigonometricas 
       System.out.println("expression33"+expression);
       expression=this.searchResolveParenthesis(expression);
       System.out.println("expression34"+expression);
       expression=this.searchResolvePowers(expression);
       System.out.println("expression35"+expression);
       expression=this.searchResolveFactorial(expression);
       System.out.println("expression36"+expression);
       
       
       answer = this.calculateBasic(expression);// una vez resueltas todas las operaciones avanzadas se  calcula todas la soperaciones basicas
        
        return answer;
    }
    
//funcion que corta los parentesis d elso extremos en caso de ser nesesario     
    public String cutParentheses(String expression)
    {
        
        if(expression.charAt(0)=='(')
        {
            expression=expression.substring(1, expression.length());
        }
            
        if(expression.charAt(expression.length()-1)==')')
        {
           expression=expression.substring(0, expression.length()-1);   
        }
       
        return expression;
    }
    
    // función que da formato a los numeros  que en caso de ser de tipo flotante los  deja solo con una cantidad determinado  de digitos  despues del punto.
    public String cutFloat(String expression,int quantityFloatDigits)
    {
        String answer="";
        String expressionAux=expression;
        boolean less=false;
        if(expression.charAt(0)=='-')// si el numero es menor a 0.001 se concidera que es 0
        {
            
            less=true;
            expression=expression.replaceFirst("-", " ");
        }
        if(Double.parseDouble(expression)<0.001) 
        {
                answer="0.000";
                return answer;
        }
        if(expression.contains("."))// esto es para ver si la respuesta tiene un punto 
        {   
            if(expression.contains("E"))
            {
                Double doubleAux=Double.parseDouble(expression);
                answer=doubleAux.toString();
                return answer;
            }
            else
            {
                expression=this.cutParentheses(expression);
            
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
            }
            
        }
        else
        {
           answer=expressionAux; 
        }
        
        if(less==true && answer.matches("^[0-9 ]+||^[0-9 ]+\\.[0-9 ]+$"))
        {
            answer=answer.replaceFirst(" ", "-");
        }
        
        return answer;
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
                answer=this.findParentheses(expression, index+increase, increase);
                
                answer=this.calculate(answer);
                
            }
            else
            {
                answer=this.searchNumber(expression, index+increase, increase);// si es un numero buscara el numero completo
            }
        }
        else
        {
            
             if(character ==')')// si el lemento que encuentra a la derecha del indice es un )  buscara y resolvera lo que este dentro de ese parentesis
            {
                answer=this.findParentheses(expression, index+increase, increase);
                answer=this.calculate(answer);
                
            }
            else
            {
                answer=this.searchNumber(expression, index+increase, increase);// si es un numero buscara el numero completo
            }
        }
        return answer;
    }
    
}
