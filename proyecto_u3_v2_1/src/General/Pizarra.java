/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

/**
 *
 * @author elias
 */
public class Pizarra {
    
    private double espacioNumero=0; //Espacio en X que indica a las figuras en qué posición deben dibujarse.
    private double espacioSuperior=0; //Espacio en Y que indica a las figuras en qué posición deben dibujarse.
    private boolean puntosVisibles = false;
    private List<NumerosYSimbolos> enPantalla; //Lista de todos los elementos dibujados en Pantalla.
    private Group grupoPantalla;
    private boolean divideStatus =false; //Variable que sirve para saber en qué estado está una división.
    //divideStatus = 1; Significa que se ha iniciado una nueva división y se está dibujando en la parte de arriba de esta.
    //divideStatus = 2; Significa que se está dibujando en la parte inferior de uan división.
    //divideStatus = 0; Significa que no hay división activa.
    private int divisiones = 0; //Contador de Divisiones. Utilizado para tener control sobre el crecimiento de la línea de división.
    private List<String> decimal;
    private List<String> numeroATransformar;
    private MapLevel miMap;
    private int currentlevel;
    private int minimumLevel;
    private int miximumLevel;
    private double endXMayor;
    private String sabe;
    private Conversor conversor = new Conversor();
    private Label texto;
    private Group textoGrup=new Group();
    private String tipoDePizarra;
    
    private Path center = new Path();
    private Group centro=new Group(center);
    
    public Pizarra(String tipoDePizarra) {
        this.enPantalla = new ArrayList<NumerosYSimbolos>();
        this.numeroATransformar = new ArrayList<>();
        this.tipoDePizarra=tipoDePizarra;
        center.setManaged(false);
       
        grupoPantalla=new Group(centro);
        inicio();
    }
    
    private void inicio() {
        cambiarTamanoElementos(0.5);
        sabe="";
        this.miMap = new MapLevel();
        this.miMap.startMap(this.espacioNumero, this.espacioSuperior);
        this.decimal = new ArrayList<>(); 
        this.startThisLevels();
        
        texto=new Label("");
        texto.setStyle("-fx-font-size:20px;");
       
        textoGrup.getChildren().add(texto);
        texto.setMaxWidth(Double.MAX_VALUE);
       
        texto.setAlignment(Pos.CENTER_LEFT);
    }
    

    
   

    public Group getGrupoPantalla() {
        return grupoPantalla;
    }

    public int getCurrentlevel() {
        return currentlevel;
    }

    public void setCurrentlevel(int currentlevel) {
        this.currentlevel = currentlevel;
    }
    
    //ahora hace lo de abajo pero para  el nivel en que se encuentra 
    //Método que aumenta en X para dejar espacio a los números.
    private void contador(boolean saltaTres,int level)
    {
        double contenedor = this.miMap.getLevel(level).getEndX();
        if (saltaTres==false)
        {
            contenedor+=90;
        }
        else
        {
            contenedor+=270;
        }
        this.miMap.getLevel(level).setEndX(contenedor);
        
    }
    
    private int aModificarDivision(){
        if (getLevelActual()>0) {
            return 1;
        }
        else if (getLevelActual()<0) {
            return -1;
        }
        return 0;
    }
    
