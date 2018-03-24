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
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Matias.Erenchun
 */
public class EjemplosFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Button btnPrueba = new Button();
        btnPrueba.setText("Hola");//contenido del boton 
        btnPrueba.setMaxWidth(Double.MAX_VALUE);
        btnPrueba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hola mis weros ");// accion que se ejecutara al presionar el boton 
            }

        });
        
       HBox hbox = new HBox(40);//creamos el Hbox
       hbox.setPadding(new Insets(20));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button1 = new Button("Add");
       Button button2 = new Button("Remove");
       HBox.setMargin(button1, new Insets(0,0,0,0));//margen entre objetos en este caso se dejo 5 a la  derecha 
       HBox.setMargin(button2, new Insets(0,0,0,0));
       HBox.setMargin(btnPrueba, new Insets(0,0,0,0));
       HBox.setHgrow(button1, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button2, Priority.ALWAYS);
       HBox.setHgrow(btnPrueba, Priority.ALWAYS);
       HBox.setMargin(button1, javafx.geometry.Insets.EMPTY);
       button1.setMaxWidth(Double.MAX_VALUE);
       button2.setMaxWidth(Double.MAX_VALUE);
       
       
       BorderPane BpanePrueba = new BorderPane();
       BpanePrueba.setBottom(hbox);
       hbox.getChildren().addAll(button1, button2,btnPrueba);
        
        StackPane root = new StackPane();
        
        primaryStage.setTitle("wena men ");//titulo de la ventana 
        
        Scene scene = new Scene (root,300,300);//constructor de la ventana 
        
        root.getChildren().add(BpanePrueba);//agregamos el boton a al root
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
