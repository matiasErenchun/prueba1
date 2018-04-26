/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 *
 * @author Matias.Erenchun
 */
public class EjemplosFX extends Application {
    double espacioNumero=0;
    double espacioSuperior=0;
    int contador=0;
    
    @Override
    public void start(Stage primaryStage) {
        
       HBox contenerdorPrincipal = new HBox();
       
       //*******inicio numeros***************
       HBox contenedorNumeros = new HBox();
       VBox numerosColumna1 = new VBox();//creamos el Hbox
       numerosColumna1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button7 = new Button(" 7 ");
       Button button4 = new Button(" 4 ");// en este caso el contenido se entrega en el contructor
       Button button1 = new Button();
       Button buttonSubir = new Button("subir");
       button1.setText(" 1 ");//contenido del boton 
       button1.setMaxWidth(Double.MAX_VALUE);
       button1.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               System.out.println("hola mis 9 weros ");// accion que se ejecutara al presionar el boton 
           }

       });
       //HBox.setMargin(button1, new Insets(0,0,0,0));//margen entre objetos en este caso se dejo 5 a la  derecha 
       HBox.setHgrow(button7, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button4, Priority.ALWAYS);
       HBox.setHgrow(button1, Priority.ALWAYS);
       HBox.setHgrow(buttonSubir, Priority.ALWAYS);
       HBox.setMargin(button7, javafx.geometry.Insets.EMPTY);
       button7.setMaxWidth(Double.MAX_VALUE);
       button4.setMaxWidth(Double.MAX_VALUE);
       buttonSubir.setMaxWidth(Double.MAX_VALUE);
       numerosColumna1.getChildren().addAll(button7, button4,button1,buttonSubir);
       
       
       //------------------------------//
       
       VBox numerosColumna2 = new VBox();
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
       
       VBox numerosColumna3 = new VBox();
       numerosColumna3.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button9 = new Button(" 9 ");
       Button button6 = new Button(" 6 ");// en este caso el contenido se entrega en el contructor
       Button button3 = new Button(" 3 ");
       Button buttonEliminar = new Button(" Eliminar");
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
       
       //------------------------------//
       
       contenedorNumeros.getChildren().addAll(numerosColumna1,numerosColumna2,numerosColumna3);
       
       //*******fin numeros***************
       
       //*******inicio simbolos***********
       
       VBox contenedorSimbolos = new VBox();
       
       //------------------------------//
       //contenedor de los simbolos
         HBox cajaDeSimbolos = new HBox();
        
       //------------------------------//
       
       VBox simbolos1 = new VBox();
       simbolos1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonpar1 = new Button(" ( ");
       Button buttonMas = new Button(" + ");// en este caso el contenido se entrega en el contructor
       Button buttonPor = new Button(" * ");
       HBox.setHgrow(buttonpar1, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonMas, Priority.ALWAYS);
       HBox.setHgrow(buttonPor, Priority.ALWAYS);
       buttonpar1.setMaxWidth(Double.MAX_VALUE);
       buttonMas.setMaxWidth(Double.MAX_VALUE);
       buttonPor.setMaxWidth(Double.MAX_VALUE);
      
       simbolos1.getChildren().addAll(buttonpar1, buttonMas,buttonPor);
       
       //-------------------------------------//
       
       VBox simbolos2 = new VBox();
       simbolos2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonPar2= new Button(" ) ");
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
      
       //-------------------------------------//
       
        //------------------------------//
       
       HBox simbolos4 = new HBox();
       simbolos4.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonNn2 = new Button(" puntos de control :ver/no ver ");
       buttonNn2.setDisable(true);
       //Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonNn2, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       //HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       buttonNn2.setMaxWidth(Double.MAX_VALUE);
       //buttonDiv.setMaxWidth(Double.MAX_VALUE);
      
       simbolos4.getChildren().addAll(buttonNn2);
       
       //-------------------------------------//
       
       
       contenedorSimbolos.getChildren().addAll(cajaDeSimbolos,simbolos4);
       
       //*******fin numeros***************
       
       //*******inicio Esena de dibujo***********
       Box box = new Box(100,100,100);
       BorderPane pane = new BorderPane();
       box.setManaged(true);
       //pane.setCenter(box);
       Path center = new Path();
       center.setManaged(false);
       Group centro=new Group(center);
       pane.setCenter(centro);
       button0.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            Numero0 numero0=new Numero0(n, espacioNumero,espacioSuperior);
            centro.getChildren().add(numero0.start(center));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
       
       button4.setOnAction((ActionEvent event) ->
           
           {
               double n =0;
                Numero4 numero4=new Numero4(n, espacioNumero,espacioSuperior);
                 centro.getChildren().add(numero4.start(center));
                //contador para el salto de linea en la pantalla
                espacioNumero+=50;
                contador+=100;
                if(contador>300)
                {
                    espacioSuperior+=120;
                    contador =0;
                    espacioNumero=0;
                }
               
            });
       
       
       //-------------------------------------//
       
       Slider sliderSubScene = new Slider();
       sliderSubScene.setMax(1000);// se define el largo maximo del  slider
       sliderSubScene.valueProperty().bindBidirectional(centro.translateXProperty());//se le da el recorrido al Slider en este caso es el largo del box
       pane.setBottom(sliderSubScene);
       
       
       
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
       
       BorderPane BpanePrueba = new BorderPane();
       BpanePrueba.setBottom(contenerdorPrincipal);
       //BpanePrueba.setCenter(pantallaDibujo);
       BpanePrueba.setCenter(pane);
      
        
        //StackPane root = new StackPane();
        
        primaryStage.setTitle("wena men ");//titulo de la ventana 
        
        Scene scene = new Scene (BpanePrueba,300,400);//constructor de la ventana
        
        BpanePrueba.setMinSize(300, 400);
        //root.setPrefSize(400, 300);
        /**root.minHeight(300);
        root.minWidth(400);*/
        //root.getChildren().add(BpanePrueba);//agregamos el boton a al root
        primaryStage.setScene(scene);//agregamos scene a la pantalla
        primaryStage.show();//mostramos la pantalla
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
