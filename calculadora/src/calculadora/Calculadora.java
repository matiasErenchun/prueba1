/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;

/**
 *
 * @author Matias.Erenchun
 */
public class Calculadora extends Application {
    public HashMap levelPoints = new HashMap();
    public float maxLevel=0;
    public float minLevel=0;
    public float levelActual=0;
    public float factor =(float) 0.5;
    public Path miPath = new Path();
    public double x=-110;
    public double y=200;
    public double dif = 65;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("dawn level");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                levelActual+= 0.5;
                y=0+((235*levelActual));
                System.out.println("levelActual");
                System.out.println(levelActual);
                if(levelActual>maxLevel)
                {
                    LevelPoint levelPoint = new LevelPoint(levelActual,x,y);
                    maxLevel = levelActual;
                    levelPoints.putIfAbsent(levelActual, levelPoint);
                }
                
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("up level");
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                levelActual-= 0.5;
                System.out.println("levelActual");
                System.out.println(levelActual);
                y=0+((235*levelActual));
                if(levelActual<minLevel)
                {
                    minLevel = levelActual;
                    LevelPoint levelPoint = new LevelPoint(levelActual,x,y);
                    levelPoints.putIfAbsent(levelActual, levelPoint);
                    
                }
                
            }
        });
        
        Button btn3 = new Button();
        btn3.setText("numero XD");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                LevelPoint contenedor=(LevelPoint) levelPoints.get(levelActual);
                double xx = contenedor.getEndPoint().getCoordenadaX();
                double yy = contenedor.getCoordenadaY();
                Number numero0 = new Number(factor, levelActual);
                
                if(levelActual>0 && levelActual<maxLevel || levelActual<0 && levelActual>minLevel)
                {
                    Symbol div = new Symbol(factor,levelActual);
                    div.drawDivide(xx, yy-(235*factor), miPath);
                    div.drawDivide(xx, yy, miPath);
                    numero0.draw0(xx, yy-(15*factor), miPath);
                    x+=dif;
                }
                else
                {
                    if(levelActual>0 && levelActual==maxLevel || levelActual<0 && levelActual==minLevel)
                    {
                        Symbol div = new Symbol(factor,levelActual);
                        div.drawDivide(x, y, miPath);
                        numero0.draw0(x, y-(15*factor), miPath);
                    }
                    else
                    {
                        numero0.draw0(x, y, miPath);
                    }
                    
                    x+=dif;
                }
                
                contenedor.getEndPoint().setCoordenadaX(xx+dif);
                levelPoints.put(levelActual, contenedor);
                
                
            }
        });
        
        
        
        Number numero = new Number(factor,levelActual);
        numero.draw2(-100, 0, miPath);
        float f=(float) 5;
        Number numero3 = new Number(factor,levelActual);
        numero3.draw3(-40, 0, miPath);
        numero3.setFactorResize(f);
        
        Symbol a= new Symbol(factor,levelActual);
        a.drawDivide(20, 0, miPath);
        
        
        
        BorderPane pantalla = new BorderPane();
        pantalla.setCenter(miPath);
        HBox miBott = new HBox();
        miBott.getChildren().addAll(btn,btn2,btn3);
        pantalla.setBottom(miBott);
        StackPane root = new StackPane();
        root.getChildren().add(pantalla);
       
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
