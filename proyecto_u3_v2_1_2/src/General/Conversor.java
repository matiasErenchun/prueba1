/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 */
public class Conversor {
    
    int decimal;
   /*
    transforma un decimal a hexadecimal
    */ 
    String decToHexString(List<String> numDecimal){ 
        decimal=0;
        int resto=0; 
        String Hexadecimal=""; 
        System.out.println("imput:"+numDecimal);
        
        for (int x=0; x<numDecimal.size(); x++){
            decimal=decimal*10;
            decimal += Integer.parseInt(numDecimal.get(x));
        }
        
        while(decimal>0){ 
            resto=(decimal%16); 
            if(resto>9) {
                Hexadecimal=letras(resto)+Hexadecimal; 
            }
            else{
                Hexadecimal=resto+Hexadecimal; 
            }
             decimal=decimal/16; 
        } 
        System.out.println("hex: "+Hexadecimal);
        return Hexadecimal;
    } 
    
    ArrayList<String> decToHexList(List<String> numDecimal){
        
        String Hexadecimal=decToHexString(numDecimal); 
        ArrayList<String> finalList=stringCharSeparator(Hexadecimal);
        
        System.out.println("arreglo hex:"+finalList);
        return finalList;
    }
     
    private static String letras(int n){ 
        String letra=""; 
        switch(n){ 
        case 10: letra="A"; break; 
        case 11: letra="B"; break; 
        case 12: letra="C"; break; 
        case 13: letra="D"; break; 
        case 14: letra="E"; break; 
        case 15: letra="F"; break; 
        } 
        return letra; 
    } 
   
    /*
    Este metodo transforma un string en un array de strings separando sus componentes
    */
    ArrayList<String> stringCharSeparator(String Hexadecimal){
        ArrayList<Character> charList = new ArrayList<>();      
        for(int i = 0; i<Hexadecimal.length();i++){
            charList.add(Hexadecimal.charAt(i));
        }

        ArrayList<String> finalList=new ArrayList<>();
        charList.forEach((character) -> {
            finalList.add(Character.toString(character));
        });
        return finalList;
    }
    /*
    este metodo transforma un hexadecimal en decimal y lo retorna en forma de int
    */
    int hexToDecInt(ArrayList<String> hex){
        
        int numero = 0;
        for (String string : hex) {
            int u=numeros(string);
            numero=16*numero+u;
        }
        System.out.println("decimal 1: "+numero);
        return numero;
    }
    /*
    este metodo transforma un hexadecimal en decimal y lo retorna en forma de arraylist de strings
    */
    ArrayList<String> hexToDecString(ArrayList<String> hex){
        
        String a= Integer.toString(hexToDecInt(hex));
        ArrayList<String> finalList=stringCharSeparator(a);
        System.out.println("arreglo decimal:"+finalList);
        return finalList;
    }
    
    private static int numeros(String letra) 
    { 
        int n=0;
        switch(letra){ 
        case "A": n=10; break; 
        case "B": n=11; break; 
        case "C": n=12; break; 
        case "D": n=13; break; 
        case "E": n=14; break; 
        case "F": n=15; break; 
        default: n=Integer.parseInt(letra); break;
        }
        return n;
    }
    /*
    este metodo transforma un numero decimal a binario y lo retorna en forma de string
    */
    String toBinaryString(List<String> numDecimal){

        Integer numeroLista = 0;
        
        for (int x=0; x<numDecimal.size(); x++){
            numeroLista=numeroLista*10;
            numeroLista += Integer.parseInt(numDecimal.get(x));
        }
        String base2="";
        while(numeroLista>0) {
            base2=(numeroLista%2)+base2;
            numeroLista/=2;  
        }
        System.out.println("binario:"+base2);
        return base2;
    }
    
    /*
    este metodo transforma un numero decimal a binario y lo retorna en forma de Arraylist de stings
    */
    ArrayList<String> toBinaryList(List<String> numDecimal){

        String base2=toBinaryString(numDecimal);

        ArrayList<String> finalList=stringCharSeparator(base2);
        System.out.println("arreglo binario:"+finalList);
        return finalList;
    }
    /*
    este metodo transforma binario a decimal y lo retorna en forma de int
    */    
    int binToDecInt(String binary){
        int i=binary.length()-1;
        int j=0;
        int fin=0;
        while(i>=0)
        {
            if(binary.charAt(i)=='1'){
                int p=(int) Math.pow(2, j);
                fin+=p;
            }
            j++;
            i--;
        }
        System.out.println("decimal 2: "+fin);
        return fin;
    }
    /*
    este metodo transforma binario a decimal y lo retorna en forma de arraylist de strings
    */
    ArrayList<String> binToDecList(String binary){
        String a = Integer.toString(binToDecInt(binary));
        ArrayList<String> finalList=stringCharSeparator(a);
        System.out.println("arreglo decimal 2:"+finalList);
        return finalList;
    }
}

