/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallapruebas;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

/**
 *
 * @author Matias.Erenchun
 */
public class PantallaPruebas extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        int a=0;
        Path miPath = new Path();
        
        MoveTo start6 = new MoveTo();
        start6.setX(200);
        start6.setY(125);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(175);
        arco1.setY(100);
        arco1.setControlX(200);
        arco1.setControlY(100);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(150);
        arco2.setY(125);
        arco2.setControlX(150);
        arco2.setControlY(100);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(175);
        arco3.setY(150);
        arco3.setControlX(150);
        arco3.setControlY(150);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(200);
        arco4.setY(125);
        arco4.setControlX(200);
        arco4.setControlY(150);
        
        VLineTo lineaV = new VLineTo();
        
        lineaV.setY(200);
        
         miPath.getElements().addAll(start6,arco1,arco2,arco3,arco4,lineaV);
        
        Pane root = new Pane();
        root.getChildren().add(miPath);
        
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
    
    public Path dibujar2(int x, int y,Path miPath)
    {
        MoveTo start2 = new MoveTo();
        start2.setX(200);
        start2.setY(200);
        
        HLineTo base = new HLineTo();
        base.setX(150);
        
        LineTo diagonal = new LineTo();
        diagonal.setX(200);
        diagonal.setY(125);
        
        QuadCurveTo primerArco = new QuadCurveTo();
        primerArco.setX(175);
        primerArco.setY(100);
        primerArco.setControlX(200);
        primerArco.setControlY(100);
        
        
        QuadCurveTo segundoArco = new QuadCurveTo();
        segundoArco.setX(150);
        segundoArco.setY(125);
        segundoArco.setControlX(150);
        segundoArco.setControlY(100);
        
         miPath.getElements().addAll(start2,base,diagonal,primerArco,segundoArco);
        
        return miPath;
    }
    
    public Path dibujar3(int x, int y , Path miPath)
    {
        // revisar la cabeza del 3 se podria hacer sus curbas mas pequeñas y subir el punto central para que quedara mejor 
        MoveTo start3 = new MoveTo();
        start3.setX(160);
        start3.setY(200);
        
        HLineTo base = new HLineTo();
        base.setX(170);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(200);
        arco1.setY(175);
        arco1.setControlX(200);
        arco1.setControlY(200);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(170);
        arco2.setY(150);
        arco2.setControlX(200);
        arco2.setControlY(150);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(200);
        arco3.setY(125);
        arco3.setControlX(200);
        arco3.setControlY(150);
        
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(170);
        arco4.setY(100);
        arco4.setControlX(200);
        arco4.setControlY(100);
        
        HLineTo htop = new HLineTo();
        htop.setX(160);
        
        
        
         miPath.getElements().addAll(start3,base,arco1,arco2,arco3,arco4,htop);
        
        return miPath;
    }
    
    public Path dibujar5(int x, int y , Path miPath )
    {
        MoveTo start5 = new MoveTo();
        start5.setX(150);
        start5.setY(190);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(160);
        arco1.setY(200);
        arco1.setControlX(150);
        arco1.setControlY(200);
        
        HLineTo base = new HLineTo();
        base.setX(180);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(200);
        arco2.setY(170);
        arco2.setControlX(200);
        arco2.setControlY(200);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(180);
        arco3.setY(140);
        arco3.setControlX(200);
        arco3.setControlY(140);
        
        
        
        HLineTo hmid = new HLineTo();
        hmid.setX(150);
        
        VLineTo vline = new VLineTo();
        vline.setY(100);
        
        HLineTo htop = new HLineTo();
        htop.setX(200);
        
         miPath.getElements().addAll(start5,arco1,base,arco2,arco3,hmid,vline,htop);
         
        return miPath;
    }
    
    public Path dibujar6(int x, int y , Path miPath)
    {
        MoveTo start6 = new MoveTo();
        start6.setX(150);
        start6.setY(175);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(175);
        arco1.setY(200);
        arco1.setControlX(150);
        arco1.setControlY(200);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(200);
        arco2.setY(175);
        arco2.setControlX(200);
        arco2.setControlY(200);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(175);
        arco3.setY(150);
        arco3.setControlX(200);
        arco3.setControlY(150);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(150);
        arco4.setY(175);
        arco4.setControlX(150);
        arco4.setControlY(150);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setX(180);
        arco5.setY(100);
        arco5.setControlX(155);
        arco5.setControlY(110);
        
         miPath.getElements().addAll(start6,arco1,arco2,arco3,arco4,arco5);
         
        return miPath;
    }
    
    public Path pintar9(int x, int y , Path miPath)
    {
        MoveTo start6 = new MoveTo();
        start6.setX(200);
        start6.setY(125);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(175);
        arco1.setY(100);
        arco1.setControlX(200);
        arco1.setControlY(100);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(150);
        arco2.setY(125);
        arco2.setControlX(150);
        arco2.setControlY(100);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(175);
        arco3.setY(150);
        arco3.setControlX(150);
        arco3.setControlY(150);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(200);
        arco4.setY(125);
        arco4.setControlX(200);
        arco4.setControlY(150);
        
        VLineTo lineaV = new VLineTo();
        
        lineaV.setY(200);
        
         miPath.getElements().addAll(start6,arco1,arco2,arco3,arco4,lineaV);
        return miPath;
    }
    
    //falta hacer el 7 y el 8 :D
}
