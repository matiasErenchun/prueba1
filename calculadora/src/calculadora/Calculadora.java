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
import javafx.scene.Group;
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
    
    public int maxLevel=0;
    public int minLevel=0;
    public int levelActual=0;
    public float factor =(float) 0.7;
    public Path miPath = new Path();
    public Group miGrupo= new Group(miPath);
    public double x=-110;
    public double y=200;
    //public double dif = 65;
    public boolean divid = false;
    public double space=60;
    @Override
    public void start(Stage primaryStage) {
       
        miMapLevel = new MapLevel();
        Button btn = new Button();
        btn.setText("up level");
        btn.setDisable(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                levelActual-=1;
                if(levelActual<maxLevel)
                {
                    System.out.println("levelActual "+levelActual);
                    System.out.println("hola");
                    levelActual+=1;
                    //pantalla de error de que  no se puede subir mas 
                }
               System.out.println("levelActual "+levelActual);
               System.out.println("max "+maxLevel);
               System.out.println("min "+minLevel);
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("dawn level");
        btn2.setDisable(true);
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                levelActual+=1;
                if(levelActual>minLevel)
                {
                    System.out.println("levelActual "+levelActual);
                    System.out.println("hola");
                    levelActual-=1;
                    //pantalla de error de que  no se puede subir mas 
                }
               System.out.println("levelActual "+levelActual);
               System.out.println("max "+maxLevel);
               System.out.println("min "+minLevel);
            }
        });
        
        Button btn3 = new Button();
        btn3.setText("numero XD");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                double miXx=x;
                double miYy=y;
                
                
                if(levelActual==0&&  divid==false)
                {
                    
                    Number miNumero = new Number(factor,levelActual);
                    miGrupo.getChildren().add(miNumero.draw0(miXx, miYy));
                    miXx=miXx+space;
                }
                else
                {
                    if(miMapLevel.getLevelPoint(levelActual).getStatusLevel())
                    {
                        System.out.println("levelActual"+levelActual);
                        miXx=miMapLevel.getLevelPoint(levelActual).getEndX();
                        miYy=miMapLevel.getLevelPoint(levelActual).getStartY();
                        Number miNumero = new Number(factor,levelActual);
                        miGrupo.getChildren().add(miNumero.draw0(miXx, miYy));
                        miXx=miXx+space;
                    }
                    else
                    {
                        System.out.println("nivel cerrado");
                    }
                }
                
               
                
                if(levelActual!=0)
                {
                    miMapLevel.getLevelPoint(levelActual).setEndX(miXx);
                }
                else
                {
                    x=miXx;
                }
                System.out.println("levelActual "+levelActual);
            }
        });
        Button btn4 = new Button();
        btn4.setText("/");
        btn4.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                if(levelActual==0)
                {
                    divid=true;
                    btn.setDisable(false);//luego de presionar el boton de division  abilita los botones de up y dawn
                    btn2.setDisable(false);
                    
                    LevelPoint level0= new LevelPoint(x,y);//crea el level 0 
                    miMapLevel.AddLevel(levelActual, level0);//agrega el level 0 al hashmap
                    LevelPoint nivelUp = new LevelPoint(x,y+60);//crea el level 1
                    LevelPoint nivelDawn = new LevelPoint(x,y-60);//crea el level -1
                    miMapLevel.AddLevel(levelActual+1, nivelUp);//agrega el level al hasmap
                    miMapLevel.AddLevel(levelActual-1, nivelDawn);
                    maxLevel=levelActual-1;// cambia el level maximo por el level superior mas alto  actual.
                    minLevel=levelActual+1;
                }
                if(levelActual>0 && miMapLevel.levelExist(levelActual+1)!=true)// si estamos en un level > al 0 (son los niveles inferiores a la barra de division )y el level superior no existe
                {
                    //se crean los dos niveles superiores de la nueva division  y el nivel actual queda como el inferiror de esa division.
                    double yActual = miMapLevel.getLevelPoint(levelActual).getStartY();//capturamos el y del nivel actual
                    LevelPoint nivel1Up = new LevelPoint(x,yActual+60);//creamos los dos niveles siguentes y el actual pasa a ser el inferior d ela divicion  nueva y a la vez el  superior de la division antigua 
                    LevelPoint nivel2Up = new LevelPoint(x,yActual+120);
                    miMapLevel.AddLevel(levelActual+1, nivel1Up);// agregamos los niveles
                    miMapLevel.AddLevel(levelActual+2, nivel2Up);
                    Symbol div = new Symbol(factor, levelActual);
                    double startNewDivide=miMapLevel.getLevelPoint(levelActual+1).getStartX();// capturamos el x inicial de la divicion
                    double yContenedor = miMapLevel.getLevelPoint(levelActual+1).getStartY();// capturamos el y de la division
                    miGrupo.getChildren().add(div.drawDividePrincipal(startNewDivide, yContenedor,startNewDivide+50));//ojo por ahora es ese despues se hara otro al cerra la divicion se dibujara una linea  con el largo de todos los elementos  sobre ella .
                    minLevel=levelActual+2;
                    
                    
                }
                else
                {
                    if(levelActual<0 && miMapLevel.levelExist(levelActual-1)!=true)
                    {
                        // crea los dos niveles inferiores a la division
                        double yActual = miMapLevel.getLevelPoint(levelActual).getStartY();
                        LevelPoint nivel1Up = new LevelPoint(x,yActual-60);
                        LevelPoint nivel2Up = new LevelPoint(x,yActual-120);
                        miMapLevel.AddLevel(levelActual-1, nivel1Up);
                        miMapLevel.AddLevel(levelActual-2, nivel2Up);
                        Symbol div = new Symbol(factor, levelActual);
                        double startNewDivide=miMapLevel.getLevelPoint(levelActual-1).getStartX();
                        double yContenedor = miMapLevel.getLevelPoint(levelActual-1).getStartY();
                        miGrupo.getChildren().add(div.drawDividePrincipal(startNewDivide, yContenedor,startNewDivide+50));//ojo por ahora es ese despues se hara otro.
                        miMapLevel.getLevelPoint(levelActual).setEndX(startNewDivide+50);
                        maxLevel=levelActual-2;
                    }
                    else
                    {
                        //esta parte es para dibujar divisiones simples dentro de un nivel
                        Symbol div = new Symbol(factor, levelActual);
                        double xContenedor = miMapLevel.getLevelPoint(levelActual).getEndX();
                        double yContenedor = miMapLevel.getLevelPoint(levelActual).getStartY();
                        miGrupo.getChildren().add(div.drawDividePrincipal(xContenedor, yContenedor,xContenedor+50));//ojo por ahora es ese despues se hara otro.
                        miMapLevel.getLevelPoint(levelActual).setEndX(xContenedor+50);
                    }
                    
                }
            }
        });
        
        Button btn5 = new Button();
        btn5.setText("close");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                 boolean isClosed =miMapLevel.ClosedLevel(levelActual);
                 if(isClosed)
                 {
                     miMapLevel.setEndXOfUpAndDawn(levelActual);
                     if(levelActual==0)
                     {
                         divid=false;
                         x=miMapLevel.getLevelPoint(levelActual).getEndX();
                     }
                 }
                
            }
        });
        
        
        
        
        Number numero = new Number(factor,levelActual);
        //numero.draw2(-100, 0, miPath);
        float f=(float) 5;
        Number numero3 = new Number(factor,levelActual);
        //numero3.draw3(-40, 0, miPath);
        numero3.setFactorResize(f);

        BorderPane pantalla = new BorderPane();
        pantalla.setCenter(miGrupo);
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
