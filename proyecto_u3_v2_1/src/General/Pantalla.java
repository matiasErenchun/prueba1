package General;


import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mario
 */
public class Pantalla{

    private double espacioNumero=0; //Espacio en X que indica a las figuras en qué posición deben dibujarse.
    private double espacioSuperior=0; //Espacio en Y que indica a las figuras en qué posición deben dibujarse.
    private boolean puntosVisibles = false;
    private List<NumerosYSimbolos> enPantalla; //Lista de todos los elementos dibujados en Pantalla.
    private Group centro;
    private Group grupoPantalla;
    private boolean divideStatus =false; //Variable que sirve para saber en qué estado está una división.
    //divideStatus = 1; Significa que se ha iniciado una nueva división y se está dibujando en la parte de arriba de esta.
    //divideStatus = 2; Significa que se está dibujando en la parte inferior de uan división.
    //divideStatus = 0; Significa que no hay división activa.
    private int divisiones = 0; //Contador de Divisiones. Utilizado para tener control sobre el crecimiento de la línea de división.
    private List<String> decimal;
    private List<String> numDecimal;
    private MapLevel miMap;
    private int currentlevel;
    private int minimumLevel;
    private int miximumLevel;
    //contenedor de los simbolos
    HBox cajaDeSimbolos = new HBox();
    VBox simbolos = new VBox();
    VBox trigonometria = new VBox();
    HBox contenedorNumeros = new HBox();
    HBox binario= new HBox();
    HBox contenerdorPrincipal = new HBox();         
    Stage primaryStage=new Stage();
    VBox contenedorSimbolos = new VBox();
    Label texto= new Label("");
    ScrollPane textBox=new ScrollPane();
    int tipoCalculadora=0;//0=basica 1=cientifica
    int baseCalculadora=0;//0=decimal 1=binaria 2=hexadecimal
    MenuItem cincuenta;
    MenuItem cien;
    MenuItem docientos;
    MenuItem basica;
    MenuItem tipoDecimal;
    MenuItem tipoBinario;
    MenuItem tipoHexadec;
    MenuItem mostrar;
    MenuItem ocultar;
    private String sabe;
    Conversor conversor = new Conversor();
    VBox hexColum1=new VBox();
    VBox hexColum2=new VBox();
    Label currentLevel=new Label("Nivel actual: ");
    
    
    public Pantalla() {
        this.enPantalla = new ArrayList<NumerosYSimbolos>();
        this.decimal = new ArrayList<>(); 
        this.numDecimal = new ArrayList<>();
        inicio();
    }
    /*
    Este es el metodo principal en donde se genera la interfaz geafica y muchas de las acciones de los botones
    */
    public void inicio(){
        currentLevel.setText("Nivel actual: "+ Integer.toString(currentlevel));
        sabe="";
        this.miMap = new MapLevel();
        this.miMap.startMap(this.espacioNumero, this.espacioSuperior);
        this.startThisLevels();
        
        VBox numerosColumna1 = new VBox();//creamos el Hbox
        VBox numerosColumna2 = new VBox();
        VBox numerosColumna3 = new VBox();  
        VBox binarioColum1 = new VBox();  
        VBox binarioColum2 = new VBox();  
        
       //*******inicio numeros***************
       
       
       numerosColumna1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button7 = new Button(" 7 ");
       Button button4 = new Button(" 4 ");// en este caso el contenido se entrega en el contructor
       Button button1 = new Button();
       Button buttonsqrt = new Button("√a");
       button1.setText(" 1 ");//contenido del boton 
       button1.setMaxWidth(Double.MAX_VALUE);
       buttonsqrt.setVisible(true);
       
       //HBox.setMargin(button1, new Insets(0,0,0,0));//margen entre objetos en este caso se dejo 5 a la  derecha 
       HBox.setHgrow(button7, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button4, Priority.ALWAYS);
       HBox.setHgrow(button1, Priority.ALWAYS);
       HBox.setHgrow(buttonsqrt, Priority.ALWAYS);
       HBox.setMargin(button7, javafx.geometry.Insets.EMPTY);
       button7.setMaxWidth(Double.MAX_VALUE);
       button4.setMaxWidth(Double.MAX_VALUE);
       buttonsqrt.setMaxWidth(Double.MAX_VALUE);
       numerosColumna1.getChildren().addAll(button7, button4,button1,buttonsqrt);
       
       
       //------------------------------//
       
        
       numerosColumna2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button8 = new Button(" 8 ");
       Button button5 = new Button(" 5 ");// en este caso el contenido se entrega en el contructor
       Button button2 = new Button(" 2 ");
       Button button0 = new Button(" 0 ");
       HBox.setHgrow(button8, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button5, Priority.ALWAYS);
       HBox.setHgrow(button2, Priority.ALWAYS);
       HBox.setHgrow(button0, Priority.ALWAYS);
       button8.setMaxWidth(Double.MAX_VALUE);
       button5.setMaxWidth(Double.MAX_VALUE);
       button2.setMaxWidth(Double.MAX_VALUE);
       button0.setMaxWidth(Double.MAX_VALUE);
       numerosColumna2.getChildren().addAll(button8, button5,button2,button0);
       
       //------------------------------//
       
       
       numerosColumna3.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button9 = new Button(" 9 ");
       Button button6 = new Button(" 6 ");// en este caso el contenido se entrega en el contructor
       Button button3 = new Button(" 3 ");
       Button buttonEliminar = new Button(" CE ");
       HBox.setHgrow(button9, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button6, Priority.ALWAYS);
       HBox.setHgrow(button3, Priority.ALWAYS);
       HBox.setHgrow(buttonEliminar, Priority.ALWAYS);
       button9.setMaxWidth(Double.MAX_VALUE);
       button6.setMaxWidth(Double.MAX_VALUE);
       button3.setMaxWidth(Double.MAX_VALUE);
       buttonEliminar.setMaxWidth(Double.MAX_VALUE);
       numerosColumna3.getChildren().addAll(button9, button6,button3,buttonEliminar);
       
   
       //------------------------------//
       
       contenedorNumeros.getChildren().addAll(numerosColumna1,numerosColumna2,numerosColumna3);
       //*******fin numeros***************
       
       //*******inicio simbolos***********
       
       
       //------------------------------//
       VBox simbolos1 = new VBox();
       simbolos1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonPar1 = new Button("   (   ");
       Button buttonMas = new Button(" + ");// en este caso el contenido se entrega en el contructor
       Button buttonPor = new Button(" * ");
       HBox.setHgrow(buttonPar1, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonMas, Priority.ALWAYS);
       HBox.setHgrow(buttonPor, Priority.ALWAYS);
       buttonPar1.setMaxWidth(Double.MAX_VALUE);
       buttonMas.setMaxWidth(Double.MAX_VALUE);
       buttonPor.setMaxWidth(Double.MAX_VALUE);
      
       simbolos1.getChildren().addAll(buttonPar1, buttonMas,buttonPor);
       
       //-------------------------------------//
       
       VBox simbolos2 = new VBox();
       simbolos2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonPar2= new Button("  )  ");
       Button buttonMenos = new Button(" - ");// en este caso el contenido se entrega en el contructor
       Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       HBox.setHgrow(buttonPar2, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonMenos, Priority.ALWAYS);
       HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       buttonPar2.setMaxWidth(Double.MAX_VALUE);
       buttonMenos.setMaxWidth(Double.MAX_VALUE);
       buttonDiv.setMaxWidth(Double.MAX_VALUE);
      
       simbolos2.getChildren().addAll(buttonPar2, buttonMenos,buttonDiv);
       
        //------------------------------//
       
        cajaDeSimbolos.getChildren().addAll(simbolos1,simbolos2);
        

        trigonometria.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
        Button buttonSen= new Button("  sen()  ");
        Button buttonCos = new Button("  cos()  ");// en este caso el contenido se entrega en el contructor
        Button buttonTan = new Button("  tan()  ");// en este caso el contenido se entrega en el contructor
        HBox.setHgrow(buttonSen, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
        HBox.setHgrow(buttonCos, Priority.ALWAYS);
        HBox.setHgrow(buttonTan, Priority.ALWAYS);
        buttonSen.setMaxWidth(Double.MAX_VALUE);
        buttonCos.setMaxWidth(Double.MAX_VALUE);
        buttonTan.setMaxWidth(Double.MAX_VALUE);
        
        trigonometria.getChildren().addAll(buttonSen, buttonCos, buttonTan);
         
        
        simbolos.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
        Button buttonGorrito= new Button("  ^  ");
        Button buttonGrados = new Button("  °  ");// en este caso el contenido se entrega en el contructor
        Button buttonFactorial = new Button("  !  ");// en este caso el contenido se entrega en el contructor
        HBox.setHgrow(buttonGorrito, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
        HBox.setHgrow(buttonGrados, Priority.ALWAYS);
        HBox.setHgrow(buttonTan, Priority.ALWAYS);
        buttonGorrito.setMaxWidth(Double.MAX_VALUE);
        buttonGrados.setMaxWidth(Double.MAX_VALUE);
        buttonFactorial.setMaxWidth(Double.MAX_VALUE);
        
        simbolos.getChildren().addAll(buttonGorrito, buttonGrados, buttonFactorial);
        
        //------------------------------//
       
       HBox simbolos4 = new HBox();
       simbolos4.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button = new Button("=");
       //Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(button, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       //HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       button.setMaxWidth(Double.MAX_VALUE);
       //buttonDiv.setMaxWidth(Double.MAX_VALUE);
        HBox div=new HBox();
        Button btnClose = new Button();
        btnClose.setText("Cerrar Nivel");
        btnClose.setDisable(true);

        Button btnUp = new Button();
        btnUp.setText("Subir Nivel");
        btnUp.setDisable(true);
        btnUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                currentlevel-=1;
                if(currentlevel<miximumLevel)
                {
                    currentlevel+=1;
                }

               System.out.println(currentlevel+"current");
               currentLevel.setText("Nivel actual: "+ Integer.toString(currentlevel));
            }
        });

