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
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
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
       VBox contenedorNumeros = new VBox();
       HBox numerosFila1 = new HBox();//creamos el Hbox
       numerosFila1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button7 = new Button(" 7 ");
       Button button8 = new Button(" 8 ");// en este caso el contenido se entrega en el contructor
       Button button9 = new Button();
       button9.setText(" 9 ");//contenido del boton 
       button9.setMaxWidth(Double.MAX_VALUE);
       button9.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               System.out.println("hola mis 9 weros ");// accion que se ejecutara al presionar el boton 
           }

       });
       //HBox.setMargin(button1, new Insets(0,0,0,0));//margen entre objetos en este caso se dejo 5 a la  derecha 
       HBox.setHgrow(button7, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button8, Priority.ALWAYS);
       HBox.setHgrow(button9, Priority.ALWAYS);
       HBox.setMargin(button7, javafx.geometry.Insets.EMPTY);
       button7.setMaxWidth(Double.MAX_VALUE);
       button8.setMaxWidth(Double.MAX_VALUE);
       numerosFila1.getChildren().addAll(button7, button8,button9);
       
       
       //------------------------------//
       
       HBox numerosFila2 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button4 = new Button(" 4 ");
       
      
       Button button5 = new Button(" 5 ");// en este caso el contenido se entrega en el contructor
       Button button6 = new Button(" 6 ");
       HBox.setHgrow(button4, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button5, Priority.ALWAYS);
       HBox.setHgrow(button6, Priority.ALWAYS);
       button4.setMaxWidth(Double.MAX_VALUE);
       button5.setMaxWidth(Double.MAX_VALUE);
       button6.setMaxWidth(Double.MAX_VALUE);
       numerosFila2.getChildren().addAll(button4, button5,button6);
       
       //------------------------------//
       
       HBox numerosFila3 = new HBox();
       numerosFila1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button1 = new Button(" 1 ");
       Button button2 = new Button(" 2 ");// en este caso el contenido se entrega en el contructor
       Button button3 = new Button(" 3 ");
       HBox.setHgrow(button1, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button2, Priority.ALWAYS);
       HBox.setHgrow(button3, Priority.ALWAYS);
       button1.setMaxWidth(Double.MAX_VALUE);
       button2.setMaxWidth(Double.MAX_VALUE);
       button3.setMaxWidth(Double.MAX_VALUE);
       numerosFila3.getChildren().addAll(button1, button2,button3);
       
       //------------------------------//
       
       HBox numerosFila4 = new HBox();
       numerosFila1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button00 = new Button("    ");
       Button button0 = new Button(" 0 ");// en este caso el contenido se entrega en el contructor
       Button buttonNn = new Button("    ");
       HBox.setHgrow(button00, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button0, Priority.ALWAYS);
       HBox.setHgrow(buttonNn, Priority.ALWAYS);
       button00.setMaxWidth(Double.MAX_VALUE);
       button0.setMaxWidth(Double.MAX_VALUE);
       buttonNn.setMaxWidth(Double.MAX_VALUE);
       numerosFila4.getChildren().addAll(button00, button0,buttonNn);
       
       //------------------------------//
       
       contenedorNumeros.getChildren().addAll(numerosFila1,numerosFila2,numerosFila3,numerosFila4);
       
       //*******fin numeros***************
       
       //*******inicio simbolos***********
       
       VBox contenedorSimbolos = new VBox();
       
       //------------------------------//
       
       HBox simbolos1 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonpar1 = new Button(" ( ");
       Button buttonpar2 = new Button(" ) ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonpar1, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonpar2, Priority.ALWAYS);
       buttonpar1.setMaxWidth(Double.MAX_VALUE);
       buttonpar2.setMaxWidth(Double.MAX_VALUE);
      
       simbolos1.getChildren().addAll(buttonpar1, buttonpar2);
       
       //-------------------------------------//
       
        HBox simbolos2 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonMas= new Button(" + ");
       Button buttonMenos = new Button(" - ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonMas, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonMenos, Priority.ALWAYS);
       
       buttonMas.setMaxWidth(Double.MAX_VALUE);
       buttonMenos.setMaxWidth(Double.MAX_VALUE);
      
       simbolos2.getChildren().addAll(buttonMas, buttonMenos);
       
        //------------------------------//
       
       HBox simbolos3 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonPor = new Button(" * ");
       Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonPor, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       buttonPor.setMaxWidth(Double.MAX_VALUE);
       buttonDiv.setMaxWidth(Double.MAX_VALUE);
      
       simbolos3.getChildren().addAll(buttonPor, buttonDiv);
       
       //-------------------------------------//
       
        //------------------------------//
       
       HBox simbolos4 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonNn2 = new Button("  ");
       //Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonNn2, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       //HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       buttonNn2.setMaxWidth(Double.MAX_VALUE);
       //buttonDiv.setMaxWidth(Double.MAX_VALUE);
      
       simbolos4.getChildren().addAll(buttonNn2);
       
       //-------------------------------------//
       
       
       contenedorSimbolos.getChildren().addAll(simbolos1,simbolos2,simbolos3,simbolos4);
       
       //*******fin numeros***************
       
       //*******inicio Esena de dibujo***********
       Box box = new Box(100,100,100);
       BorderPane pane = new BorderPane();
       box.setManaged(true);
       //pane.setCenter(box);
       Path center = new Path();
       pane.setCenter(center);
        button4.setOnAction((ActionEvent event) ->
           
           {
               double n =button4.getHeight();
                Numero4 numero4=new Numero4(n, espacioNumero,espacioSuperior);
                pane.setCenter(numero4.start(center));
                //contador para el salto de linea en la pantalla
                espacioNumero+=100;
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
       sliderSubScene.valueProperty().bindBidirectional(center.translateXProperty());//se le da el recorrido al Slider en este caso es el largo del box
       pane.setBottom(sliderSubScene);
       
       
       
       //SubScene pantallaDibujo = new SubScene(aux1,300,300);//creamos la SubScene dando su contenido  luego su ancho y altura 
       //en este caso su contenido es un border pane.
       
       //*******fin Esena de dibujo**************
       contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
       HBox.setHgrow(contenedorNumeros, Priority.ALWAYS);// se define la prioridad de llenado de espacio que tiene el nodo  dentro de su contenedor.
       HBox.setHgrow(contenedorSimbolos, Priority.ALWAYS);
       VBox.setVgrow(numerosFila1, Priority.ALWAYS);
       VBox.setVgrow(numerosFila2, Priority.ALWAYS);
       VBox.setVgrow(numerosFila3, Priority.ALWAYS);
       VBox.setVgrow(numerosFila4, Priority.ALWAYS);
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
