package General;


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.stage.Stage;
import javax.script.ScriptException;

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

    
    //contenedor de los simbolos
    private HBox cajaDeSimbolos = new HBox();
    private VBox simbolos = new VBox();
    private VBox trigonometria = new VBox();
    private HBox contenedorNumeros = new HBox();
    private HBox binario= new HBox();
    private HBox contenerdorPrincipal = new HBox();         
    private Stage primaryStage=new Stage();
    private VBox contenedorSimbolos = new VBox();
    private Label texto= new Label("");
    private ScrollPane textBox=new ScrollPane();
    private int tipoCalculadora=0;//0=basica 1=cientifica
    private int baseCalculadora=0;//0=decimal 1=binaria 2=hexadecimal
    private MenuItem cincuenta;
    private MenuItem cien;
    private MenuItem docientos;
    private MenuItem basica;
    private MenuItem tipoDecimal;
    private MenuItem tipoBinario;
    private MenuItem tipoHexadec;
    private MenuItem mostrar;
    private MenuItem ocultar;
    private ScrollPane mainPane;
    private ScrollPane mainPaneCientifica;
    private ScrollPane mainPaneBinario;
    private ScrollPane mainPaneHexa;
    private BorderPane pane;
    private boolean puntosVisibles = false;
    private double tamanoPizarra = 0.5;
    private CalculationCore calculationCore;
    

    private VBox hexColum1=new VBox();
    private VBox hexColum2=new VBox();
    private Label labelCurrentLevel=new Label("Nivel actual: ");
    //-----------------------------------//
    
    //-----------------------------------//
    private Group textoGrup=new Group();
    private Button btnClose = new Button();
    
    public Pizarra pizarraBasica;
    private Pizarra pizarraCientifica;
    private Pizarra pizarraBinaria;
    private Pizarra pizarraHexa;
    private Pizarra pizarraActual;
    
    public Pantalla() throws ScriptException {
        inicio();
    }
    
    
    /*
    Este es el metodo principal en donde se genera la interfaz geafica y muchas de las acciones de los botones
    */
    public void inicio() throws ScriptException{
        this.calculationCore=new CalculationCore();
        this.pizarraBasica = new Pizarra("basica");
        this.pizarraCientifica = new Pizarra("cientifica");
        this.pizarraBinaria = new Pizarra("binaria");
        this.pizarraHexa = new Pizarra("hexa");
        
        pizarraActual=pizarraBasica;
        
        labelCurrentLevel.setText(pizarraActual.getTextoNivel());
        

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
       Button buttonEquals = new Button("=");
       //Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonEquals, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       //HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       buttonEquals.setMaxWidth(Double.MAX_VALUE);
       //buttonDiv.setMaxWidth(Double.MAX_VALUE);
        HBox div=new HBox();
        btnClose.setText("Cerrar Nivel");
        btnClose.setDisable(true);

        Button btnUp = new Button();
        btnUp.setText("Subir Nivel");
        btnUp.setDisable(true);
        btnUp.setOnAction((ActionEvent event) ->
        {
           int currentlevel=this.pizarraActual.getCurrentlevel();
           
           
           if (tipoCalculadora==0)
                this.pizarraActual.botonSubir();
            else {
                dibujaOtrasBases(true, false);
                this.pizarraBinaria.botonSubir();
                this.pizarraHexa.botonSubir();
                this.pizarraCientifica.botonSubir();
            }
           
           labelCurrentLevel.setText("Nivel actual: "+ Integer.toString(currentlevel));
           if(pizarraActual.getNivelCerrado()==true){
                btnClose.setDisable(true);
            }
            else{
                btnClose.setDisable(false);
            }
        });

        Button btnDawn = new Button();
        btnDawn.setText("Bajar Nivel");
        btnDawn.setDisable(true);

        btnDawn.setOnAction((ActionEvent event) ->
        {
           int currentlevel=this.pizarraActual.getCurrentlevel();
           
           if (tipoCalculadora==0)
                this.pizarraActual.botonBajar();
            else {
                dibujaOtrasBases(true, false);
                this.pizarraBinaria.botonBajar();
                this.pizarraHexa.botonBajar();
                this.pizarraCientifica.botonBajar();
            }
           
           labelCurrentLevel.setText("Nivel actual: "+ Integer.toString(currentlevel));
           if(pizarraActual.getNivelCerrado()==true){
                btnClose.setDisable(true);
            }
            else{
                btnClose.setDisable(false);
            }
        });

      btnDawn.setMaxWidth(Double.MAX_VALUE);
      HBox.setHgrow(btnDawn, Priority.ALWAYS);
      
      btnClose.setMaxWidth(Double.MAX_VALUE);
      HBox.setHgrow(btnClose, Priority.ALWAYS);
      
      btnUp.setMaxWidth(Double.MAX_VALUE);
      HBox.setHgrow(btnUp, Priority.ALWAYS);
      
      div.getChildren().addAll(btnDawn,btnClose,btnUp);
      simbolos4.getChildren().addAll(div,buttonEquals);
       
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
       pane = new BorderPane();
       box.setManaged(true);    
       //pane.setCenter(box);
       mainPane=new ScrollPane(this.pizarraBasica.getGrupoPantalla());
       mainPaneCientifica=new ScrollPane(this.pizarraCientifica.getGrupoPantalla());
       mainPaneBinario=new ScrollPane(this.pizarraBinaria.getGrupoPantalla());
       mainPaneHexa=new ScrollPane(this.pizarraHexa.getGrupoPantalla());
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
            int currentlevel=this.pizarraActual.getLevelActual();
            if (tipoCalculadora==0)
                this.pizarraActual.division();
            else {
                dibujaOtrasBases(true, false);
                this.pizarraCientifica.division();
                this.pizarraBinaria.division();
                this.pizarraHexa.division();
                if (currentlevel<=0) {
                    this.pizarraCientifica.botonSubir();
                    this.pizarraCientifica.botonSubir();
                    this.pizarraBinaria.botonSubir();
                    this.pizarraBinaria.botonSubir();
                    this.pizarraHexa.botonSubir();
                    this.pizarraHexa.botonSubir();
                }
                else {
                    this.pizarraCientifica.botonBajar();
                    this.pizarraCientifica.botonBajar();
                    this.pizarraBinaria.botonBajar();
                    this.pizarraBinaria.botonBajar();
                    this.pizarraHexa.botonBajar();
                    this.pizarraHexa.botonBajar();
                }
            }
            labelCurrentLevel.setText("Nivel actual: "+ Integer.toString(currentlevel));
            
            
           if (currentlevel==0) {
                btnDawn.setDisable(false);
                btnUp.setDisable(false);
                btnClose.setDisable(false);
           }
           if(currentlevel<=0){
                btnUp.fire();
                btnUp.fire();
                
            }
            else{
                btnDawn.fire();
                btnDawn.fire();
            }
        });
       
       
       btnClose.setOnAction((ActionEvent event) ->
        {
            if (tipoCalculadora==0)
                this.pizarraActual.botonCerrar();
            else {
                dibujaOtrasBases(true, false);
                this.pizarraBinaria.botonCerrar();
                this.pizarraHexa.botonCerrar();
                this.pizarraCientifica.botonCerrar();
            }

           if (this.pizarraActual.getNivelCerrado()) {
               btnClose.setDisable(true);
           }
           
           if (this.pizarraActual.getLevelActual()==0) {
               btnDawn.setDisable(true);
               btnUp.setDisable(true);
               btnClose.setDisable(true);
           }
               
        });
        
       
       
       buttonPor.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra("*", true);
        });
       
       buttonPar1.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra("(", true);
        });
       
       buttonPar2.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra(")", true);
        });

       buttonMas.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra("+", true);
        });
       
       buttonMenos.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra("-", true);
        });
       
       button0.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra("0",true);
        });
       
       button1.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra("1", true);
        });
       
       button2.setOnAction((ActionEvent event) ->
        { 
            dibujaEnPizarra("2", true);
        });
       
       button3.setOnAction((ActionEvent event) ->
       { 
            dibujaEnPizarra("3", true);
        });
       
       button4.setOnAction((ActionEvent event) ->
       {
            dibujaEnPizarra("4", true);   
        });
       
       button5.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("5", true);   
        });
       
       button6.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("6", true);
         });
       
       button7.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("7", true);
         });
       
       button8.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("8", true);
         });
       
       button9.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("9", true);
         });
       
         buttonCos.setOnAction((ActionEvent event) ->
           
        {
         if (tipoCalculadora==0)
            this.pizarraActual.addToScreenTrigonometric("cos","(",this.pizarraActual.getLevelActual(),true, true);
         
         else {
             dibujaOtrasBases(true,false);
             
             this.pizarraCientifica.addToScreenTrigonometric("cos","(",this.pizarraActual.getLevelActual(),true, true);
             this.pizarraBinaria.addToScreenTrigonometric("cos","(",this.pizarraActual.getLevelActual(),true, true);
             this.pizarraHexa.addToScreenTrigonometric("cos","(",this.pizarraActual.getLevelActual(),true, true);
            }
        });
       
       buttonSen.setOnAction((ActionEvent event) ->
           
        {
            if (tipoCalculadora==0)
            this.pizarraActual.addToScreenTrigonometric("cos","(",this.pizarraActual.getLevelActual(),true, true);
         
         else {
             dibujaOtrasBases(true,false);
             
             this.pizarraCientifica.addToScreenTrigonometric("sen","(",this.pizarraActual.getLevelActual(),true, true);
             this.pizarraBinaria.addToScreenTrigonometric("sen","(",this.pizarraActual.getLevelActual(),true, true);
             this.pizarraHexa.addToScreenTrigonometric("sen","(",this.pizarraActual.getLevelActual(),true, true);
            }   
        });
       
       buttonTan.setOnAction((ActionEvent event) ->
           
        {
            if (tipoCalculadora==0)
            this.pizarraActual.addToScreenTrigonometric("tan","(",this.pizarraActual.getLevelActual(),true, true);
         
         else {
             dibujaOtrasBases(true,false);
             
             this.pizarraCientifica.addToScreenTrigonometric("tan","(",this.pizarraActual.getLevelActual(),true, true);
             this.pizarraBinaria.addToScreenTrigonometric("tan","(",this.pizarraActual.getLevelActual(),true, true);
             this.pizarraHexa.addToScreenTrigonometric("tan","(",this.pizarraActual.getLevelActual(),true, true);
            }  
        });
       
       buttonGorrito.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("^",  true);
        });
       
       buttonFactorial.setOnAction((ActionEvent event) ->
           
        {
          dibujaEnPizarra("!", true);
        });
       
       buttonGrados.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("º", true);
        });
       
       buttonsqrt.setOnAction((ActionEvent event) ->
           
        {
            dibujaEnPizarra("√", true);
            dibujaEnPizarra("(", true);
        });
       //Este botón quita o pone los Puntos de Control.
       //Va cambiando el texto del botón según el estado de puntosVisibles.
       ocultar.setOnAction((ActionEvent event) ->
        { 
            if (puntosVisibles) {
                this.pizarraActual.ocultaPuntosVisibles();
                ocultar.setDisable(true);
                mostrar.setDisable(false);
                this.puntosVisibles=false;
            }
        });
               
        mostrar.setOnAction((ActionEvent event) ->
        { 
            if(puntosVisibles==false) {
                this.pizarraActual.muestraPuntosVisibles();
                ocultar.setDisable(false);
                mostrar.setDisable(true);
                this.puntosVisibles=true;
            }
            
        });
       //-------------------------------------//
       
        buttonEliminar.setOnAction((ActionEvent event) ->
        {
            reset();
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
       buttonEquals.setOnAction((ActionEvent event) ->
        {
            try {
                obtenerResultado();
            } catch (Exception e) {
                System.out.println("error en la formula ");
                popupError();
            }
        });
       //-------------------------------//
        btnA.setOnAction((ActionEvent event) ->
        {
            this.pizarraActual.addToScreen("A",this.pizarraActual.getCurrentlevel(),true,0); 
        });
       btnB.setOnAction((ActionEvent event) ->
        {
            this.pizarraActual.addToScreen("B", this.pizarraActual.getCurrentlevel(), true,0); 
        });
       btnC.setOnAction((ActionEvent event) ->
        {
            this.pizarraActual.addToScreen("C", this.pizarraActual.getCurrentlevel(), true,0); 
        });
       btnD.setOnAction((ActionEvent event) ->
        {
            this.pizarraActual.addToScreen("D", this.pizarraActual.getCurrentlevel(), true,0); 
        });
       btnE.setOnAction((ActionEvent event) ->
        {
            this.pizarraActual.addToScreen("E", this.pizarraActual.getCurrentlevel(), true,0); 
        });
       btnF.setOnAction((ActionEvent event) ->
        {
            this.pizarraActual.addToScreen("F", this.pizarraActual.getCurrentlevel(), true,0); 
        });
       //-------------------------------------//
       
       Slider sliderSubScene = new Slider();
       sliderSubScene.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene.setMin(-10000);
       sliderSubScene.valueProperty().bindBidirectional(this.pizarraActual.getGrupoPantalla().translateXProperty());//se le da el recorrido al Slider en este caso es el largo del box
       //pane.setBottom(sliderSubScene);
       
       Slider sliderSubScene2 = new Slider();
       sliderSubScene2.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene2.setMin(-10000);
       sliderSubScene2.setOrientation(Orientation.VERTICAL);
       sliderSubScene2.valueProperty().bindBidirectional(this.pizarraActual.getGrupoPantalla().translateYProperty());//se le da el recorrido al Slider en este caso es el largo del box
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
       
       textBox.setContent(textoGrup);
       textoGrup.getChildren().add(texto);
       textBox.setMinHeight(50);
       texto.setMaxWidth(Double.MAX_VALUE);
       
       texto.setAlignment(Pos.CENTER_LEFT);
       bottom.getChildren().addAll(contenerdorPrincipal,textBox,labelCurrentLevel);
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
    
    //** aqui va todo lo de los cambios de tamaño **//
    
    /*
    En este metodo se asignana el tamaño de los dibujos en la pantalla
    */
    private void SetSize(String toString) {
        switch (toString){
            
            case "100%":
                tamanoPizarra=0.5;
                setScaleNumbers(tamanoPizarra);
                cien.setDisable(true);
                cincuenta.setDisable(false);
                docientos.setDisable(false);    
            break;
            
            case "50%":
                tamanoPizarra=0.25;
                setScaleNumbers(tamanoPizarra);
                cien.setDisable(false);
                cincuenta.setDisable(true);
                docientos.setDisable(false);
                
            break;
                
            case "200%":
                tamanoPizarra=1;
                setScaleNumbers(tamanoPizarra);
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
            primaryStage.setTitle("Kancer de Phiel (Modo 100tifk0)");
            this.textoGrup.getChildren().clear();
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
                dibujaOtrasBases(true, false);
                
                basica.setDisable(false);
                tipoBinario.setDisable(false);
                tipoDecimal.setDisable(true);
                tipoHexadec.setDisable(false);
                tipoCalculadora=1;
                baseCalculadora=0;
                pizarraActual=pizarraCientifica;
                actualizaTexto();
                pane.setCenter(mainPaneCientifica);
                traspasaPuntosVisibles();
                setScaleNumbers(tamanoPizarra);
                
                
                break;
                
            case "Tipo Binario":
                
                contenerdorPrincipal.getChildren().removeAll(contenedorNumeros,contenedorSimbolos);
                contenerdorPrincipal.getChildren().addAll(binario,contenedorSimbolos);
                if (baseCalculadora==2) {
                    contenedorNumeros.getChildren().removeAll(hexColum1,hexColum2);
                }
                dibujaOtrasBases(true, false);
                basica.setDisable(false);
                tipoBinario.setDisable(true);
                tipoDecimal.setDisable(false);
                tipoHexadec.setDisable(false);
                tipoCalculadora=1;
                baseCalculadora=1;
                pizarraActual=pizarraBinaria;
                actualizaTexto();
                pane.setCenter(mainPaneBinario);
                setScaleNumbers(tamanoPizarra);
                
                traspasaPuntosVisibles();
                
                break;
                
            case "Tipo Hexadecimal":
                
                if(baseCalculadora==1){
                    contenerdorPrincipal.getChildren().removeAll(binario,contenedorSimbolos);
                    contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
                }
                dibujaOtrasBases(true, false);
                contenedorNumeros.getChildren().addAll(hexColum1,hexColum2);
                basica.setDisable(false);
                tipoBinario.setDisable(false);
                tipoDecimal.setDisable(false);
                tipoHexadec.setDisable(true);
                tipoCalculadora=1;
                baseCalculadora=2;
                pizarraActual=pizarraHexa;
                pane.setCenter(mainPaneHexa);
                actualizaTexto();
                traspasaPuntosVisibles();
                setScaleNumbers(tamanoPizarra);
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
                dibujaOtrasBases(true,false);
                basica.setDisable(true);
                tipoBinario.setDisable(false);
                tipoDecimal.setDisable(false);
                tipoCalculadora=0;
                baseCalculadora=0;
                pizarraActual=pizarraBasica;
                actualizaTexto();
                pane.setCenter(mainPane);
                traspasaPuntosVisibles();
                setScaleNumbers(tamanoPizarra);
                
                
                
            break;
        }
    }

 
    
    private void setScaleNumbers(double size){
        this.pizarraActual.cambiarTamanoElementos(size);
    }
    
    private void reset(){
        this.pizarraBasica.reiniciar();
        this.pizarraBinaria.reiniciar();
        this.pizarraCientifica.reiniciar();
        this.pizarraHexa.reiniciar();
        //tamanoPizarra=0.5;
        //setScaleNumbers(tamanoPizarra);
        actualizaTexto();
    }

    private int getCurrentLevel(){
        return this.pizarraActual.getCurrentlevel();
    }
    
    private void setCurrentLevel(int level){
        this.pizarraActual.setCurrentlevel(level);
    }
    
    private void dibujaEnPizarra(String elemento, boolean seVe){
        
        this.pizarraActual.addToScreen(elemento, this.pizarraActual.getCurrentlevel(),seVe,0);
        
        if ("symbol".equals(this.pizarraActual.getEnPantalla().get(this.pizarraActual.getEnPantalla().size()-1).getType()) && tipoCalculadora==1) {
            dibujaOtrasBases(seVe, true);
        }

        actualizaTexto();
    }
    
    private void actualizaTexto(){
        textoGrup.getChildren().setAll(this.pizarraActual.getTexto());
        labelCurrentLevel.setText("Nivel actual: "+ Integer.toString(this.pizarraActual.getCurrentlevel()));
    }
    
    private void dibujaOtrasBases(boolean seVe, boolean seDibujaSimbolo){
        String numeroBinarioADibujar=this.pizarraActual.numeroAString("a Binario");
        String numeroHexaADibujar=this.pizarraActual.numeroAString("a Hexa");
        String numeroDecimalADibujar=this.pizarraActual.numeroAString("a Decimal");
        
        if ("binaria".equals(this.pizarraActual.getTipoDePizarra())) {
            this.pizarraHexa.escribeNumeros(numeroHexaADibujar);
            this.pizarraCientifica.escribeNumeros(numeroDecimalADibujar);
            if (seDibujaSimbolo) {
                this.pizarraHexa.addToScreen(this.pizarraActual.getEnPantalla().get(this.pizarraActual.getEnPantalla().size()-1).getID(), this.pizarraActual.getCurrentlevel(), seVe,0);
                this.pizarraCientifica.addToScreen(this.pizarraActual.getEnPantalla().get(this.pizarraActual.getEnPantalla().size()-1).getID(), this.pizarraActual.getCurrentlevel(), seVe,0);
            }
        }
        
        else if ("hexa".equals(this.pizarraActual.getTipoDePizarra())) {
            this.pizarraBinaria.escribeNumeros(numeroBinarioADibujar);
            this.pizarraCientifica.escribeNumeros(numeroDecimalADibujar);
            if (seDibujaSimbolo) {
                this.pizarraBinaria.addToScreen(this.pizarraActual.getEnPantalla().get(this.pizarraActual.getEnPantalla().size()-1).getID(), this.pizarraActual.getCurrentlevel(), seVe,0);
                this.pizarraCientifica.addToScreen(this.pizarraActual.getEnPantalla().get(this.pizarraActual.getEnPantalla().size()-1).getID(), this.pizarraActual.getCurrentlevel(), seVe,0);
            }
        }
        
        else if ("cientifica".equals(this.pizarraActual.getTipoDePizarra())) {
            this.pizarraBinaria.escribeNumeros(numeroBinarioADibujar);
            this.pizarraHexa.escribeNumeros(numeroHexaADibujar);
            if (seDibujaSimbolo){ 
                this.pizarraBinaria.addToScreen(this.pizarraActual.getEnPantalla().get(this.pizarraActual.getEnPantalla().size()-1).getID(), this.pizarraActual.getCurrentlevel(), seVe,0);
                this.pizarraHexa.addToScreen(this.pizarraActual.getEnPantalla().get(this.pizarraActual.getEnPantalla().size()-1).getID(), this.pizarraActual.getCurrentlevel(), seVe,0);
            }
        }

    }
    
    private void traspasaPuntosVisibles(){
        if (puntosVisibles)
                this.pizarraActual.muestraPuntosVisibles();
            else
                this.pizarraActual.ocultaPuntosVisibles();
    }
    
    private void obtenerResultado() throws ScriptException{
        
        
        dibujaOtrasBases(true,false);
        Label textoACalcular;
        //Aquí obtienes el texto de la Pizarra Decimal, sin importar en cual se esté escribiendo.
        if(this.pizarraActual.equals(this.pizarraBasica))
        {
            String texto=this.pizarraBasica.getStringTexto();
            texto=this.calculationCore.calculate(texto);
            System.out.println("resultado = "+texto);
            popup(texto);
        }
        else{
            String texto=this.pizarraCientifica.getStringTexto();
            texto=this.calculationCore.calculate(texto);
            System.out.println("resultado = "+texto);
            popup(texto);
        }
        
       // System.out.println(textoACalcular);
        
    }
    private void popup(String text){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Resultado");
            alert.setHeaderText(null);
            alert.setContentText("El resultado es:"+"\n"+text);
            alert.setGraphic(null);
            alert.showAndWait();
        }

    private void popupError() {
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error en la formula");
        alert.setContentText("Por favor revise y vuelva a escribir la formula");

        alert.showAndWait();
    }
}
    