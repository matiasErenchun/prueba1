
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private int divideStatus = 0; //Variable que sirve para saber en qué estado está una división.
    //divideStatus = 1; Significa que se ha iniciado una nueva división y se está dibujando en la parte de arriba de esta.
    //divideStatus = 2; Significa que se está dibujando en la parte inferior de uan división.
    //divideStatus = 0; Significa que no hay división activa.
    private int divisiones = 0; //Contador de Divisiones. Utilizado para tener control sobre el crecimiento de la línea de división.
    private List<String> decimal;
    //contenedor de los simbolos
    HBox cajaDeSimbolos = new HBox();
    VBox simbolos = new VBox();
    VBox trigonometria = new VBox();
    HBox contenedorNumeros = new HBox();
    HBox binario= new HBox();
    HBox contenerdorPrincipal = new HBox();         
    Stage primaryStage=new Stage();
    VBox contenedorSimbolos = new VBox();
    Button bases=new Button("Base");

    public Pantalla() {
        this.enPantalla = new ArrayList<NumerosYSimbolos>();
        this.decimal = new ArrayList<>();
        inicio();
    }

    public void inicio(){
        
        
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
       Button buttonBajar = new Button("Bajar");
       button1.setText(" 1 ");//contenido del boton 
       button1.setMaxWidth(Double.MAX_VALUE);
      
       //HBox.setMargin(button1, new Insets(0,0,0,0));//margen entre objetos en este caso se dejo 5 a la  derecha 
       HBox.setHgrow(button7, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button4, Priority.ALWAYS);
       HBox.setHgrow(button1, Priority.ALWAYS);
       HBox.setHgrow(buttonBajar, Priority.ALWAYS);
       HBox.setMargin(button7, javafx.geometry.Insets.EMPTY);
       button7.setMaxWidth(Double.MAX_VALUE);
       button4.setMaxWidth(Double.MAX_VALUE);
       buttonBajar.setMaxWidth(Double.MAX_VALUE);
       numerosColumna1.getChildren().addAll(button7, button4,button1,buttonBajar);
       
       
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
      
       simbolos4.getChildren().addAll(button);
       
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
 
       
       
       Button buttonBajarBin = new Button("Bajar");
       buttonBajarBin.setMaxWidth(Double.MAX_VALUE);
       HBox.setHgrow(buttonBajarBin, Priority.ALWAYS);
       
       Button buttonEliminarBin = new Button(" CE ");
       HBox.setHgrow(buttonEliminarBin, Priority.ALWAYS);
       buttonEliminarBin.setMaxWidth(Double.MAX_VALUE);
       
       binarioColum1.getChildren().addAll(button0Bin,buttonBajarBin);
       binarioColum2.getChildren().addAll(button1Bin,buttonEliminarBin);
       binario.getChildren().addAll(binarioColum1,binarioColum2);
       //*******fin numeros***************
       
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
//       mainPane.getm
       pane.setCenter(mainPane);
       BorderPane.setAlignment(mainPane, Pos.CENTER);
       
       //** comboboxes **//
       
       HBox boxes=new HBox();
            
            ComboBox selectSize=new ComboBox();
                selectSize.getItems().addAll(
                    "50%",
                    "100%",
                    "200%"
                );
            selectSize.getSelectionModel().select("100%");
        
            ComboBox typeKeyboard =new ComboBox();
                typeKeyboard.getItems().addAll(
                    "Basica",
                    "Cientifica"
                );
            typeKeyboard.getSelectionModel().selectFirst();
            
            ComboBox base =new ComboBox();
                base.getItems().addAll(
                    "Decimal",
                    "Binario"
                );
            base.getSelectionModel().selectFirst();
            base.setVisible(false);
        
        Button zoom=new Button("Zoom");
        Button tipo=new Button("Tipo");
        bases.setVisible(false);
        
        zoom.setDisable(true);
        zoom.setOpacity(1);
        tipo.setDisable(true);
        tipo.setOpacity(1);
        bases.setDisable(true);
        bases.setOpacity(1);
        
            
        boxes.getChildren().addAll(zoom,selectSize,tipo,typeKeyboard,bases,base);
        
        Button buttonNn2 = new Button(" Mostrar Puntos de Control ");
        HBox.setHgrow(buttonNn2, Priority.ALWAYS);
        buttonNn2.setMaxWidth(Double.MAX_VALUE);
        boxes.getChildren().add(buttonNn2);
        
       pane.setTop(boxes);
       
       selectSize.setOnAction(e -> SetSize(selectSize.getValue().toString()));
       typeKeyboard.setOnAction(e -> SetTypeKeyboard(typeKeyboard.getValue().toString(),base));
       base.setOnAction(e -> SetBase(base.getValue().toString()));
       
       //SetBase(base.getValue().toString(); Antes
       //Botones y sus funcionalidades.
       buttonDiv.setOnAction((ActionEvent event) ->
        {
            espacioNumero+=90;
            rePaintDivide();
            double n =0;
            if (divideStatus==0 || divideStatus==1){ //En caso que no haya división o que se esté en la parte superior de una, se añade una nueva división.
                NumerosYSimbolos division = new NumerosYSimbolos(n, espacioNumero-40,espacioSuperior, puntosVisibles);
                divisiones+=1;
                centro.getChildren().add(division.division(1, divisiones));
                enPantalla.add(division);
                divideStatus=1;
                espacioSuperior-=140;
            }
            else if (divideStatus==2) { //En caso que esté en la parte de abajo de una división.
                if (divisiones==0) { //Si no hay más divisiones, vuelve a escribir de forma normal.
                    divideStatus=0;
                    contador(false);
                }
                else { //Si hay más divisiones, vuelve a la parte superior de la última división.
                    divideStatus=1;
                    contador(false);
                }
                //Busca la última división escrita, lo establcece como división cerrada.
                for (int x = enPantalla.size()-1; x>=0; x--) {
                    if (enPantalla.get(x).getID() == "/") {
                        enPantalla.get(x).getNumDivision();
                        if (enPantalla.get(x).getNumDivision()==divisiones) {
                            enPantalla.get(x).setID("%");
                        }
                    }
                }
                rePaintDivide();
                divisiones-=1;
                buttonDiv.setText("/");
                
            }
            

            
        });
       
       
       buttonPor.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos multiplicacion = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(multiplicacion.multiplicacion());
            contador(false);
            enPantalla.add(multiplicacion);
            tryDivide();
        });
       
       buttonPar1.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos parentesis1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(parentesis1.parentesis1());
            contador(false);
            enPantalla.add(parentesis1);
            tryDivide();
            
            
        });
       
       buttonPar2.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos parentesis2 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(parentesis2.parentesis2());
            contador(false);
            enPantalla.add(parentesis2);
            tryDivide();
            
        });

       buttonMas.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos suma = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(suma.suma());
            contador(false);
            enPantalla.add(suma);
            tryDivide();
            
        });
       
       buttonMenos.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos resta = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(resta.resta());
            contador(false);
            enPantalla.add(resta);
            tryDivide();
        });
       
       button0.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero0 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero0.numero0());
            contador(false);
            enPantalla.add(numero0);
            tryDivide();
        });
       
       button1.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero1.numero1());
            contador(false);
            enPantalla.add(numero1);
            tryDivide();
            
        });
       
       button2.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero2 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero2.numero2());
            contador(false);
            enPantalla.add(numero2);
            tryDivide();
            
        });
       
       button3.setOnAction((ActionEvent event) ->
       { 
            double n =0;
            NumerosYSimbolos numero3 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero3.numero3());
            contador(false);
            enPantalla.add(numero3);
            tryDivide();
            
        });
       
       button4.setOnAction((ActionEvent event) ->
       {
            double n =0;
            NumerosYSimbolos numero4 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero4.numero4());
            contador(false);
            enPantalla.add(numero4);
            tryDivide();
                
               
        });
       
       button5.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos numero5 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero5.numero5());
            contador(false);
            enPantalla.add(numero5);
            tryDivide();
                
               
        });
       
       button6.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero6 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero6.numero6());
             contador(false);
             enPantalla.add(numero6);
             tryDivide();


         });
       
       button7.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero7 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero7.numero7());
             contador(false);
             enPantalla.add(numero7);
             tryDivide();


         });
       
       button8.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero8 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero8.numero8());
             contador(false);
             enPantalla.add(numero8);
             tryDivide();


         });
       
       button9.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero9 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero9.numero9());
             contador(false);
             enPantalla.add(numero9);

             tryDivide();


         });
       
         buttonCos.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos cos = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(cos.cos());
            contador(true);
            NumerosYSimbolos paren1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(paren1.parentesis1());
            contador(false);
            enPantalla.add(cos);
            enPantalla.add(paren1);
            tryDivide();
                
               
        });
                
       buttonSen.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos sen = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(sen.sen());
            contador(true);
            NumerosYSimbolos paren1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(paren1.parentesis1());
            contador(false);
            enPantalla.add(sen);
            enPantalla.add(paren1);
            tryDivide();
                
               
        });
       
       buttonTan.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos tan = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(tan.tan());
            contador(true);
            NumerosYSimbolos paren1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(paren1.parentesis1());
            contador(false);
            enPantalla.add(tan);
            enPantalla.add(paren1);
            tryDivide();
                
               
        });
       
       buttonGorrito.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos gorrito = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(gorrito.dibujarElevado());
            contador(false);
            enPantalla.add(gorrito);
            tryDivide();
                
               
        });
       
       buttonFactorial.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos factorial = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(factorial.dibujarFactorial());
            contador(false);
            enPantalla.add(factorial);
            tryDivide();
                
               
        });
       
       //Este botón quita o pone los Puntos de Control.
       //Va cambiando el texto del botón según el estado de puntosVisibles.
       buttonNn2.setOnAction((ActionEvent event) ->
        { 
            if (puntosVisibles==true) {
                puntosVisibles=false;
                for (int x=0; x<enPantalla.size(); x++) {
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                }
                buttonNn2.setText(" Mostrar Puntos de Control ");
            }
            else {
                puntosVisibles=true;
                for (int x=0; x<enPantalla.size(); x++)
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                buttonNn2.setText("Esconder Puntos de Control");
            }
        });
       
       //Este botón elimina el último número escrito (Beta, falla con divisiones).
       /*buttonEliminar.setOnAction((ActionEvent event) ->
        {
            if (enPantalla.size()>0) {
                centro.getChildren().remove(centro.getChildren().size()-1);
                enPantalla.remove(centro.getChildren().size()-1);
                espacioNumero-=90;
            }   
        });*/
        buttonEliminar.setOnAction((ActionEvent event) ->
        {
            reinicia();
            buttonDiv.setText("/");
            /*puntosVisibles=true;
                for (int x=0; x<enPantalla.size(); x++)
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                buttonNn2.setText("Esconder Puntos de Control");*/
        });
        
       
       //Este botón, en caso de estar arriba de una división, hace que se dibujen números o símbolos abajo de esta.
       buttonBajar.setOnAction((ActionEvent event) ->
        {
            if (divideStatus==1) {
                divideStatus=2;
                espacioSuperior+=140;
                buttonDiv.setText("Cierra División");
            }
        });
       
        button0Bin.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero0 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero0.numero0());
            contador(false);
            enPantalla.add(numero0);
            tryDivide();
        });
       
       button1Bin.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero1.numero1());
            contador(false);
            enPantalla.add(numero1);
            tryDivide();
            
        });
       
       buttonEliminarBin.setOnAction((ActionEvent event) ->
        {
            reinicia();
            buttonDiv.setText("/");
        });
       
       buttonBajarBin.setOnAction((ActionEvent event) ->
        {
            if (divideStatus==1) {
                divideStatus=2;
                espacioSuperior+=140;
                buttonDiv.setText("Cierra División");
            }
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
       BpanePrueba.setBottom(contenerdorPrincipal);
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
    
    //Método que aumenta en X para dejar espacio a los números.
    private void contador(boolean saltaTres){
        if (saltaTres==false)
            espacioNumero+=90;
        else
            espacioNumero+=270;
        
        //contador+=200;
        /*if(contador>14000){
            espacioSuperior+=120;
            contador=0;
            espacioNumero=0;
        }*/
    }
    /*Este método busca la úlima división escrita guiándose por su ID, obtiene sus datos de ubicación y cantidad
    de simbolos escritos en esta, entonces elimina la actual, para dar paso a una nueva división la cual aumenta en tamaño con la variable
    aumountOfSymbolsDivide.
    */
    private void rePaintDivide(){
        double espacioDivision;
        double superiorDivision;
        double amountOfSymbols;
        int x = enPantalla.size()-1;
        int divisionesActual;
        while (enPantalla.size()>x && x>=0) {
            //Se verifica que el elemento corresponda a una división abierta.
            if (enPantalla.get(x).getID()=="/") {
                //Se obtienen las coordenadas iniciales de la división.
                espacioDivision= enPantalla.get(x).getxPoint()-200;
                superiorDivision = enPantalla.get(x).getyPoint()-80;
                //Se aumenta en 1 la de elementos en la división.
                amountOfSymbols = enPantalla.get(x).getAmountOfSymbolsDivide()+1;
                divisionesActual = enPantalla.get(x).getNumDivision();
                //Se elimina la división actual.
                enPantalla.remove(x);
                centro.getChildren().remove(x+1);
                //Se crea una nueva división que abarque más elementos.
                NumerosYSimbolos division = new NumerosYSimbolos(0, espacioDivision,superiorDivision, puntosVisibles);
                centro.getChildren().add(division.division(amountOfSymbols, divisionesActual));
                enPantalla.add(division);
            }
            x--;
        }
    }
    
    //Este método verifica si acutalmente hay una división activa o no, para entonces dar paso a rePaintDivide o no.
    private void tryDivide(){
        if (divideStatus==0)
            return;
        if (divideStatus==1)
            rePaintDivide();
        if (divideStatus==2)
            rePaintDivide();
    }

    
    //** aqui va todo lo de los cambios de tamaño **//
    private void SetSize(String toString) {
        switch (toString){
            
            case "100%":
                setScaleNumbers(0.5);
                           
            break;
            
            case "50%":
                setScaleNumbers(0.25);
                
            break;
                
            case "200%":
                setScaleNumbers(1);
                
            break;
        }
    }
    
    //** aqui va todo lo de los cambios de base **//
    private void SetBase(String toString) {
        
        switch(toString){
            
            case "Decimal":
                contenerdorPrincipal.getChildren().removeAll(binario,contenedorSimbolos);
                contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
                break;
                
            case "Binario":
                contenerdorPrincipal.getChildren().removeAll(contenedorNumeros,contenedorSimbolos);
                contenerdorPrincipal.getChildren().addAll(binario,contenedorSimbolos);
                break;
        }
        
    }

    //** aqui va todo lo de los cambios de teclado **//
    private void SetTypeKeyboard(String toString,ComboBox base) {
        switch(toString){
            case "Basica":
                base.setVisible(false);
                base.getSelectionModel().selectFirst();
                cajaDeSimbolos.getChildren().removeAll(trigonometria, simbolos);
                primaryStage.setTitle("Cancer de Piel");
                bases.setVisible(false);
                reinicia();
            break;
            
            case "Cientifica":
                base.setVisible(true);
                cajaDeSimbolos.getChildren().addAll(trigonometria, simbolos);
                primaryStage.setTitle("Cancer de Piel 100tifik0");
                bases.setVisible(true);
                reinicia();
                
            break;
        }
    }
    
    private void toBinary(){
        NumerosYSimbolos cos = new NumerosYSimbolos(0, espacioNumero,espacioSuperior, puntosVisibles);
        enPantalla.add(cos); 
        for (int x=0; x<enPantalla.size(); x++){
            if ("number".equals(enPantalla.get(x).getType())){
                decimal.add(enPantalla.get(x).getID());
            }
            
            else{
                convertertoBinary();
                
            }
        }
        enPantalla.remove(cos);
    }
    
    private void convertertoBinary(){
        
        Integer numeroLista = 0;
        
        for (int x=0; x<decimal.size(); x++){
            numeroLista=numeroLista*10;
            numeroLista += Integer.parseInt(decimal.get(x));
        }
        String base2="";
        while(numeroLista>0) {
            base2=(numeroLista%2)+base2;
            numeroLista/=2;  
        }
        
        decimal.clear();
        
        System.out.println(base2);
        /*char[] numeros = base2.toCharArray();
        
        for (int x=0;x<numeros.length;x++){
            decimal.add(String.valueOf(numeros[x]));
        }
        
        System.out.println(decimal + "hola");*/
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
            divideStatus=0;
            divisiones=0;
            espacioNumero=0;
            espacioSuperior=0;
    }
}
    