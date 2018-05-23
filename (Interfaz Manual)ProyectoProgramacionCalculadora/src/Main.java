/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//modificado el 25 de abril a las 9:24

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Matias.Erenchun
 * @author elias avendano
 * @author mario Matamala
 */

public class Main extends Application {
   
    public Main() {
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pantalla pantalla=new Pantalla();
    }
    
}

