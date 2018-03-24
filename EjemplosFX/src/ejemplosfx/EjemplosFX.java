/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosfx;

import java.awt.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        btnPrueba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hola mis weros ");// accion que se ejecutara al presionar el boton 
            }

        });
        
       HBox hbox = new HBox();
       Button button1 = new Button("Add");
       Button button2 = new Button("Remove");
       HBox.setHgrow(button1, Priority.ALWAYS);
       HBox.setHgrow(button2, Priority.ALWAYS);
       button1.setMaxWidth(Double.MAX_VALUE);
       button2.setMaxWidth(Double.MAX_VALUE);
       hbox.getChildren().addAll(button1, button2,btnPrueba);
        
        StackPane root = new StackPane();
        
        primaryStage.setTitle("wena men ");//titulo de la ventana 
        
        Scene scene = new Scene (root,300,300);//constructor de la ventana 
        
        root.getChildren().add(hbox);//agregamos el boton a al root
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
