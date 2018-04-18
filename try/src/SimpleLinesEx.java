
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * ZetCode JavaFX tutorial
 *
 * This program draws three lines which
 * form a rectangle.
 * 
 * Author: Jan Bodnar 
 * Website: zetcode.com 
 * Last modified: June 2015
 */
public class SimpleLinesEx extends Application {

    int a=0;
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
        
    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        Pane root = new Pane();
        
        Path path=new Path();
        
        ArrayList<Punto> Puntos=new ArrayList<>(); // se crea la lista para los puntos 
        Punto a1=new Punto(200, 200); Puntos.add(a1); //Se crea el punto y se agrega a la lista 
        Punto a2=new Punto(200, 150); Puntos.add(a2); 
        Punto a3=new Punto(200, 100); Puntos.add(a3); 
        Punto a4=new Punto(150, 150); Puntos.add(a4);
        Punto a5=new Punto(200, 150); Puntos.add(a5);
        
        a=0;
        
        
        for (Punto Punto1 : Puntos) {
            
            //para crear el primer punto del numero
            if (a<1) {
                MoveTo l=new MoveTo(Punto1.getX(),Punto1.getY());
                path.getElements().add(l);
                Circle c1 = new Circle();
                c1.setCenterX(Punto1.getX());
                c1.setCenterY(Punto1.getY());
                c1.setRadius(5.0);
                c1.setCache(true);
                c1.setStroke(Color.RED);
                c1.setFill(Color.GREENYELLOW);
                c1.setStrokeWidth(3);
                c1.setOnMousePressed(pressMouse(c1));
                c1.setOnMouseDragged(dragMouseInicial(c1, l));
                circle.getChildren().add(c1);
                a+=1;
            }
            //para crear el resto de los puntos 
            else{
                LineTo l=new LineTo(Punto1.getX(),Punto1.getY());
                path.getElements().add(l);
                a+=1;
            }
        }
        a=0;
        
    
       
        root.getChildren().addAll(path,circle);// se agrega las lineas y el gripo con circulos

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Lines");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    //detecta el lugar donde se presiona
    EventHandler<MouseEvent> pressMouse(Circle c) {
     EventHandler<MouseEvent> mousePressHandler = new EventHandler<MouseEvent>() {

         public void handle(MouseEvent event) {
             if (event.getButton() == MouseButton.PRIMARY) {
                 // get the current mouse coordinates according to the scene.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();

                 // get the current coordinates of the draggable node.
                 m_nX = c.getLayoutX();
                 m_nY = c.getLayoutY();
             }
         }
     };
     return mousePressHandler;
    }  
    
    
    //detecta el movimiento del punto inicial
    EventHandler<MouseEvent> dragMouseInicial(Circle c, MoveTo l) {
     EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

         public void handle(MouseEvent event) {
             if (event.getButton() == MouseButton.PRIMARY) {
                 // find the delta coordinates by subtracting the new mouse
                 // coordinates with the old.
                 double deltaX = event.getSceneX() - m_nMouseX;
                 double deltaY = event.getSceneY() - m_nMouseY;

                 // add the delta coordinates to the node coordinates.
                 m_nX += deltaX;
                 m_nY += deltaY;

                 // set the layout for the draggable node.
                 c.setLayoutX(m_nX);
                 c.setLayoutY(m_nY);
                 l.setX(event.getSceneX());
                 l.setY(event.getSceneY());

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }
    
    //detecta el movimiento del resto de los puntos
    EventHandler<MouseEvent> dragMouse(Circle c, LineTo l) {
     EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

         public void handle(MouseEvent event) {
             if (event.getButton() == MouseButton.PRIMARY) {
                 // find the delta coordinates by subtracting the new mouse
                 // coordinates with the old.
                 double deltaX = event.getSceneX() - m_nMouseX;
                 double deltaY = event.getSceneY() - m_nMouseY;

                 // add the delta coordinates to the node coordinates.
                 m_nX += deltaX;
                 m_nY += deltaY;

                 // set the layout for the draggable node.
                 c.setLayoutX(m_nX);
                 c.setLayoutY(m_nY);
                 l.setX(event.getSceneX());
                 l.setY(event.getSceneY());

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }
}