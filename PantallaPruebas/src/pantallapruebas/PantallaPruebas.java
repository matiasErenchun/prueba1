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
        int a=-50;
        Path miPath = new Path();
        this.dibujar8(a, 0, miPath);
        a+=50;
       this.dibujar3(a, 0, miPath);
       a+=50;
       this.dibujar6(a, 0, miPath);
       a+=60;
       this.dibujar2(a, 0, miPath);
       a+=60;
       this.dibujar5(a, 0, miPath);
       a+=60;
       this.dibujar7(a, 0, miPath);
       a+=60;
       this.dibujar9(a, 0, miPath);
       
        Pane root = new Pane();
        root.getChildren().add(miPath);
        
        Scene scene = new Scene(root, 400, 250);
        
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
        start2.setX(150+x);
        start2.setY(125);
        
        HLineTo base = new HLineTo();
        base.setX(200+x);
        
        LineTo diagonal = new LineTo();
        diagonal.setX(150+x);
        diagonal.setY(200);
        
        QuadCurveTo primerArco = new QuadCurveTo();
        primerArco.setX(175+x);
        primerArco.setY(100);
        primerArco.setControlX(150+x);
        primerArco.setControlY(100);
        
        
        QuadCurveTo segundoArco = new QuadCurveTo();
        segundoArco.setX(200+x);
        segundoArco.setY(125);
        segundoArco.setControlX(200+x);
        segundoArco.setControlY(100);
        
         miPath.getElements().addAll(start2,primerArco,segundoArco,diagonal,base);
        
        return miPath;
    }
    
    public Path dibujar3(int x, int y , Path miPath)
    {
        // revisar la cabeza del 3 se podria hacer sus curbas mas pequeñas y subir el punto central para que quedara mejor 
        MoveTo start3 = new MoveTo();
        start3.setX(150+x);
        start3.setY(200);
        
        HLineTo base = new HLineTo();
        base.setX(160+x);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(190+x);
        arco1.setY(175);
        arco1.setControlX(190+x);
        arco1.setControlY(200);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(160+x);
        arco2.setY(150);
        arco2.setControlX(190+x);
        arco2.setControlY(150);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(190+x);
        arco3.setY(125);
        arco3.setControlX(190+x);
        arco3.setControlY(150);
        
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(160+x);
        arco4.setY(100);
        arco4.setControlX(190+x);
        arco4.setControlY(100);
        
        HLineTo htop = new HLineTo();
        htop.setX(150+x);
        
        
        
         miPath.getElements().addAll(start3,base,arco1,arco2,arco3,arco4,htop);
        
        return miPath;
    }
    
    public Path dibujar5(int x, int y , Path miPath )
    {
        MoveTo start5 = new MoveTo();
        start5.setX(150+x);
        start5.setY(190);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(160+x);
        arco1.setY(200);
        arco1.setControlX(150+x);
        arco1.setControlY(200);
        
        HLineTo base = new HLineTo();
        base.setX(180+x);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(200+x);
        arco2.setY(170);
        arco2.setControlX(200+x);
        arco2.setControlY(200);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(180+x);
        arco3.setY(140);
        arco3.setControlX(200+x);
        arco3.setControlY(140);
        
        
        
        HLineTo hmid = new HLineTo();
        hmid.setX(150+x);
        
        VLineTo vline = new VLineTo();
        vline.setY(100);
        
        HLineTo htop = new HLineTo();
        htop.setX(200+x);
        
         miPath.getElements().addAll(start5,arco1,base,arco2,arco3,hmid,vline,htop);
         
        return miPath;
    }
    
    public Path dibujar6(int x, int y , Path miPath)
    {
        MoveTo start6 = new MoveTo();
        start6.setX(150+x);
        start6.setY(175);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(175+x);
        arco1.setY(200);
        arco1.setControlX(150+x);
        arco1.setControlY(200);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(200+x);
        arco2.setY(175);
        arco2.setControlX(200+x);
        arco2.setControlY(200);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(175+x);
        arco3.setY(150);
        arco3.setControlX(200+x);
        arco3.setControlY(150);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(150+x);
        arco4.setY(175);
        arco4.setControlX(150+x);
        arco4.setControlY(150);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setX(180+x);
        arco5.setY(100);
        arco5.setControlX(155+x);
        arco5.setControlY(110);
        
         miPath.getElements().addAll(start6,arco1,arco2,arco3,arco4,arco5);
         
        return miPath;
    }
    
    public Path dibujar9(int x, int y , Path miPath)
    {
        MoveTo start9 = new MoveTo();
        start9.setX(150+x);
        start9.setY(125);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(175+x);
        arco1.setY(150);
        arco1.setControlX(150+x);
        arco1.setControlY(150);
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(200+x);
        arco2.setY(125);
        arco2.setControlX(200+x);
        arco2.setControlY(150);
        
        VLineTo lineaV = new VLineTo();
        lineaV.setY(200);
        
        VLineTo lineaV2 = new VLineTo();
        lineaV2.setY(125);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(175+x);
        arco3.setY(100);
        arco3.setControlX(200+x);
        arco3.setControlY(100);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(150+x);
        arco4.setY(125);
        arco4.setControlX(150+x);
        arco4.setControlY(100);
        
        
        
         miPath.getElements().addAll(start9,arco1,arco2,lineaV,lineaV2,arco3,arco4);
        return miPath;
    }
    
    public Path dibujar7(int x,int y,Path miPath)
    {
        MoveTo start7 = new MoveTo();
        start7.setX(150+x);
        start7.setY(200);
        
        LineTo diagonal1 = new LineTo();
        diagonal1.setX(175+x);
        diagonal1.setY(150);
        
        HLineTo hMidLine1 = new HLineTo();
        hMidLine1.setX(200+x);
        
        HLineTo hMidLine2 = new HLineTo();
        hMidLine2.setX(150+x);
        
        HLineTo hMidLine3 = new HLineTo();
        hMidLine3.setX(175+x);
        
        LineTo diagonal2 = new LineTo();
        diagonal2.setX(200+x);
        diagonal2.setY(100);
        
        HLineTo lineaTop = new HLineTo();
        lineaTop.setX(150+x);
        
         miPath.getElements().addAll(start7,diagonal1,hMidLine1,hMidLine2,hMidLine3,diagonal2,lineaTop);
        
        return miPath;
    }
    
    public Path dibujar8(int x,int y, Path miPath)
    {
        MoveTo start8 = new MoveTo();
        start8.setX(150+x);
        start8.setY(175);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(170+x);
        arco1.setY(200);
        arco1.setControlX(150+x);
        arco1.setControlY(200);
        
        LineTo base = new LineTo();
        base.setX(180+x);
        base.setY(200);

        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(200+x);
        arco2.setY(175);
        arco2.setControlX(200+x);
        arco2.setControlY(200);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(180+x);
        arco3.setY(150);
        arco3.setControlX(200+x);
        arco3.setControlY(150);
        
        LineTo mid1 = new LineTo();
        mid1.setX(170+x);
        mid1.setY(150);

        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX(150+x);
        arco4.setY(125);
        arco4.setControlX(150+x);
        arco4.setControlY(150);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setX(170+x);
        arco5.setY(100);
        arco5.setControlX(150+x);
        arco5.setControlY(100);
        
        LineTo htop = new LineTo();
        htop.setX(180+x);
        htop.setY(100);
        
        QuadCurveTo arco6 = new QuadCurveTo();
        arco6.setX(200+x);
        arco6.setY(125);
        arco6.setControlX(200+x);
        arco6.setControlY(100);
        
        QuadCurveTo arco7 = new QuadCurveTo();
        arco7.setX(180+x);
        arco7.setY(150);
        arco7.setControlX(200+x);
        arco7.setControlY(150);
        
        
        LineTo mid2 = new LineTo();
        mid2.setX(170+x);
        mid2.setY(150);
        
        
        
        QuadCurveTo arco8 = new QuadCurveTo();
        arco8.setX(150+x);
        arco8.setY(175);
        arco8.setControlX(150+x);
        arco8.setControlY(150);
        miPath.getElements().addAll(start8,arco1,base,arco2,arco3,mid1,arco4,arco5,htop,arco6,arco7,mid2,arco8);
        return miPath;
    }
    
    //falta hacer el 7 y el 8 :D
}
