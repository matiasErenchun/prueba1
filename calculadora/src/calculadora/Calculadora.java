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
    public MapLevel miMapLevel;
    public float maxLevel=0;
    public float minLevel=0;
    public float levelActual=0;
    public float factor =(float) 0.3;
    public Path miPath = new Path();
    public double x=-110;
    public double y=200;
    public double dif = 65;
    public boolean divid = false;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("dawn level");
        btn.setDisable(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                levelActual-=0.5;
                if(levelActual<minLevel)
                {
                    minLevel=levelActual;
                    LevelPoint contenedor = miMapLevel.getLevelPoint((float) (levelActual+0.5));
                    double miY=contenedor.getCoordenadaY();
                    double miX = miMapLevel.getLevelPoint(0).getCoordenadaX();
                    LevelPoint contenedor2 = new LevelPoint(levelActual,miX,miY+60);
                    Symbol div=new Symbol(factor,levelActual);
                    div.drawDivide(miX, miY+60, miPath);
                    miMapLevel.AddLevel(levelActual, contenedor2);
                    LevelPoint contenedor3 = new LevelPoint(levelActual,miX,miY+120);
                    miMapLevel.AddLevel((float) (levelActual-0.5), contenedor3);
                    minLevel =(float) (levelActual-0.5);
                    
                    
                }
                
                
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("up level");
        btn2.setDisable(true);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                levelActual+=0.5;
                if(levelActual>maxLevel)
                {
                    maxLevel=levelActual;
                    LevelPoint contenedor = miMapLevel.getLevelPoint((float) (levelActual-0.5));//se obtine el punto de nivel del nivel inferior/anterior
                    double miY = contenedor.getCoordenadaY();
                    double miX = miMapLevel.getLevelPoint(0).getCoordenadaX();
                    
                    LevelPoint contenedor5 = new LevelPoint(levelActual,miX,miY-60);
                    Symbol div=new Symbol(factor,levelActual);
                    div.drawDivide(miX, miY-60, miPath);
                    miMapLevel.AddLevel(levelActual, contenedor5);
                    LevelPoint contenedor4 = new LevelPoint(levelActual,miX,miY-120);
                    miMapLevel.AddLevel((float) (levelActual+0.5), contenedor4);
                    maxLevel =(float) (levelActual+0.5);
                    
                    
                }
                
                
            }
        });
        
        Button btn3 = new Button();
        btn3.setText("numero XD");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                if(divid)
                {
                    if(miMapLevel.getLevelPoint(levelActual).isStatusLevel())
                    {
                        double miX=miMapLevel.getLevelPoint(levelActual).getEndPoint().getCoordenadaX();
                        double miY=miMapLevel.getLevelPoint(levelActual).getCoordenadaY();
                        Number numero= new Number(factor,levelActual);
                        numero.draw0(miX, miY, miPath);
                        Point miEnd =new Point(levelActual,miX+60,miY);
                        LevelPoint  contenedor = miMapLevel.getLevelPoint(levelActual);
                        contenedor.setEndPoint(miEnd);
                        miMapLevel.AddLevel(levelActual, contenedor);
                    }
                }
                else
                {
                    Number numero= new Number(factor,levelActual);
                    numero.draw0(x, y, miPath);
                    x+=60;
                }
                
            }
        });
        Button btn4 = new Button();
        btn4.setText("/");
        btn4.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                divid=true;
                btn.setDisable(false);
                btn2.setDisable(false);
                miMapLevel = new MapLevel();
                LevelPoint thisLevelPoint = new LevelPoint(levelActual,x+40,y);
                miMapLevel.AddLevel(levelActual, thisLevelPoint);
                
                double thisEx = miMapLevel.getLevelPoint(0).getCoordenadaX();
                LevelPoint LevelPointUp = new LevelPoint(levelActual,thisEx,y-60);
                LevelPoint LevelPointDawn = new LevelPoint(levelActual,thisEx,y+60);
                
                
                miMapLevel.AddLevel((float) (0.5), LevelPointUp);
                miMapLevel.AddLevel((float) (-0.5), LevelPointDawn);
                maxLevel=(float) 0.5;
                minLevel=(float) -0.5;
                
                
                Symbol div = new Symbol(factor,levelActual);
                div.drawDivide(thisEx, y, miPath);
                x=x+70;
                btn4.setDisable(true);
            }
        });
        Button btn5 = new Button();
        btn5.setText("close");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                
                LevelPoint contenedor = miMapLevel.getLevelPoint(levelActual);
                contenedor.setStatusLevel(false);
                miMapLevel.AddLevel(levelActual, contenedor);
                
                if(levelActual==0 && divid)
                {
                    divid=false;
                    btn4.setDisable(false);
                }
                
                
            }
        });
        
        
        
        
        Number numero = new Number(factor,levelActual);
        //numero.draw2(-100, 0, miPath);
        float f=(float) 5;
        Number numero3 = new Number(factor,levelActual);
        //numero3.draw3(-40, 0, miPath);
        numero3.setFactorResize(f);
        
        Symbol a= new Symbol(factor,levelActual);
        //a.drawDivide(20, 0, miPath);
        
        
        
        BorderPane pantalla = new BorderPane();
        pantalla.setCenter(miPath);
        HBox miBott = new HBox();
        miBott.getChildren().addAll(btn,btn2,btn3,btn4,btn5);
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