        Button btnDawn = new Button();
        btnDawn.setText("Bajar Nivel");
        btnDawn.setDisable(true);
        btnDawn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                currentlevel+=1;
                if(currentlevel>minimumLevel)
                {
                    currentlevel-=1;
                }
                System.out.println(currentlevel+"current");
                currentLevel.setText("Nivel actual: "+ Integer.toString(currentlevel));
            }
        });

      btnDawn.setMaxWidth(Double.MAX_VALUE);
      HBox.setHgrow(btnDawn, Priority.ALWAYS);
      
      btnClose.setMaxWidth(Double.MAX_VALUE);
      HBox.setHgrow(btnClose, Priority.ALWAYS);
      
      btnUp.setMaxWidth(Double.MAX_VALUE);
      HBox.setHgrow(btnUp, Priority.ALWAYS);
      
      div.getChildren().addAll(btnDawn,btnClose,btnUp);
      simbolos4.getChildren().addAll(div,button);
       
       //-------------------------------------//
       
       
       contenedorSimbolos.getChildren().addAll(cajaDeSimbolos,simbolos4);
       
       
        binarioColum1.setPadding(new Insets(0));
        Button button0Bin = new Button(" 0 ");
        HBox.setHgrow(button0Bin, Priority.ALWAYS);
        VBox.setVgrow(button0Bin, Priority.ALWAYS);
        button0Bin.setMaxWidth(Double.MAX_VALUE); 
        button0Bin.setMaxHeight(Double.MAX_VALUE); 
        
        Button button1Bin = new Button(" 1 ");
        HBox.setHgrow(button1Bin, Priority.ALWAYS);
        VBox.setVgrow(button1Bin, Priority.ALWAYS);
        button1Bin.setMaxWidth(Double.MAX_VALUE);
        button1Bin.setMaxHeight(Double.MAX_VALUE);
 
       
       
       Button buttonsqrtBin = new Button("Bajar");
       buttonsqrtBin.setMaxWidth(Double.MAX_VALUE);
       HBox.setHgrow(buttonsqrtBin, Priority.ALWAYS);
       buttonsqrtBin.setVisible(false);
       
       Button buttonEliminarBin = new Button(" CE ");
       HBox.setHgrow(buttonEliminarBin, Priority.ALWAYS);
       buttonEliminarBin.setMaxWidth(Double.MAX_VALUE);
       
       binarioColum1.getChildren().addAll(button0Bin,buttonsqrtBin);
       binarioColum2.getChildren().addAll(button1Bin,buttonEliminarBin);
       binario.getChildren().addAll(binarioColum1,binarioColum2);
       //*******fin numeros***************
       //*******Inicio hexadecimal********//
       
       
       Button btnA=new Button("A");
       Button btnC=new Button("C");
       Button btnE=new Button("E");
       
       HBox.setHgrow(btnA, Priority.ALWAYS);
       HBox.setHgrow(btnC, Priority.ALWAYS);
       HBox.setHgrow(btnE, Priority.ALWAYS);
       btnA.setMaxWidth(Double.MAX_VALUE);
       btnC.setMaxWidth(Double.MAX_VALUE);
       btnE.setMaxWidth(Double.MAX_VALUE);
       
       hexColum1.getChildren().addAll(btnA,btnC,btnE);
       
       Button btnB=new Button("B");
       Button btnD=new Button("D");
       Button btnF=new Button("F");
       
       HBox.setHgrow(btnB, Priority.ALWAYS);
       HBox.setHgrow(btnD, Priority.ALWAYS);
       HBox.setHgrow(btnF, Priority.ALWAYS);
       btnB.setMaxWidth(Double.MAX_VALUE);
       btnD.setMaxWidth(Double.MAX_VALUE);
       btnF.setMaxWidth(Double.MAX_VALUE);
       
       hexColum2.getChildren().addAll(btnB,btnD,btnF);
      //*******inicio Esena de dibujo***********
       Box box = new Box(100,100,100);
       BorderPane pane = new BorderPane();
       box.setManaged(true);    
       //pane.setCenter(box);
       Path center = new Path();
       center.setManaged(false);
       
       centro=new Group(center);
       centro.setScaleX(0.5);
       centro.setScaleY(0.5);

       grupoPantalla=new Group(centro);
       
       ScrollPane mainPane=new ScrollPane(grupoPantalla); 
       
       pane.setCenter(mainPane);
       BorderPane.setAlignment(mainPane, Pos.CENTER);
       
       //** menu de opciones **//
       
        MenuBar barraSuperior= new MenuBar();
            Menu menu1 = new Menu("Zoom");

                cincuenta = new MenuItem("50%");
                cien = new MenuItem("100%");
                docientos = new MenuItem("200%");
            menu1.getItems().addAll(cincuenta,cien,docientos);
            cien.setDisable(true);
            cincuenta.setOnAction(e->SetSize(cincuenta.getText()));
            cien.setOnAction(e->SetSize(cien.getText()));
            docientos.setOnAction(e->SetSize(docientos.getText()));
            
            
            Menu menu2 = new Menu("Tipo de Calculadora");

                basica = new MenuItem("Básica");
                Menu cientifica = new Menu("Científica");
                    tipoDecimal = new MenuItem("Tipo Decimal");
                    tipoBinario = new MenuItem("Tipo Binario");
                    tipoHexadec = new MenuItem("Tipo Hexadecimal");
                cientifica.getItems().addAll(tipoDecimal,tipoBinario,tipoHexadec);
            menu2.getItems().addAll(basica,cientifica);
            
            basica.setDisable(true);
                    
            basica.setOnAction(e -> SetTypeKeyboard(basica.getText()));
            tipoDecimal.setOnAction(e->SetBase(tipoDecimal.getText()));
            tipoBinario.setOnAction(e->SetBase(tipoBinario.getText()));
            tipoHexadec.setOnAction(e->SetBase(tipoHexadec.getText()));
            
            Menu menu3 = new Menu("Puntos de Control");
                mostrar= new MenuItem("Mostrar Puntos de Control");
                ocultar= new MenuItem("Esconder Puntos de Control");
            menu3.getItems().addAll(mostrar,ocultar);
            ocultar.setDisable(true);
            
        barraSuperior.getMenus().addAll(menu1,menu2,menu3);
        
       pane.setTop(barraSuperior);
       
       buttonDiv.setOnAction((ActionEvent event) ->
        {
            if(this.miMap.LevelIsClosed(currentlevel)==false)
            {
                if(currentlevel==0)
                {
                    this.divideStatus=true;
                    btnDawn.setDisable(false);
                    btnUp.setDisable(false);
                    btnClose.setDisable(false);
                    this.espacioNumero=this.miMap.getLevel(0).getEndX();
                    this.paintDivide(0, currentlevel,this.puntosVisibles);
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
                        this.paintDivide(0, currentlevel+1,this.puntosVisibles);
                    
                    }
                    else
                    {
                        if(this.currentlevel==this.miximumLevel)
                        {
                            this.miMap.createLevel(this.espacioNumero, this.currentlevel-1);
                            this.miMap.createLevel(this.espacioNumero, this.currentlevel-2);
                            this.setMiximumLevel(this.currentlevel-2);
                            this.paintDivide(0, currentlevel-1,this.puntosVisibles);
                        }
                    
                    }
                }
            }
            else
            {
                //error nivel cerrado
            }
            currentLevel.setText("Nivel actual: "+ Integer.toString(currentlevel));
            btnUp.fire();
        });
       btnClose.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                
                System.out.println(":V");

                if(currentlevel==0)
                {
                    espacioNumero=miMap.getLevel(currentlevel).getEndX();
                    espacioSuperior=miMap.getLevel(currentlevel).getyLevel();
                    sabe=miMap.getStringDivide(miximumLevel, minimumLevel);
                    miMap.startMap(espacioNumero, espacioSuperior);
                   
                    startThisLevels();
                    divideStatus=false;
                    btnDawn.setDisable(true);
                    btnUp.setDisable(true);
                    btnClose.setDisable(true);
                    decimal.add(sabe);
                    
                    
                    
                }
                else
                {
                    boolean status=miMap.closeLevel(currentlevel, divideStatus);
                    boolean statusLevel=miMap.getLevel(currentlevel).isLevelStatus();
//                    System.out.println(currentlevel);
//                    System.out.println(statusLevel);
//                    System.out.println(status);
                }
                /*
                Éste método sirve para que crezca la división una vez se cierre un nivel.
                */
                //Se busca si es que existe una división en ese nivel
                for (int buscador=0; buscador<enPantalla.size(); buscador++) {
                    if ("symbol".equals(enPantalla.get(buscador).getType())){
                        if ("/".equals(enPantalla.get(buscador).getID())) {
                            if (getLevelActual()==enPantalla.get(buscador).getNivelActual()) {
                                
                                
                                //Se respaldan algunos datos de la división actual.
                                double espacioDivision= enPantalla.get(buscador).getxPoint()-155;
                                double superiorDivision = enPantalla.get(buscador).getyPoint();
                                
                                //Se remueve la división actual.
                                enPantalla.remove(buscador);
                                
                                //Se añade una nueva división con el largo nuevo.
                                NumerosYSimbolos division = new NumerosYSimbolos(0, espacioDivision,superiorDivision, puntosVisibles);
                                
                                centro.getChildren().add(division.division(getLevelActual(), miMap.getLevel(currentlevel).getEndX()-espacioDivision));
   
                            }
                        }
                    }
                }
            }
        });
        
       
       
       buttonPor.setOnAction((ActionEvent event) ->
        { 
            dibujar("*");
        });
       
       buttonPar1.setOnAction((ActionEvent event) ->
        { 
            dibujar("(");
        });
       
       buttonPar2.setOnAction((ActionEvent event) ->
        { 
            dibujar(")");
        });

       buttonMas.setOnAction((ActionEvent event) ->
        { 
            dibujar("+");
        });
       
       buttonMenos.setOnAction((ActionEvent event) ->
        { 
            dibujar("-");
        });
       
       button0.setOnAction((ActionEvent event) ->
        { 
            dibujar("0");
        });
       
       button1.setOnAction((ActionEvent event) ->
        { 
            dibujar("1");
        });
       
       button2.setOnAction((ActionEvent event) ->
        { 
            dibujar("2");
        });
       
       button3.setOnAction((ActionEvent event) ->
       { 
            dibujar("3");
        });
       
       button4.setOnAction((ActionEvent event) ->
       {
            dibujar("4");   
        });
       
       button5.setOnAction((ActionEvent event) ->
           
        {
            dibujar("5");   
        });
       
       button6.setOnAction((ActionEvent event) ->
           
        {
            dibujar("6");
         });
       
       button7.setOnAction((ActionEvent event) ->
           
        {
            dibujar("7");
         });
       
       button8.setOnAction((ActionEvent event) ->
           
        {
            dibujar("8");
         });
       
       button9.setOnAction((ActionEvent event) ->
           
        {
            dibujar("9");
         });
       
         buttonCos.setOnAction((ActionEvent event) ->
           
        {
         dibujarTrigonometrica("cos","(");
        });
       
       buttonSen.setOnAction((ActionEvent event) ->
           
        {
            dibujarTrigonometrica("sen","(");   
        });
       
       buttonTan.setOnAction((ActionEvent event) ->
           
        {
            dibujarTrigonometrica("tan","(");   
        });
       
       buttonGorrito.setOnAction((ActionEvent event) ->
           
        {
            dibujar("^");
        });
       
       buttonFactorial.setOnAction((ActionEvent event) ->
           
        {
          dibujar("!");
        });
       
       buttonGrados.setOnAction((ActionEvent event) ->
           
        {
            dibujar("º");
        });
       
       buttonsqrt.setOnAction((ActionEvent event) ->
           
        {
            dibujar("√a");
            dibujar("(");
        });
       //Este botón quita o pone los Puntos de Control.
       //Va cambiando el texto del botón según el estado de puntosVisibles.
       ocultar.setOnAction((ActionEvent event) ->
        { 
            if (puntosVisibles==true) {
                puntosVisibles=false;
                for (int x=0; x<enPantalla.size(); x++) {
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                }
                ocultar.setDisable(true);
                mostrar.setDisable(false);
            }
        });
               
        mostrar.setOnAction((ActionEvent event) ->
        { 
            if (puntosVisibles==false) {
                puntosVisibles=true;
                for (int x=0; x<enPantalla.size(); x++) {
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                }
                ocultar.setDisable(false);
                mostrar.setDisable(true);
            }
        });
       
        buttonEliminar.setOnAction((ActionEvent event) ->
        {
            reinicia();
            buttonDiv.setText("/");
        });
        button0Bin.setOnAction((ActionEvent event) ->
        { 
            button0.fire();
        });
       
       button1Bin.setOnAction((ActionEvent event) ->
        { 
            button1.fire();
        });
       buttonEliminarBin.setOnAction((ActionEvent event) ->
        {
            buttonEliminar.fire();
        });
       button.setOnAction((ActionEvent event) ->
        {
            numberToStrig(); 
        });
       //-------------------------------------//
       btnA.setOnAction((ActionEvent event) ->
        {
            dibujar("A"); 
        });
       btnB.setOnAction((ActionEvent event) ->
        {
            dibujar("B"); 
        });
       btnC.setOnAction((ActionEvent event) ->
        {
            dibujar("C"); 
        });
       btnD.setOnAction((ActionEvent event) ->
        {
            dibujar("D"); 
        });
       btnE.setOnAction((ActionEvent event) ->
        {
            dibujar("E"); 
        });
       btnF.setOnAction((ActionEvent event) ->
        {
            dibujar("F"); 
        });
       //-------------------------------------//
       
       Slider sliderSubScene = new Slider();
       sliderSubScene.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene.setMin(-10000);
       sliderSubScene.valueProperty().bindBidirectional(centro.translateXProperty());//se le da el recorrido al Slider en este caso es el largo del box
       //pane.setBottom(sliderSubScene);
       
       Slider sliderSubScene2 = new Slider();
       sliderSubScene2.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene2.setMin(-10000);
       sliderSubScene2.setOrientation(Orientation.VERTICAL);
       sliderSubScene2.valueProperty().bindBidirectional(centro.translateYProperty());//se le da el recorrido al Slider en este caso es el largo del box
       //pane.setLeft(sliderSubScene2);
       
       
       
       //SubScene pantallaDibujo = new SubScene(aux1,300,300);//creamos la SubScene dando su contenido  luego su ancho y altura 
       //en este caso su contenido es un border pane.
       
       //*******fin Esena de dibujo**************
       contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
       HBox.setHgrow(contenedorNumeros, Priority.ALWAYS);// se define la prioridad de llenado de espacio que tiene el nodo  dentro de su contenedor.
       HBox.setHgrow(contenedorSimbolos, Priority.ALWAYS);
       HBox.setHgrow(hexColum1, Priority.ALWAYS);
       HBox.setHgrow(hexColum2, Priority.ALWAYS);
       HBox.setHgrow(numerosColumna1, Priority.ALWAYS);
       HBox.setHgrow(numerosColumna2, Priority.ALWAYS);
       HBox.setHgrow(numerosColumna3, Priority.ALWAYS);
       HBox.setHgrow(simbolos1, Priority.ALWAYS);
       HBox.setHgrow(simbolos2, Priority.ALWAYS);
       HBox.setHgrow(trigonometria, Priority.ALWAYS);
       HBox.setHgrow(simbolos, Priority.ALWAYS);
       HBox.setHgrow(binarioColum1, Priority.ALWAYS);
       HBox.setHgrow(binarioColum2, Priority.ALWAYS);
       HBox.setHgrow(binario, Priority.ALWAYS);
       
       BorderPane BpanePrueba = new BorderPane();
       VBox bottom =new VBox();
       texto=new Label("");
       texto.setStyle("-fx-font-size:20px;");
       textBox.setContent(texto);
       textBox.setMinHeight(50);
       texto.setMaxWidth(Double.MAX_VALUE);
       texto.setAlignment(Pos.CENTER_LEFT);
       bottom.getChildren().addAll(contenerdorPrincipal,textBox,currentLevel);
       BpanePrueba.setBottom(bottom);
       //BpanePrueba.setCenter(pantallaDibujo);
       BpanePrueba.setCenter(pane);
      
        
        //StackPane root = new StackPane();
        
        primaryStage.setTitle("Cancer de Piel");//titulo de la ventana 
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(700);
        Scene scene = new Scene (BpanePrueba,800,600);//constructor de la ventana
        
        BpanePrueba.setMinSize(800, 600);
        //root.setPrefSize(400, 300);
        /**root.minHeight(300);
        root.minWidth(400);*/
        //root.getChildren().add(BpanePrueba);//agregamos el boton a al root
        primaryStage.setScene(scene);//agregamos scene a la pantalla
        primaryStage.show();//mostramos la pantalla
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
    //** aqui va todo lo de los cambios de tamaño **//
    
    /*
    En este metodo se asignana el tamaño de los dibujos en la pantalla
    */
    private void SetSize(String toString) {
        switch (toString){
            
            case "100%":
                setScaleNumbers(0.5);
                cien.setDisable(true);
                cincuenta.setDisable(false);
                docientos.setDisable(false);    
            break;
            
            case "50%":
                setScaleNumbers(0.25);
                cien.setDisable(false);
                cincuenta.setDisable(true);
                docientos.setDisable(false);
                
            break;
                
            case "200%":
                setScaleNumbers(1);
                cien.setDisable(false);
                cincuenta.setDisable(false);
                docientos.setDisable(true);
            break;
        }
    }
    
    //** aqui va todo lo de los cambios de base **//
    
    /*
    Este metodo se usa para hacer el cambio de base ademas del cambio de tipo de teclado
    */
    private void SetBase(String toString) {
        if (tipoCalculadora==0) {
            cajaDeSimbolos.getChildren().addAll(trigonometria, simbolos);
            primaryStage.setTitle("Cancer de Piel (Modo Científico)");
            reinicia();
            texto.setText("");
            this.decimal = new ArrayList<>();
        }
        
        switch(toString){
            
            case "Tipo Decimal":
                
                if(baseCalculadora==1){
                    contenerdorPrincipal.getChildren().removeAll(binario,contenedorSimbolos);
                    contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
                }
                
                if(baseCalculadora==2){
                    contenedorNumeros.getChildren().removeAll(hexColum1,hexColum2);
                }
                
                basica.setDisable(false);
                tipoBinario.setDisable(false);
                tipoDecimal.setDisable(true);
                tipoHexadec.setDisable(false);
                tipoCalculadora=1;
                baseCalculadora=0;
                break;
                
            case "Tipo Binario":
                
                contenerdorPrincipal.getChildren().removeAll(contenedorNumeros,contenedorSimbolos);
                contenerdorPrincipal.getChildren().addAll(binario,contenedorSimbolos);
                if (baseCalculadora==2) {
                    contenedorNumeros.getChildren().removeAll(hexColum1,hexColum2);
                }
                numberToStrig();
                basica.setDisable(false);
                tipoBinario.setDisable(true);
                tipoDecimal.setDisable(false);
                tipoHexadec.setDisable(false);
                tipoCalculadora=1;
                baseCalculadora=1;
                break;
                
            case "Tipo Hexadecimal":
                
                if(baseCalculadora==1){
                    contenerdorPrincipal.getChildren().removeAll(binario,contenedorSimbolos);
                    contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
                }
                contenedorNumeros.getChildren().addAll(hexColum1,hexColum2);
                basica.setDisable(false);
                tipoBinario.setDisable(false);
                tipoDecimal.setDisable(false);
                tipoHexadec.setDisable(true);
                tipoCalculadora=1;
                baseCalculadora=2;
                break;
        }
        
    }

    //** aqui va todo lo de los cambios de teclado **//
    
    /*
    En este metodo se cambia el teclado a basico
    */
    private void SetTypeKeyboard(String toString) {
        switch(toString){
            case "Básica":
                if(baseCalculadora==1){
                    contenerdorPrincipal.getChildren().removeAll(binario,contenedorSimbolos);
                    contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
                }
                if(baseCalculadora==2){
                    contenedorNumeros.getChildren().removeAll(hexColum1,hexColum2);
                }
                
                cajaDeSimbolos.getChildren().removeAll(trigonometria, simbolos);
                primaryStage.setTitle("Cancer de Piel");
                reinicia();
                basica.setDisable(true);
                tipoBinario.setDisable(false);
                tipoDecimal.setDisable(false);
                tipoCalculadora=0;
                baseCalculadora=0;
            break;
        }
    }
    /*
    Método que permite la transformación de lo que hay en pantalla a binario.
    */
    
    private void numberToStrig(){
        //Se busca que sea un número lo que se analizará.
        for (int x=0; x<enPantalla.size(); x++){
            if ("number".equals(enPantalla.get(x).getType())){
                System.out.println(enPantalla.get(x).getType());
                numDecimal.add(enPantalla.get(x).getID());
            }
            
            //Separa de forma correcta los elementos, es decir, sólo captura números y deja de lado los símbolos.
            if ("symbol".equals(enPantalla.get(x).getType()) || x==enPantalla.size()-1){
                if (x>1){
                    if ("number".equals(enPantalla.get(x-1).getType()) || x==enPantalla.size()-1){
                        ArrayList<String>b=conversor.decToHexList(numDecimal);
                        conversor.hexToDecString(b);
                        conversor.hexToDecInt(b);
                        conversor.toBinaryList(numDecimal);
                        conversor.binToDecList(conversor.toBinaryString(numDecimal));
                        numDecimal.clear();
                    }
                }                
                else {
                    ArrayList<String>b=conversor.decToHexList(numDecimal);
                    conversor.hexToDecString(b);
                    conversor.hexToDecInt(b);
                    conversor.toBinaryList(numDecimal);
                    conversor.binToDecList(conversor.toBinaryString(numDecimal));
                    numDecimal.clear();
                }
            }
        }
        
    }
    
    
    
    private void setScaleNumbers(double size){
        centro.setScaleX(size);
        centro.setScaleY(size);
    }
    
    private void reinicia(){
        Node elemento = centro.getChildren().get(0);
            centro.getChildren().removeAll(centro.getChildren());
            centro.getChildren().add(elemento);
            enPantalla.removeAll(enPantalla);
            divideStatus=false;
            divisiones=0;
            espacioNumero=0;
            espacioSuperior=0;
            this.miMap.startMap(espacioNumero, espacioSuperior);
            this.startThisLevels();
            texto.setText("");
            this.decimal = new ArrayList<>();
    }
    
    //reinicia los valores de level min max y actual.
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
    
    public void paintDivide(double marco ,int levelToPaint, boolean puntos)
    {
        double miX=this.miMap.getLevel(levelToPaint).getEndX();
        double miY=this.miMap.getLevel(levelToPaint).getyLevel();
        NumerosYSimbolos symbol= new NumerosYSimbolos(0,miX,miY,puntos);
        this.centro.getChildren().add(symbol.division(getLevelActual(), 90));
        this.enPantalla.add(symbol);
        this.contador(false, levelToPaint);
        
    }
    /*
    Este metodo se utiliza para dibujar en la interfaz todos los numeros y simbolos.
    */
    void dibujar (String id){
        if(this.miMap.validateLevelToWrite(currentlevel,this.divideStatus))
        {
            double n =0;
            double xFromThisLevel =this.miMap.getLevel(this.currentlevel).getEndX();
            double yFromThisLevel =this.miMap.getLevel(this.currentlevel).getyLevel();

            NumerosYSimbolos numero = new NumerosYSimbolos(n, xFromThisLevel,yFromThisLevel, puntosVisibles);

            this.centro.getChildren().add(numero.dibujo(id));
            this.contador(false,currentlevel);
            this.enPantalla.add(numero);
            String miID=numero.getID();
            if(this.divideStatus)
            {
                String aux ="";
                String aux2="";
                this.miMap.getLevel(currentlevel).addStringToStringLevel(miID);
                aux=this.miMap.getStringDivide(this.miximumLevel, this.minimumLevel);
                System.out.println(aux+"div");
                aux2=this.agregarTexto()+aux;
                texto.setText(aux2);
            }
            else
            {
                decimal.add(numero.getID());
                texto.setText(agregarTexto());
            }
            System.out.println(this.currentlevel);
        }
    }
    /*
    Este metodo se utiliza para dibujar en la interfaz los terminos trigonometricos (cos, sen, tan).
    */
    void dibujarTrigonometrica (String id1,String id2)
    {
        if(this.miMap.validateLevelToWrite(currentlevel,this.divideStatus))
        {
            double n =0;
            double xFromThisLevel =this.miMap.getLevel(this.currentlevel).getEndX();
            double yFromThisLevel =this.miMap.getLevel(this.currentlevel).getyLevel();

            NumerosYSimbolos numero1 = new NumerosYSimbolos(n, xFromThisLevel,yFromThisLevel, puntosVisibles);
            centro.getChildren().add(numero1.dibujo(id1));

            this.contador(true,currentlevel);
            
            enPantalla.add(numero1);
            String miID=numero1.getID();
            if(this.divideStatus)
            {
                String aux ="";
                String aux2="";
                this.miMap.getLevel(currentlevel).addStringToStringLevel(miID+"(");
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
            
            dibujar(id2);
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
}
    