    public String numeroAString(String transformacion) {
       int tamanoPantalla=enPantalla.size()-1;
       String escribir="";
       
       String numeroATransformarBinario = "";
       numeroATransformar.clear();

       //Se busca el último número escrito
       
       boolean numeroEncontrado=false;
       for (int x=tamanoPantalla; x>=0; x--) {
           for (int consigueNumero=x; consigueNumero>=0; consigueNumero--) {
                if ("number".equals(enPantalla.get(consigueNumero).getType())) {
                    if (enPantalla.get(consigueNumero).getTransformado()<3) {
                        if ("cientifica".equals(getTipoDePizarra())) {
                            numeroATransformar.add(0,enPantalla.get(consigueNumero).getID());
                        }

                        if ("binaria".equals(getTipoDePizarra())) {
                            numeroATransformarBinario=enPantalla.get(consigueNumero).getID()+numeroATransformarBinario;
                            numeroATransformar.add(0,enPantalla.get(consigueNumero).getID());
                        }

                        if ("hexa".equals(getTipoDePizarra())) {
                            numeroATransformar.add(0,enPantalla.get(consigueNumero).getID());
                        }
                        
                        
                        enPantalla.get(consigueNumero).aumentaTransformado(1);



                        numeroEncontrado=true;
                    }
                    else
                        System.out.println("EJALE ESE NUMERO YA SE TRANSFORMO");
                }
                if (numeroEncontrado && ("symbol".equals(enPantalla.get(consigueNumero).getType())))
                  break;
            }
           break;
       }
        System.out.println("NUMERO A TRANSFORMAR DESDE BINARIO");
        System.out.println(numeroATransformarBinario);
       

       if (numeroATransformar.size()>0 || numeroATransformarBinario.length()>0) {
           
//           ArrayList<String>b=conversor.decToHexList(numeroATransformar);
//           conversor.hexToDecString(numeroATransformar);
//           conversor.hexToDecInt(numeroATransformar);
//           conversor.toBinaryList(numeroATransformar);
//           conversor.decToHexString(numeroATransformar);
//           conversor.binToDecList(conversor.toBinaryString(numeroATransformar));
           
           //Acá se escribe en Pantalla los números en la otra base.
            if (transformacion.equals("a Binario")){
                //Decimal a Binario
                if ("cientifica".equals(getTipoDePizarra())) {
                    escribir = (conversor.toBinaryString(numeroATransformar));
                }
                //Hexa a Binario
                if ("hexa".equals(getTipoDePizarra())) {
                    escribir = conversor.hexaToBin(numeroATransformar);
                }
            }
           
            if (transformacion.equals("a Decimal")){
                //Binario a Decimal
                if ("binaria".equals(getTipoDePizarra())) {
                    escribir= String.valueOf(conversor.binToDecInt(numeroATransformarBinario));
                }
                //Hexa a Decimal
                if ("hexa".equals(getTipoDePizarra())) {
                    String a;
                    a = String.valueOf(conversor.binToDecInt(conversor.hexaToBin(numeroATransformar)));
                    
                    escribir= a;
                }
            }
            
            if (transformacion.equals("a Hexa")){
                //Decimal a Hexa
                if ("cientifica".equals(getTipoDePizarra())) {
                    escribir=conversor.decToHexString(numeroATransformar);
                }
                //Binario a Hexa
                if ("binaria".equals(getTipoDePizarra())) {
                    escribir = conversor.binToHexa(numeroATransformar);
                }
            }

            
       }
       return escribir;
    }
    
    
    
    
    public void escribeNumeros(String numeroAEscribir){
        System.out.println("ESTE NUMERO SE ESCRIBE");
        System.out.println(numeroAEscribir);

        for (int recorreNumero=0; recorreNumero<numeroAEscribir.length(); recorreNumero++) {
            addToScreen(String.valueOf(numeroAEscribir.charAt(recorreNumero)),currentlevel, true, 3);
        }
    }
    
    public boolean ocultaPuntosVisibles(){
        if (puntosVisibles==true) {
                puntosVisibles=false;
                for (int x=0; x<enPantalla.size(); x++) {
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                }
            }
        return puntosVisibles;
    }
    
    public boolean muestraPuntosVisibles(){
        if (puntosVisibles==false) {
            puntosVisibles=true;
            for (int x=0; x<enPantalla.size(); x++) {
                enPantalla.get(x).visibleCircle(puntosVisibles);
            }
        }
        return puntosVisibles;
    }
    
    
    public void cambiarTamanoElementos(double size) {
        this.centro.setScaleX(size);
        this.centro.setScaleY(size);
    }
    
    public void reiniciar(){
        Node elemento = centro.getChildren().get(0);
        centro.getChildren().removeAll(centro.getChildren());
        centro.getChildren().add(elemento);
        
        enPantalla.removeAll(enPantalla);
        divideStatus=false;
        divisiones=0;
        espacioNumero=0;
        espacioSuperior=0;
        decimal.clear();
        texto.setText("");
        this.miMap.startMap(espacioNumero, espacioSuperior);
        this.startThisLevels();
    }
    
    private void startThisLevels()
    {
        this.setLevelActual(0);
        this.setMinimumLevel(0);
        this.setMiximumLevel(0);
    }
    
    public int getLevelActual() {
        return this.currentlevel;
    }

    public void setLevelActual(int levelActual) {
        this.currentlevel = levelActual;
    }

    public int getMinimumLevel() {
        return this.minimumLevel;
    }

