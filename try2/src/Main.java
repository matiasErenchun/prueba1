
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mario
 */
public class Main extends Application{
    
    double midx,midy;
    QuadCurve curve=new QuadCurve();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        Group root= new Group();
        Group circle=new Group();
            
            Circle c1=new Circle(100,200,4);
            c1.setStrokeWidth(1);
            Circle c2=new Circle(200,200,4);
            c2.setStrokeWidth(1);
            
            
            double sx = calcX(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY(),c1.getRadius(),c1.getStrokeWidth());
            double sy = calcY(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY(),c1.getRadius(),c1.getStrokeWidth());
            double ex = calcX(c2.getCenterX(),c2.getCenterY(),c1.getCenterX(),c1.getCenterY(),c2.getRadius(),c2.getStrokeWidth());
            double ey = calcY(c2.getCenterX(),c2.getCenterY(),c1.getCenterX(),c1.getCenterY(),c2.getRadius(),c2.getStrokeWidth());

            this.curve.setStartX(sx);
            this.curve.setStartY(sy);        
            this.curve.setEndX(ex);
            this.curve.setEndY(ey);

            midx = (sx+ex)/2;
            midy = (sy+ey)/2;
            this.curve.setControlX(midx);
            this.curve.setControlY(midy);
            
            Circle c3=new Circle(curve.getControlX(),curve.getControlY(),4);
            c3.setStrokeWidth(1);
            
            System.out.println(sx);
            System.out.println(sy);
            
            System.out.println(ex);
            System.out.println(ey);
            
            System.out.println(midx);
            System.out.println(midy);
            
            curve.setStroke(Color.BLACK);
            curve.setFill(Color.TRANSPARENT);
            curve.setStrokeWidth(4);
            
        circle.getChildren().addAll(c1,c2,c3);
        root.getChildren().addAll(circle,curve);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("curva");
        stage.setScene(scene);
        stage.show();
       
    }
    
    private double calcX(double Ax, double Ay, double Bx, double By, double radius, double strokeWidth) {
        double r = radius+(strokeWidth/2);
        double distance = Math.sqrt(Math.pow(Bx-Ax,2) + Math.pow(By-Ay,2));
        return Ax+(r*(Bx-Ax)/distance);
    }
    
    private double calcY(double Ax, double Ay, double Bx, double By, double radius, double strokeWidth) {        
        double r = radius+(strokeWidth/2);
        double distance = Math.sqrt(Math.pow(Bx-Ax,2) + Math.pow(By-Ay,2));
        return Ay+(r*(By-Ay)/distance);
    }
}
