/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosfx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;

/**
 *
 * @author mario
 */
public class Numero0 {
     double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    double reAjuste=25;

    public Numero0(double marco, double espacio, double superior) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
    }
    
    public Group start(Path path) {
    
        MoveTo moveTo1=new MoveTo(150+espacio, 160+superior);
        LineTo line1=new LineTo(150+espacio, 140+superior);
        MoveTo moveTo2= new MoveTo(100+espacio, 160+espacio);
        LineTo line2=new LineTo(100+espacio, 140+superior);
        QuadCurve curva1 = new QuadCurve(line1.getX(),line1.getY()+reAjuste,line2.getX()+((line1.getX()-line2.getX())/2),line1.getY()-reAjuste,line2.getX(),line2.getY()+reAjuste);
        QuadCurve curva2 = new QuadCurve(moveTo1.getX(),moveTo1.getY()+reAjuste,line2.getX()+((line1.getX()-line2.getX())/2),moveTo1.getY()+reAjuste+40,moveTo2.getX(),moveTo2.getY()+reAjuste);
        curva1.setFill(Color.TRANSPARENT);
        curva1.setStroke(Color.BLACK);
        curva2.setFill(Color.TRANSPARENT);
        curva2.setStroke(Color.BLACK);
        
        path.setStrokeWidth(4); //grisor de la linea


    //Adding all the elements to the path 
    path.getElements().add(moveTo1); 
    path.getElements().addAll(line1,moveTo2, line2);   
    Group root = new Group(path);
    root.getChildren().addAll(circle,curva1,curva2);

    
        Circle c1 = new Circle();
        c1.setCenterX(moveTo1.getX());
        c1.setCenterY(moveTo1.getY()+marco);
        c1.setRadius(5.0);
        c1.setCache(true);
        c1.setStroke(Color.RED);
        c1.setFill(Color.GREENYELLOW);
        c1.setStrokeWidth(3);

        Circle c2 = new Circle();
        c2.setCenterX(line1.getX());
        c2.setCenterY(line1.getY()+marco);
        c2.setRadius(5.0);
        c2.setCache(true);
        c2.setStroke(Color.RED);
        c2.setFill(Color.GREENYELLOW);
        c2.setStrokeWidth(3);
//
        Circle c3 = new Circle();
        c3.setCenterX(line2.getX());
        c3.setCenterY(line2.getY()+marco);
        c3.setRadius(5.0);
        c3.setCache(true);
        c3.setStroke(Color.RED);
        c3.setFill(Color.GREENYELLOW);
        c3.setStrokeWidth(3);
//
        Circle c4 = new Circle();
        c4.setCenterX(moveTo2.getX());
        c4.setCenterY(moveTo2.getY()+marco);
        c4.setRadius(5.0);
        c4.setStroke(Color.RED);
        c4.setFill(Color.GREENYELLOW);
        c4.setStrokeWidth(3);
//
        Circle c5 = new Circle();
        c5.setCenterX(curva1.getControlX());
        c5.setCenterY(curva1.getControlY()+marco);
        c5.setRadius(5.0);
        c5.setStroke(Color.RED);
        c5.setFill(Color.GREENYELLOW);
        c5.setStrokeWidth(3);

        curva1.setStrokeWidth(4);
        curva2.setStrokeWidth(4);
        
    
    
    
    circle.setVisible(false);
    
    //se toma la posicion del circulo al cl1ckearlo
    c1.setOnMousePressed(pressMouse(c1));
    //se ejecuta la accion de mover
    c1.setOnMouseDragged(dragMouseInicial(c1, moveTo1));
  
    c2.setOnMousePressed(pressMouse(c2));
    c2.setOnMouseDragged(dragMouse(c2, line1,curva1));
    c3.setOnMousePressed(pressMouse(c3));
    c3.setOnMouseDragged(dragMouseFinal(c3, line2,curva1));
    c4.setOnMousePressed(pressMouse(c4));
    c4.setOnMouseDragged(dragMouseInicial(c4, moveTo2));
    c5.setOnMousePressed(pressMouse(c5));
    c5.setOnMouseDragged(dragMousecurve(c5, curva1));
      
    
    circle.getChildren().addAll(c1,c2,c3,c4,c5);
    return root;
    }
    
    

    
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

    //dragMouse y dragMouseInicial son lo mismo pero uno es para el moveto que es el punto inicial y el otro para el lineto que son el resto de puntos
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
                 l.setY(event.getSceneY()-marco);
                 

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }

    EventHandler<MouseEvent> dragMouse(Circle c, LineTo l, QuadCurve curva) {
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
                 l.setY(event.getSceneY()-marco);
                 curva.setStartX(l.getX());
                 curva.setStartY(l.getY()+reAjuste);

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }

    EventHandler<MouseEvent> dragMouseFinal(Circle c, LineTo l1,QuadCurve curv) {
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
                 l1.setX(event.getSceneX());
                 l1.setY(event.getSceneY()-marco);
                 curv.setEndX(l1.getX());
                 curv.setEndY(l1.getY()+reAjuste);

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }
    EventHandler<MouseEvent> dragMousecurve(Circle c,QuadCurve curv) {
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
                 curv.setControlX(event.getSceneX());
                 curv.setControlY(event.getSceneY()-marco);

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }

    

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }
    
}