    public void setMinimumLevel(int minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    public int getMiximumLevel() {
        return this.miximumLevel;
    }

    public void setMiximumLevel(int miximumLevel) 
    {
        this.miximumLevel = miximumLevel;
    }
    
    
    public void paintDivideSubLevels(double marco ,int levelToPaint, boolean puntos)
    {
        if(this.miMap.getLevel(this.currentlevel).getStringLevel().equalsIgnoreCase(""))
        {
            this.paintDivide(marco, levelToPaint, puntos);
        }
        else
        {
            /*Prepárense todos los que se atrevan a intentar descifrar esto, a continuación, damas y caballeros, posiblemente
            una de las funciones más complejas del programa.
            
            Acá, para divisiones, se mueven los números y símbolos escritos anteriormente en el mismo nivel un poco más arriba o más abajo.*/
            
            String contenedor = this.miMap.getLevel(currentlevel).getStringLevel();
            
            this.miMap.getLevel(currentlevel).setStringLevel("");
            int contadorElementos=0;
            int contadorChar=0;
            int tamanoPantalla=enPantalla.size()-1;
            int cantChar = contenedor.length(); //Acá se guarda la cantidad de caracteres que hay en un nivel específico.
            int cantElementos = contadorElementos(contenedor); //Acá se guarda la cantidad de elementos que hay en un nivel específico
            
            /*Entiéndase, Elemento, a un elemento completo que se dibuja en pantalla, por ejemplo, "cos" es un elemento.
            Caracter, como toda figura individual que se dibuje en pantalla, por ejemplo, cos es un elemento conformado por 3 caracteres, "c", "o" y "s".
            */
            while(contadorElementos<cantElementos)
                
            {   
                /*Este boolean indica si el elemento ya fue dibujado con el fin de que no se dibuje dos veces o que resulte en un Null ya que
                no se ha aumentado en la búqueda de char.*/
                boolean dibujado = false;
                
                //Este boolean indica si se deben ejecutar las instrucciones para mover una función trigonométrica ya que esta se contiene de varios char.
                boolean trigonometrica=false;
                int aumentaChar=0;

                if (contenedor.charAt(contadorChar)=='c') {
                    if (contenedor.charAt(contadorChar+1)=='o') {
                         if (contenedor.charAt(contadorChar+2)=='s') {
                             if (dibujado==false) {
                                addToScreenTrigonometric("cos","(",levelToPaint, true, false);
                                trigonometrica=true;
                                
                             }
                         }
                    }  
                }
                
                if (contenedor.charAt(contadorChar)=='s') {
                    if (contenedor.charAt(contadorChar+1)=='e') {
                         if (contenedor.charAt(contadorChar+2)=='n') {
                             if (dibujado==false) {
                                addToScreenTrigonometric("sen","(",levelToPaint, true, false);
                                trigonometrica=true;
                                
                             }
                         }
                    }  
                }
                
                if (contenedor.charAt(contadorChar)=='t') {
                    if (contenedor.charAt(contadorChar+1)=='a') {
                         if (contenedor.charAt(contadorChar+2)=='n') {
                             if (dibujado==false) {
                                addToScreenTrigonometric("tan","(",levelToPaint, true, false);
                                trigonometrica=true;
                                
                             }
                         }
                    }  
                }
                
                if (trigonometrica==true) {
                    // Se agregan items para que hagan espacio, estos son invisibles.
                    addToScreen("",levelToPaint,false, 0);
                    addToScreen("",levelToPaint,false, 0);
                    addToScreen("",levelToPaint,false, 0);
                    contadorChar+=3;
                    aumentaChar=1;
                    dibujado=true;
                }
                
                
                //Según si la división está en numerador o denominador, esta parte mueve los elementos hacia arriba o hacia abajo.
                if (levelToPaint<0) {  
                    enPantalla.get(tamanoPantalla-cantElementos+contadorElementos+1).moverNumeroDivision(-40);
                    if (contadorElementos==0)
                        this.miMap.getLevel(levelToPaint).setEndX(this.miMap.getLevel(levelToPaint+1).getEndX()-(cantChar+aumentaChar)*90);
                    }
                else {
                    enPantalla.get(tamanoPantalla-cantElementos+contadorElementos+1).moverNumeroDivision(40);
                    if (contadorElementos==0)
                        this.miMap.getLevel(levelToPaint).setEndX(this.miMap.getLevel(levelToPaint-1).getEndX()-(cantChar+aumentaChar)*90);
                }
                
                if (dibujado==false) {
                    Character charAux=contenedor.charAt(contadorChar);
                    addToScreen(charAux.toString(),levelToPaint,false, 3);
                    contadorChar++;
                }
                
                contadorElementos++;

            }
            double myEndX=this.miMap.getLevel(levelToPaint).getEndX();
            this.miMap.getLevel(levelToPaint+1).setEndX(myEndX);
            this.miMap.getLevel(levelToPaint-1).setEndX(myEndX);
            this.paintDivide(marco, levelToPaint, puntos);
            this.miMap.getLevel(levelToPaint).setDrawBefore(false);
            
        }
    }
    
    
    
    public int division(){
         if(this.miMap.LevelIsClosed(this.currentlevel)==false)
            {
                
                if(this.currentlevel==0)
                {
                    this.divideStatus=true;
                    
                    this.espacioNumero=this.miMap.getLevel(0).getEndX();
                    this.paintDivide(0, this.currentlevel,this.puntosVisibles);
                    this.miMap.createLevel(this.espacioNumero, this.currentlevel-1);
                    this.miMap.createLevel(this.espacioNumero, this.currentlevel+1);
                    this.setMinimumLevel(1);
                    this.setMiximumLevel(-1);
                
                }
                else
                {
                    if(this.currentlevel>0 && this.currentlevel==this.minimumLevel)
                    {
                    
                        this.miMap.createLevel(this.espacioNumero, this.currentlevel+1);
                        this.miMap.createLevel(this.espacioNumero, this.currentlevel+2);
                        this.setMinimumLevel(this.currentlevel+2);
                        this.paintDivideSubLevels(0, this.currentlevel+1,this.puntosVisibles);
                    
                    }
                    else
                    {
                        if(this.currentlevel==this.miximumLevel)
                        {
                            
                            this.miMap.createLevel(this.espacioNumero, this.currentlevel-1);
                            this.miMap.createLevel(this.espacioNumero, this.currentlevel-2);
                            this.setMiximumLevel(this.currentlevel-2);
                            this.paintDivideSubLevels(0, this.currentlevel-1,this.puntosVisibles);
                            
                        }
                    
                    }
                }
            }
            else
            {
                //error nivel cerrado
            }
            return currentlevel;
    }
    
    public void botonSubir(){
            currentlevel--;
            if(currentlevel<miximumLevel)
            {
                currentlevel+=1;
            }

           System.out.println(currentlevel+"current");

           pintaNivel();
    }
    
    public void botonBajar(){
        currentlevel+=1;
        if(currentlevel>minimumLevel)
        {
            currentlevel-=1;
        }
        System.out.println(currentlevel+"current");
        pintaNivel();
    }
    
    public void botonCerrar() {
         if(currentlevel==0)
                {
                    espacioNumero=miMap.getLevel(currentlevel).getEndX();
                    espacioSuperior=miMap.getLevel(currentlevel).getyLevel();
                    sabe=miMap.getStringDivide(miximumLevel, minimumLevel);
                    miMap.startMap(espacioNumero, espacioSuperior);
                   
                    startThisLevels();
                    divideStatus=false;
                    decimal.add(sabe);
                    
                    
                    
                }
                else
                {
                    boolean status=miMap.closeLevel(currentlevel, divideStatus);
                    boolean statusLevel=miMap.getLevel(currentlevel).isLevelStatus();
                    
                }
                /*
                Éste método sirve para que crezca la división una vez se cierre un nivel.
                */
                //Se busca si es que existe una división en ese nivel
                for (int buscador=0; buscador<enPantalla.size(); buscador++) {
                    if ("symbol".equals(enPantalla.get(buscador).getType())){
                        if ("/".equals(enPantalla.get(buscador).getID())) { 
                            if (enPantalla.get(buscador).isDivisionTerminada()==false) {
                                if (getLevelActual()==enPantalla.get(buscador).getNivelActual()) {
                                
                                    //Se respaldan algunos datos de la división actual.
                                    double espacioDivision= enPantalla.get(buscador).getxPoint()-155;
                                    double superiorDivision = enPantalla.get(buscador).getyPoint();

                                    //Se remueve la división actual.
                                    //centro.getChildren().remove(enPantalla.get(buscador));
                                    enPantalla.get(buscador).root.setVisible(false);
                                    //enPantalla.remove(buscador);
                                    
                                    
                                    //Se añade una nueva división con el largo nuevo.
                                   
                                    
                                    endXMayor=miMap.getLevel(currentlevel).getEndX();
                                    if (currentlevel!=0) {
                                        endXMayor=miMap.getLevel(currentlevel+1).getEndX();
                                        if (miMap.getLevel(currentlevel-1).getEndX()>endXMayor) {
                                                endXMayor=miMap.getLevel(currentlevel-1).getEndX();
                                        }
                                    }
                                    
                                    System.out.println(endXMayor);
                                    NumerosYSimbolos division = new NumerosYSimbolos(0, espacioDivision,superiorDivision, puntosVisibles, getLevelActual()+aModificarDivision(), 0);
                                    centro.getChildren().add(division.division(endXMayor-espacioDivision));
                                    System.out.println("END X MAYOR Y ESPACIO DIVISION");
                                    System.out.println(endXMayor);
                                    System.out.println(espacioDivision);
                                    enPantalla.set(buscador, division);
                                }
                            }
                        }
                    }
                }
    }
    
    public void paintDivide(double marco ,int levelToPaint, boolean puntos)
    {
        
        double miX=this.miMap.getLevel(levelToPaint).getEndX();
        double miY=this.miMap.getLevel(levelToPaint).getyLevel();
       
        NumerosYSimbolos symbol= new NumerosYSimbolos(0,miX,miY,puntos,getLevelActual()+aModificarDivision(), 0);
        this.centro.getChildren().add(symbol.division(85));
        
        this.miMap.getLevel(levelToPaint).setDrawBefore(false);
        this.enPantalla.add(symbol);
        this.contador(false, levelToPaint);
    }
    /*
    Este metodo se utiliza para dibujar en la interfaz todos los numeros y simbolos.
    */
    public void addToScreen (String id, int level, boolean visible, int transformado){
        String aux2 = "";
        if(this.miMap.validateLevelToWrite(level,this.divideStatus))
        {
            double n =0;
            double xFromThisLevel =this.miMap.getLevel(level).getEndX();
            double yFromThisLevel =this.miMap.getLevel(level).getyLevel();

            NumerosYSimbolos numero = new NumerosYSimbolos(n, xFromThisLevel,yFromThisLevel, puntosVisibles,level, transformado);
            
            this.centro.getChildren().add(numero.dibujo(id));
            

            /*printScientific(id,level,0);
            printScientific(id,level,1);*/
            
            this.contador(false,level);
            this.enPantalla.add(numero);
            //en caso de, se hacen invisibles los números para hacer el espacio
            this.enPantalla.get(enPantalla.size()-1).visible(visible);
            //se desactivan los círuclos permanentemente de los invisibles
            /*if (visible==false) {
                this.enPantalla.get(enPantalla.size()-1).deleteCircle();
            }*/
            String miID=numero.getID();
            if(this.divideStatus)
            {
                String aux ="";
                if(this.miMap.getLevel(level).getDrawBefore())
                {
                 
                    this.miMap.getLevel(level).AddStringToStringBefore(miID);
                }
                else
                {
                    this.miMap.getLevel(level).addStringToStringLevel(miID);
                }
                
                aux=this.miMap.getStringDivide(this.miximumLevel, this.minimumLevel);
                System.out.println(aux+"div1");
                aux2=this.agregarTexto()+aux;
                texto.setText(aux2);
                
            }
            else
            {
                decimal.add(numero.getID());
                texto.setText(agregarTexto());
            }
        }
        
    }
    /*
    Este metodo se utiliza para dibujar en la interfaz los terminos trigonometricos (cos, sen, tan).
    */
    void addToScreenTrigonometric (String id1,String id2, int level,boolean visible, boolean mostrar)
    {
        String aux2 = "";
        if(this.miMap.validateLevelToWrite(currentlevel,this.divideStatus))
        {
            double n =0;
            double xFromThisLevel =this.miMap.getLevel(this.currentlevel).getEndX();
            double yFromThisLevel =this.miMap.getLevel(this.currentlevel).getyLevel();

            NumerosYSimbolos numero1 = new NumerosYSimbolos(n, xFromThisLevel,yFromThisLevel, puntosVisibles, level, 0);
            this.centro.getChildren().add(numero1.dibujo(id1));

            this.contador(true,currentlevel);
            
            this.enPantalla.add(numero1);
            this.enPantalla.get(enPantalla.size()-1).visible(mostrar);
            String miID=numero1.getID();
            if(this.divideStatus)
            {
                String aux ="";
                if(this.miMap.getLevel(level).getDrawBefore())
                {
                    
                    String papa =this.miMap.getLevel(level).getStringBeforeDivide();
                    System.out.println("papa"+ papa);
                    this.miMap.getLevel(level).AddStringToStringBefore(miID);
                    String mama =this.miMap.getLevel(level).getStringBeforeDivide();
                    System.out.println("mama"+ mama);
                }
                else
                {
                    this.miMap.getLevel(level).addStringToStringLevel(miID);
                }
                
                aux=this.miMap.getStringDivide(this.miximumLevel, this.minimumLevel);
                System.out.println(aux+"div");
                aux2=this.agregarTexto()+aux;
                texto.setText(aux2);
            }
            else
            {
                decimal.add(numero1.getID());
                texto.setText(agregarTexto());
            }
            
            
            addToScreen(id2,currentlevel,mostrar, 0);
        }
    }
    /*
    Este metodo pasa a texto todo lo que se ha ingresado
    */
   private String agregarTexto(){
        String listString="";
        for (String s : decimal)
        {
            listString += s;
        }
        return listString;
    }

   private String agregarTexto2(ArrayList<String> a){
        String listString="";
        for (String s : a)
        {
            listString += s;
        }
        return listString;
    }
   
   private int contadorElementos(String contenedor){
       int contadorInterno=0;
       int cantidadElementos=0;
       while (contadorInterno<contenedor.length()) {

           switch (contenedor.charAt(contadorInterno)) {
               case 'c':
                   if (contenedor.charAt(contadorInterno+1)=='o') {
                       if (contenedor.charAt(contadorInterno+2)=='s') {
                           contadorInterno+=2;
                       }
                   }  break;
               case 's':
                   if (contenedor.charAt(contadorInterno+1)=='e') {
                       if (contenedor.charAt(contadorInterno+2)=='n') {
                           contadorInterno+=2;
                       }
                   }  break;
               case 't':
                   if (contenedor.charAt(contadorInterno+1)=='a') {
                       if (contenedor.charAt(contadorInterno+2)=='n') {
                           contadorInterno+=2;
                       }
                   }  break;
               default:
                   break;
           }
            
            contadorInterno+=1;
            cantidadElementos+=1;
        }
        System.out.println("CANTIDAD DE ELEMENTOS EN NIVEL");
        System.out.println(cantidadElementos);
        return cantidadElementos;
    }
   
   private String getStringCurrentLevel (int currentlevel) {
       return this.miMap.getLevel(currentlevel).getStringLevel();
   }
   
    private void pintaNivel(){
       for (int buscador=0; buscador<enPantalla.size(); buscador++) {
            if (enPantalla.get(buscador).getNivelActual()==currentlevel){
                enPantalla.get(buscador).getPath().setStroke(Color.RED);
            }
            else
                enPantalla.get(buscador).getPath().setStroke(Color.BLACK);
        }
    }

    private void swapSreen(Group grupo) {
        grupoPantalla.getChildren().clear();
        grupoPantalla.getChildren().add(grupo);
    }

    void printScientific(String id, int level, int i) {
        double n =0;    
        double xFromThisLevel =this.miMap.getLevel(level).getEndX();
        double yFromThisLevel =this.miMap.getLevel(level).getyLevel();
        NumerosYSimbolos numero = new NumerosYSimbolos(n, xFromThisLevel,yFromThisLevel, puntosVisibles,currentlevel, 0);
        if(i==0){
            this.centro.getChildren().add(numero.dibujo(id));
        }
        if(i==1){
            this.centro.getChildren().add(numero.dibujo(id));
        }        
    }
    
    private void divideCientifica(int i, double espacioDivision, double superiorDivision) {
        NumerosYSimbolos division = new NumerosYSimbolos(0, espacioDivision,superiorDivision, puntosVisibles, getLevelActual()+aModificarDivision(), 0);
        
        if(i==0){
            centro.getChildren().add(division.division(endXMayor-espacioDivision));
        }
        if(i==1){
            centro.getChildren().add(division.division(endXMayor-espacioDivision));
        }
    }
    
    
    public String getTextoNivel(){
        return (("Nivel actual: "+ Integer.toString(currentlevel)));
    }
    
    public boolean getNivelCerrado(){
        return miMap.LevelIsClosed(currentlevel);
    }

    public Label getTexto() {
        return texto;
    }
    
    public String getStringTexto(){

        String texto=this.texto.getText();
        System.out.println("texto2 "+texto);
        return texto;
    }

    public List<NumerosYSimbolos> getEnPantalla() {
        return enPantalla;
    }

    public String getTipoDePizarra() {
        return tipoDePizarra;
    }

}
