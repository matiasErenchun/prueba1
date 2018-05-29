/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PuntosDeControlYMovimiento.PuntosDeControl;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;

/**
 *
 * @author elias
 * @numbers created by: Matias and Mario
 * @numbersPorted by: elias
 */
public class NumerosYSimbolos extends PuntosDeControl{

    
    
    private double espacio;
    private final double superior;
    private double size; //Tamaño personalizado de los elementos para que todos calcen y tengan mismo tamaño.
    private double xPoint; //Posición en X donde debe ser dibujado el elemento.
    private double yPoint; //Posición en Y donde debe ser dibujado el elemento.
    private double amountOfSymbolsDivide; //Cantidad de elementos que contiene una división.
    private final Path pathActual = new Path();
    private String ID; //Identificador del elemento. Dice qué es.
    private int numDivision; //Indica qué división es la que se está haciendo.
    private String type = "symbol"; //Para identificar si es símbolo o número.
    Group root = new Group();
    

    public NumerosYSimbolos(double marco, double espacio, double superior, boolean puntosVisibles) {
        this.espacio=espacio;
        this.superior=superior;
        this.marco=marco;
        this.puntosVisibles=puntosVisibles;
    }
    /*
    Acá se configuran los números en cuanto a grosor y si son visibles o no los puntos de control.
    */
    public void configura(){
        pathActual.setStrokeWidth(4);
        circle.setVisible(puntosVisibles);
    }
    
    public Group dibujo(String id){
        HLineTo base = new HLineTo();
        QuadCurveTo arco1 = new QuadCurveTo();
        QuadCurveTo arco2 = new QuadCurveTo();
        QuadCurveTo arco3 = new QuadCurveTo();
        QuadCurveTo arco4 = new QuadCurveTo();
        QuadCurveTo arco5 = new QuadCurveTo();
        QuadCurveTo arco6 = new QuadCurveTo();
        QuadCurveTo arco7 = new QuadCurveTo();
        QuadCurveTo arco8 = new QuadCurveTo();
        LineTo base1 = new LineTo();
        LineTo mid2 = new LineTo();
        MoveTo start9 = new MoveTo();
        VLineTo lineaV = new VLineTo();
        VLineTo lineaV2 = new VLineTo();
        LineTo line1 = new LineTo();
        MoveTo moveTo = new MoveTo();
        LineTo line2 = new LineTo();
                
        
        HLineTo htop = new HLineTo();   
        LineTo htop1 = new LineTo();   
        
        switch(id){
    //------------------------------------------------------------------------------------------------------------------//
            case "*":
                ID = "*";
                //Se define el tamaño de la figura.
                size=1.2;
                //Se define la posición de la figura.
                xPoint = (200+espacio);
                yPoint = (150+superior);

                //Se crean las líneas de la figura.
                MoveTo centroMulti = new MoveTo(xPoint, yPoint);
                LineTo line1Multi = new LineTo(xPoint-15*size, yPoint-15*size);
                LineTo line2Multi = new LineTo(xPoint+15*size, yPoint+15*size);
                LineTo line3Multi = new LineTo(xPoint, yPoint-20*size);
                LineTo line4Multi = new LineTo(xPoint, yPoint+20*size);
                LineTo line5Multi = new LineTo(xPoint+15*size, yPoint-15*size);
                LineTo line6Multi = new LineTo(xPoint-15*size, yPoint+15*size);
                LineTo line7Multi = new LineTo(xPoint-20*size, yPoint);
                LineTo line8Multi = new LineTo(xPoint+20*size, yPoint);

                //Se añaden las líneas de la figura a pathActual.
                pathActual.getElements().addAll(centroMulti, line1Multi,centroMulti, line2Multi, centroMulti, line3Multi, centroMulti, line4Multi, centroMulti, line5Multi, centroMulti, line6Multi, centroMulti, line7Multi, centroMulti, line8Multi);

                //Se crean los círculos con la ubicación de las líneas.
                iniciateCircleMoveTo(centroMulti);
                iniciateCircleLineTo(line1Multi);
                iniciateCircleLineTo(line2Multi);
                iniciateCircleLineTo(line3Multi);
                iniciateCircleLineTo(line4Multi);
                iniciateCircleLineTo(line5Multi);
                iniciateCircleLineTo(line6Multi);
                iniciateCircleLineTo(line7Multi);
                iniciateCircleLineTo(line8Multi);

                //Se crea un nuevo grupo llamado root, el cual contendrá a los puntos de control (círculos) y a la figura.
                root.getChildren().addAll(pathActual, circle);
                configura();

                //Se regresa el grupo a la pizarra, donde serán agregadas.
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "(":
                ID = "(";
                size=1.2;
                double amountOfSymbolsParen1 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
                xPoint = (200+espacio);
                yPoint = (150+superior);

                Arc arc1Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,90,90);
                Arc arc2Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,180,90);

                configuraArco(arc1Paren1);
                configuraArco(arc2Paren1);

                createCircle(arc1Paren1.getCenterX(), arc1Paren1.getCenterY()-42*amountOfSymbolsParen1);
                createCircle(arc2Paren1.getCenterX()-7.5*amountOfSymbolsParen1, arc2Paren1.getCenterY());
                createCircle(arc2Paren1.getCenterX(), arc2Paren1.getCenterY()+42*amountOfSymbolsParen1);

                configura();
                root.getChildren().addAll(arc1Paren1, arc2Paren1, circle);

                return root;
    //------------------------------------------------------------------------------------------------------------------//                
            case ")":
                ID = ")";
                size=1.2;
                double amountOfSymbolsParen2 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
                xPoint = (200+espacio);
                yPoint = (150+superior);

                Arc arc1Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,270,90);
                Arc arc2Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,360,90);

                configuraArco(arc1Paren2);
                configuraArco(arc2Paren2);

                createCircle(arc1Paren2.getCenterX(), arc1Paren2.getCenterY()-42*amountOfSymbolsParen2);
                createCircle(arc2Paren2.getCenterX()+7.5*amountOfSymbolsParen2, arc2Paren2.getCenterY());
                createCircle(arc2Paren2.getCenterX(), arc2Paren2.getCenterY()+42*amountOfSymbolsParen2);


                root.getChildren().addAll(arc1Paren2, arc2Paren2, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "-":
                ID = "-";
                size=1.2;
                xPoint = (200+espacio);
                yPoint = (150+superior);

                MoveTo startMinus = new MoveTo(xPoint, yPoint);
                LineTo line1Minus = new LineTo(xPoint-20*size, yPoint);
                LineTo line2Minus = new LineTo(xPoint+20*size, yPoint);

                pathActual.getElements().addAll(startMinus, line1Minus, startMinus, line2Minus);

                iniciateCircleMoveTo(startMinus);
                iniciateCircleLineTo(line1Minus);
                iniciateCircleLineTo(line2Minus);

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "+":
                ID = "+";
                size = 1.2;
                xPoint = (200+espacio);
                yPoint = (150+superior);

                MoveTo startPlus = new MoveTo(xPoint, yPoint);
                LineTo line1Plus = new LineTo(xPoint+20*size, yPoint);
                LineTo line2Plus = new LineTo(xPoint-20*size, yPoint);
                LineTo line3Plus = new LineTo(xPoint, yPoint+20*size);
                LineTo line4Plus = new LineTo(xPoint, yPoint-20*size);

                pathActual.getElements().addAll(startPlus, line1Plus, startPlus, line2Plus, startPlus, line3Plus, startPlus, line4Plus);

                iniciateCircleMoveTo(startPlus);
                iniciateCircleLineTo(line1Plus);
                iniciateCircleLineTo(line2Plus);
                iniciateCircleLineTo(line3Plus);
                iniciateCircleLineTo(line4Plus);

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "0":
                type = "number";
                ID = "0";
                size=1.28;
                xPoint = (190+espacio);
                yPoint = (150+superior);

                Arc arcZero = new Arc(xPoint, yPoint,25*size,40*size,90,90);
                Arc arc1Zero = new Arc(xPoint, yPoint,25*size,40*size,180,90);
                Arc arc2Zero = new Arc(xPoint, yPoint,25*size,40*size,270,90);
                Arc arc3Zero = new Arc(xPoint, yPoint,25*size,40*size,360,90);

                configuraArco(arcZero);
                configuraArco(arc1Zero);
                configuraArco(arc2Zero);
                configuraArco(arc3Zero);

                createCircle(arcZero.getCenterX(), arcZero.getCenterY()-40*size);
                createCircle(arc1Zero.getCenterX()+25*size, arc1Zero.getCenterY());
                createCircle(arc2Zero.getCenterX(), arc2Zero.getCenterY()+40*size);
                createCircle(arc3Zero.getCenterX()-25*size, arc3Zero.getCenterY());

                root.getChildren().addAll(arcZero, arc1Zero, arc2Zero, arc3Zero, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "1":
                type = "number";
                ID = "1";
                xPoint = (215+espacio);
                yPoint = (200+superior);

                MoveTo p1=new MoveTo(xPoint,yPoint);
                LineTo p2= new LineTo(xPoint,yPoint-100);
                LineTo p3= new LineTo(xPoint-50,yPoint-50);


                pathActual.getElements().addAll(p1,p2,p3);

                createCircle(p1.getX(),p1.getY()+marco);
                createCircle(p2.getX(),p2.getY()+marco);
                createCircle(p3.getX(),p3.getY()+marco);

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "2":
                type = "number";
                ID = "2";
                xPoint = (170+espacio);
                yPoint = (125+superior);
                MoveTo start2 = new MoveTo();
                start2.setX(xPoint);
                start2.setY(yPoint);

                base.setX(xPoint+50);

                LineTo diagonal = new LineTo();
                diagonal.setX(xPoint);
                diagonal.setY(yPoint+75);

                QuadCurveTo primerArco = new QuadCurveTo();
                primerArco.setX(xPoint+25);
                primerArco.setY(yPoint-25);
                primerArco.setControlX(xPoint);
                primerArco.setControlY(yPoint-25);


                QuadCurveTo segundoArco = new QuadCurveTo();
                segundoArco.setX(xPoint+50);
                segundoArco.setY(yPoint);
                segundoArco.setControlX(xPoint+50);
                segundoArco.setControlY(yPoint-25);

                createCircle(start2.getX(), start2.getY()+marco);
                createCircle(primerArco.getX(), primerArco.getY()+marco);
                createCircle(segundoArco.getX(), segundoArco.getY()+marco);
                createCircle(diagonal.getX(), diagonal.getY()+marco);
                createCircle(base.getX(),yPoint+75+marco);

                pathActual.getElements().addAll(start2,primerArco,segundoArco,diagonal,base);
                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "3":
                type = "number";
                ID = "3";
                xPoint = (175+espacio);
                yPoint = (200+superior);

                MoveTo start3 = new MoveTo();
                start3.setX(xPoint);
                start3.setY(yPoint);

                
                base.setX(xPoint+10);

                arco1.setX(xPoint+40);
                arco1.setY(yPoint-25);
                arco1.setControlX(xPoint+40);
                arco1.setControlY(yPoint);


                arco2.setX(xPoint+10);
                arco2.setY(yPoint-50);
                arco2.setControlX(xPoint+40);
                arco2.setControlY(yPoint-50);

                arco3.setX(xPoint+40);
                arco3.setY(yPoint-75);
                arco3.setControlX(xPoint+40);
                arco3.setControlY(yPoint-50);


                arco4.setX(xPoint+10);
                arco4.setY(yPoint-100);
                arco4.setControlX(xPoint+40);
                arco4.setControlY(yPoint-100);

                htop.setX(xPoint);


                createCircle(start3.getX(), start3.getY()+marco);
                createCircle(arco1.getX(), arco1.getY()+marco);
                createCircle(arco2.getX(), arco2.getY()+marco);
                createCircle(arco3.getX(), arco3.getY()+marco);
                createCircle(arco4.getX()-7, arco4.getY()+marco);



                pathActual.getElements().addAll(start3,base,arco1,arco2,arco3,arco4,htop);      
                root.getChildren().addAll(pathActual, circle);  
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "4":
                type = "number";
                ID = "4";
                size=1.7;
                xPoint = (195+espacio);
                yPoint = (150+superior);

                moveTo.setX(xPoint-15*size); moveTo.setY(yPoint-30*size);
                line1.setX(xPoint-15*size); line1.setY(yPoint);
                line2.setX(xPoint+15*size); line2.setY(yPoint);
                MoveTo moveTo2 = new MoveTo(xPoint+15*size, yPoint-30*size);
                LineTo line3 = new LineTo(xPoint+15*size, yPoint+30*size);

                pathActual.getElements().addAll(moveTo,line1, line2,moveTo2,line3);

                iniciateCircleMoveTo(moveTo);
                iniciateCircleLineTo(line1);
                iniciateCircleLineTo(line2);
                iniciateCircleMoveTo(moveTo2);
                iniciateCircleLineTo(line3);

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "5":
                type = "number";
                ID = "5";
                xPoint = (200+espacio);
                yPoint = (200+superior);

                MoveTo start5 = new MoveTo();
                start5.setX(xPoint-20);
                start5.setY(yPoint);

                arco1.setX(xPoint-20);
                arco1.setY(yPoint);
                arco1.setControlX(xPoint-30);
                arco1.setControlY(yPoint);

                base.setX(xPoint);

                arco2.setX(xPoint+20);
                arco2.setY(yPoint-30);
                arco2.setControlX(xPoint+20);
                arco2.setControlY(yPoint);

                arco3.setX(xPoint);
                arco3.setY(yPoint-60);
                arco3.setControlX(xPoint+20);
                arco3.setControlY(yPoint-60);

                HLineTo hmid = new HLineTo();
                hmid.setX(xPoint-30);

                VLineTo vline = new VLineTo();
                vline.setY(yPoint-100);

                htop.setX(xPoint+20);

                pathActual.getElements().addAll(start5,arco1,base,arco2,arco3,hmid,vline,htop);

                createCircle(start5.getX(), start5.getY()+marco);
                createCircle(arco1.getX(), arco1.getY()+marco);
                createCircle(base.getX(), arco1.getY()+marco);
                createCircle(arco2.getX(), arco2.getY()+marco);
                createCircle(arco3.getX(), arco3.getY()+marco);
                createCircle(hmid.getX(), vline.getY()+marco);
                createCircle(htop.getX(), vline.getY()+marco);
                createCircle(hmid.getX(), arco3.getY()+marco);

                configura();        
                root.getChildren().addAll(pathActual, circle);
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "6":
                type = "number";
                ID = "6";
                xPoint = (200+espacio);
                yPoint = (200+superior);

                MoveTo start6 = new MoveTo();
                start6.setX(xPoint-30);
                start6.setY(yPoint-25);

                arco1.setX(xPoint-5);
                arco1.setY(yPoint);
                arco1.setControlX(xPoint-30);
                arco1.setControlY(yPoint);


                arco2.setX(xPoint+20);
                arco2.setY(yPoint-25);
                arco2.setControlX(xPoint+20);
                arco2.setControlY(yPoint);

                arco3.setX(xPoint-5);
                arco3.setY(yPoint-50);
                arco3.setControlX(xPoint+20);
                arco3.setControlY(yPoint-50);

                arco4.setX(xPoint-30);
                arco4.setY(yPoint-25);
                arco4.setControlX(xPoint-30);
                arco4.setControlY(yPoint-50);

                arco5.setX(xPoint);
                arco5.setY(yPoint-100);
                arco5.setControlX(xPoint-25);
                arco5.setControlY(yPoint-90);

                pathActual.getElements().addAll(start6,arco1,arco2,arco3,arco4,arco5);

                createCircle(start6.getX(), start6.getY()+marco);
                createCircle(arco1.getX(), arco1.getY()+marco);
                createCircle(arco2.getX(), arco2.getY()+marco);
                createCircle(arco3.getX(), arco3.getY()+marco);
                createCircle(arco4.getX(), arco4.getY()+marco);
                createCircle(arco5.getX(), arco5.getY()+marco);

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "7":
                type = "number";
                ID = "7";
                xPoint = (215+espacio);
                yPoint = (200+superior);
                MoveTo start7 = new MoveTo();
                start7.setX(xPoint-50);
                start7.setY(yPoint);

                LineTo diagonal1 = new LineTo();
                diagonal1.setX(xPoint-25);
                diagonal1.setY(yPoint-50);

                HLineTo hMidLine1 = new HLineTo();
                hMidLine1.setX(xPoint);

                HLineTo hMidLine2 = new HLineTo();
                hMidLine2.setX(xPoint-50);

                HLineTo hMidLine3 = new HLineTo();
                hMidLine3.setX(xPoint-25);

                LineTo diagonal2 = new LineTo();
                diagonal2.setX(xPoint);
                diagonal2.setY(yPoint-100);

                HLineTo lineaTop = new HLineTo();
                lineaTop.setX(xPoint-50);


                iniciateCircleMoveTo(start7);
                iniciateCircleLineTo(diagonal1);
                iniciateCircleLineTo(diagonal2);
                createCircle(hMidLine1.getX(), diagonal1.getY()+marco);
                createCircle(hMidLine2.getX(), diagonal1.getY()+marco);
                createCircle(hMidLine2.getX(), diagonal2.getY()+marco);

                pathActual.getElements().addAll(start7, diagonal1, hMidLine1, hMidLine2, hMidLine3, diagonal2, lineaTop);
                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "8":
                type = "number";
                ID = "8";
                xPoint = (215+espacio);
                yPoint = (200+superior);

                MoveTo start8 = new MoveTo();
                start8.setX(xPoint-50);
                start8.setY(yPoint-25);

                arco1.setX(xPoint-30);
                arco1.setY(yPoint);
                arco1.setControlX(xPoint-50);
                arco1.setControlY(yPoint);

                base1.setX(xPoint-30);
                base1.setY(yPoint);

                arco2.setX(xPoint);
                arco2.setY(yPoint-25);
                arco2.setControlX(xPoint);
                arco2.setControlY(yPoint);

                arco3.setX(xPoint-20);
                arco3.setY(yPoint-50);
                arco3.setControlX(xPoint);
                arco3.setControlY(yPoint-50);

                LineTo mid1 = new LineTo();
                mid1.setX(xPoint-30);
                mid1.setY(yPoint-50);

                arco4.setX(xPoint-50);
                arco4.setY(yPoint-75);
                arco4.setControlX(xPoint-50);
                arco4.setControlY(yPoint-50);

                arco5.setX(xPoint-30);
                arco5.setY(yPoint-100);
                arco5.setControlX(xPoint-50);
                arco5.setControlY(yPoint-100);

                htop1.setX(xPoint-20);
                htop1.setY(yPoint-100);

                arco6.setX(xPoint);
                arco6.setY(yPoint-75);
                arco6.setControlX(xPoint);
                arco6.setControlY(yPoint-100);

                arco7.setX(xPoint-20);
                arco7.setY(yPoint-50);
                arco7.setControlX(xPoint);
                arco7.setControlY(yPoint-50);

                mid2.setX(xPoint-30);
                mid2.setY(yPoint-50);

                arco8.setX(xPoint-50);
                arco8.setY(yPoint-25);
                arco8.setControlX(xPoint-50);
                arco8.setControlY(yPoint-50);


                createCircle(mid2.getX()+5, mid2.getY()+marco);
                createCircle(arco1.getX()+5, arco1.getY()+marco);
                createCircle(arco2.getX(), arco2.getY()+marco);
                createCircle(arco4.getX(), arco4.getY()+marco);
                createCircle(arco5.getX()+5, arco5.getY()+marco);
                createCircle(arco6.getX(), arco6.getY()+marco);
                createCircle(arco8.getX(), arco8.getY()+marco);

                pathActual.getElements().addAll(start8,arco1,base1,arco2,arco3,mid1,arco4,arco5,htop1,arco6,arco7,mid2,arco8);
                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "9":
                type = "number";
                ID = "9";
                xPoint = (215+espacio);
                yPoint = (200+superior);

                start9.setX(xPoint-50);
                start9.setY(yPoint-75);

                arco1.setX(xPoint-25);
                arco1.setY(yPoint-50);
                arco1.setControlX(xPoint-50);
                arco1.setControlY(yPoint-50);


                arco2.setX(xPoint);
                arco2.setY(yPoint-75);
                arco2.setControlX(xPoint);
                arco2.setControlY(yPoint-50);

                lineaV.setY(yPoint);

                lineaV2.setY(yPoint-75);

                arco3.setX(xPoint-25);
                arco3.setY(yPoint-100);
                arco3.setControlX(xPoint);
                arco3.setControlY(yPoint-100);

                arco4.setX(xPoint-50);
                arco4.setY(yPoint-75);
                arco4.setControlX(xPoint-50);
                arco4.setControlY(yPoint-100);

                iniciateCircleMoveTo(start9);
                createCircle(arco1.getX(), arco1.getY()+marco);
                createCircle(arco2.getX(), arco2.getY()+marco);
                createCircle(arco3.getX(), arco3.getY()+marco);
                createCircle(arco4.getX(), arco4.getY()+marco);
                createCircle(arco2.getX(), lineaV.getY());

                pathActual.getElements().addAll(start9, arco1, arco2, lineaV, lineaV2, arco3, arco4);
                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "!":
                ID = "!";
                size=1;
                xPoint = (200+espacio);
                yPoint = (200+superior);

                MoveTo startPuntoFactorial = new MoveTo();
                startPuntoFactorial.setX(xPoint-25);
                startPuntoFactorial.setY(yPoint-5);

                line1.setX(xPoint-25);
                line1.setY(yPoint-15);

                MoveTo startBarraFactorial = new MoveTo();
                startBarraFactorial.setX(xPoint-25);
                startBarraFactorial.setY(yPoint-25);

                line2.setX(xPoint-25);
                line2.setY(yPoint-95);

                pathActual.getElements().addAll(startPuntoFactorial, line1, startBarraFactorial, line2);

                iniciateCircleMoveTo(startPuntoFactorial);
                iniciateCircleLineTo(line1);
                iniciateCircleMoveTo(startBarraFactorial);
                iniciateCircleLineTo(line2);

                configura();
                root.getChildren().addAll(pathActual, circle);

                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "cos":
                ID = "cos";
                dibujarC();
                espacio+=90;
                dibujarO();
                espacio+=90;
                dibujarS();
                espacio+=90;

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "sen":
                ID = "sen";
                dibujarS();
                espacio+=90;
                dibujarE();
                espacio+=90;
                dibujarN();

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "tan":
                ID = "tan";
                dibujarT();
                espacio+=90;
                dibujarA();
                espacio+=90;
                dibujarN();

                root.getChildren().addAll(pathActual, circle);
                configura();

                return root;
    //------------------------------------------------------------------------------------------------------------------//
            case "^":
                ID = "^";
                size=1;
                xPoint = (200+espacio);
                yPoint = (200+superior);

                MoveTo startElevado = new MoveTo();
                startElevado.setX(xPoint-40);
                startElevado.setY(yPoint-70);

                line1.setX(xPoint-25);
                line1.setY(yPoint-95);

                line2.setX(xPoint-10);
                line2.setY(yPoint-70);

                pathActual.getElements().addAll(startElevado, line1, line2);

                iniciateCircleMoveTo(startElevado);
                iniciateCircleLineTo(line1);
                iniciateCircleLineTo(line2);

                root.getChildren().addAll(pathActual, circle);
                configura();
                return root;
    //------------------------------------------------------------------------------------------------------------------//
        }
        return null;
    }
    
    public Group division(double endPoint) {
        ID = "/";
        size=1.2;
        this.amountOfSymbolsDivide=amountOfSymbolsDivide;
        xPoint = (155+espacio);
        yPoint = (superior);
        this.numDivision = numDivision; //Número de la división. (Orden)

        MoveTo startDivide = new MoveTo(xPoint, yPoint+150);
        //Por cada número que aumente en amountOfSymbolsDivide, la linea de división aumenta en 90.
        LineTo line2Divide = new LineTo(xPoint+90, yPoint+150);

        pathActual.setStrokeWidth(4*size);   
        pathActual.getElements().addAll(startDivide, line2Divide);
        
        iniciateCircleMoveTo(startDivide);
        iniciateCircleLineTo(line2Divide);
        
        root.getChildren().addAll(pathActual, circle);        
        configura();      
        return root;
    }
    
    public Group multiplicacion() {
        //Se establece el ID de una multiplicación.
        ID = "*";
        //Se define el tamaño de la figura.
        size=1.2;
        //Se define la posición de la figura.
        xPoint = (200+espacio);
        yPoint = (150+superior);
        
        //Se crean las líneas de la figura.
        MoveTo centroMulti = new MoveTo(xPoint, yPoint);
        LineTo line1Multi = new LineTo(xPoint-15*size, yPoint-15*size);
        LineTo line2Multi = new LineTo(xPoint+15*size, yPoint+15*size);
        LineTo line3Multi = new LineTo(xPoint, yPoint-20*size);
        LineTo line4Multi = new LineTo(xPoint, yPoint+20*size);
        LineTo line5Multi = new LineTo(xPoint+15*size, yPoint-15*size);
        LineTo line6Multi = new LineTo(xPoint-15*size, yPoint+15*size);
        LineTo line7Multi = new LineTo(xPoint-20*size, yPoint);
        LineTo line8Multi = new LineTo(xPoint+20*size, yPoint);

        //Se añaden las líneas de la figura a pathActual.
        pathActual.getElements().addAll(centroMulti, line1Multi,centroMulti, line2Multi, centroMulti, line3Multi, centroMulti, line4Multi, centroMulti, line5Multi, centroMulti, line6Multi, centroMulti, line7Multi, centroMulti, line8Multi);
        
        //Se crean los círculos con la ubicación de las líneas.
        iniciateCircleMoveTo(centroMulti);
        iniciateCircleLineTo(line1Multi);
        iniciateCircleLineTo(line2Multi);
        iniciateCircleLineTo(line3Multi);
        iniciateCircleLineTo(line4Multi);
        iniciateCircleLineTo(line5Multi);
        iniciateCircleLineTo(line6Multi);
        iniciateCircleLineTo(line7Multi);
        iniciateCircleLineTo(line8Multi);
      
        //Se crea un nuevo grupo llamado root, el cual contendrá a los puntos de control (círculos) y a la figura.
        root.getChildren().addAll(pathActual, circle);
        configura();
        
        //Se regresa el grupo a la pizarra, donde serán agregadas.
        return root;
    }
    
    public Group parentesis1() {
        ID = "(";
        size=1.2;
        double amountOfSymbolsParen1 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        xPoint = (200+espacio);
        yPoint = (150+superior);

        Arc arc1Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,90,90);
        Arc arc2Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,180,90);

        configuraArco(arc1Paren1);
        configuraArco(arc2Paren1);
        
        createCircle(arc1Paren1.getCenterX(), arc1Paren1.getCenterY()-42*amountOfSymbolsParen1);
        createCircle(arc2Paren1.getCenterX()-7.5*amountOfSymbolsParen1, arc2Paren1.getCenterY());
        createCircle(arc2Paren1.getCenterX(), arc2Paren1.getCenterY()+42*amountOfSymbolsParen1);
        
        configura();
        root.getChildren().addAll(arc1Paren1, arc2Paren1, circle);
                
        return root;
    }
    
    public Group parentesis2() {
        ID = ")";
        size=1.2;
        double amountOfSymbolsParen2 = (double) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
        xPoint = (200+espacio);
        yPoint = (150+superior);

        Arc arc1Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,270,90);
        Arc arc2Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,360,90);

        configuraArco(arc1Paren2);
        configuraArco(arc2Paren2);
        
        createCircle(arc1Paren2.getCenterX(), arc1Paren2.getCenterY()-42*amountOfSymbolsParen2);
        createCircle(arc2Paren2.getCenterX()+7.5*amountOfSymbolsParen2, arc2Paren2.getCenterY());
        createCircle(arc2Paren2.getCenterX(), arc2Paren2.getCenterY()+42*amountOfSymbolsParen2);

        
        root.getChildren().addAll(arc1Paren2, arc2Paren2, circle);
        configura();
        return root;
    }
    
    public Group resta() {
        ID = "-";
        size=1.2;
        xPoint = (200+espacio);
        yPoint = (150+superior);

        MoveTo startMinus = new MoveTo(xPoint, yPoint);
        LineTo line1Minus = new LineTo(xPoint-20*size, yPoint);
        LineTo line2Minus = new LineTo(xPoint+20*size, yPoint);
      
        pathActual.getElements().addAll(startMinus, line1Minus, startMinus, line2Minus);

        iniciateCircleMoveTo(startMinus);
        iniciateCircleLineTo(line1Minus);
        iniciateCircleLineTo(line2Minus);
      
        root.getChildren().addAll(pathActual, circle);
        configura();
        return root;
    }
    
    public Group suma() {
        ID = "+";
        size = 1.2;
        xPoint = (200+espacio);
        yPoint = (150+superior);

        MoveTo startPlus = new MoveTo(xPoint, yPoint);
        LineTo line1Plus = new LineTo(xPoint+20*size, yPoint);
        LineTo line2Plus = new LineTo(xPoint-20*size, yPoint);
        LineTo line3Plus = new LineTo(xPoint, yPoint+20*size);
        LineTo line4Plus = new LineTo(xPoint, yPoint-20*size);

        pathActual.getElements().addAll(startPlus, line1Plus, startPlus, line2Plus, startPlus, line3Plus, startPlus, line4Plus);
       
        iniciateCircleMoveTo(startPlus);
        iniciateCircleLineTo(line1Plus);
        iniciateCircleLineTo(line2Plus);
        iniciateCircleLineTo(line3Plus);
        iniciateCircleLineTo(line4Plus);

        root.getChildren().addAll(pathActual, circle);
        configura();
        return root;
    }
    
    public void dibujarC()
    {
        xPoint = (200+espacio);
        yPoint = (200+superior);
        
        MoveTo startC = new MoveTo();
        startC.setX((xPoint-50));
        startC.setY((yPoint-30));
        
        
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((xPoint-50));
        arco1.setControlY((yPoint-60));
        arco1.setX((xPoint-25));
        arco1.setY((yPoint-60));
        
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((xPoint));
        arco2.setControlY((yPoint-60));
        arco2.setX((xPoint));
        arco2.setY((yPoint-40));
        
        
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((xPoint));
        arco3.setControlY((yPoint-60));
        arco3.setX((xPoint-25));
        arco3.setY((yPoint-60));
        
        
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((xPoint-50));
        arco4.setControlY((yPoint-60));
        arco4.setX((xPoint-50));
        arco4.setY((yPoint-30));
        
        
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setControlX((xPoint-50));
        arco5.setControlY((yPoint));
        arco5.setX((xPoint-25));
        arco5.setY((yPoint));
        
        
        
        QuadCurveTo arco6 = new QuadCurveTo();
        arco6.setControlX((xPoint));
        arco6.setControlY((yPoint));
        arco6.setX((xPoint));
        arco6.setY((yPoint-20));
        
        
        createCircle(startC.getX(), startC.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(),arco4.getY()+marco);
        createCircle(arco5.getX(),arco5.getY()+marco);
        createCircle(arco6.getX(),arco6.getY()+marco);

        pathActual.getElements().addAll(startC,arco1,arco2,arco3,arco4,arco5, arco6);
  
    }
  
    public void dibujarE()
    {
        xPoint = (200+espacio);
        yPoint = (200+superior);
        MoveTo startE = new MoveTo();
        startE.setX((xPoint-50));
        startE.setY((yPoint-35));
        
        
        
        LineTo midE = new LineTo();
        midE.setX((xPoint));
        midE.setY((yPoint-35));
        
        
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((xPoint));
        arco1.setControlY((yPoint-60));
        arco1.setX((xPoint-25));
        arco1.setY((yPoint-60));
        
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((xPoint-50));
        arco2.setControlY((yPoint-60));
        arco2.setX((xPoint-50));
        arco2.setY((yPoint-35));
        
       
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((xPoint-50));
        arco3.setControlY((yPoint));
        arco3.setX((xPoint-25));
        arco3.setY((yPoint));
        
        
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((xPoint));
        arco4.setControlY((yPoint));
        arco4.setX((xPoint));
        arco4.setY((yPoint-20));
        
        
        createCircle(startE.getX(), startE.getY()+marco);
        createCircle(midE.getX(), midE.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(),arco4.getY()+marco);
        
        pathActual.getElements().addAll(startE,midE,arco1,arco2,arco3,arco4);
        
    }
    
    public void dibujarT()
    {
        xPoint = (200+espacio);
        yPoint = (200+superior);
        
        MoveTo startT = new MoveTo();
        startT.setX(xPoint-50);
        startT.setY(yPoint-70);
        
        LineTo linea1 = new LineTo();
        linea1.setX(xPoint-25);
        linea1.setY(yPoint-70);
        
        LineTo linea2 = new LineTo();
        linea2.setX(xPoint);
        linea2.setY(yPoint-70);
        
        LineTo linea3 = new LineTo();
        linea3.setX(xPoint-25);
        linea3.setY(yPoint-70);
        
        LineTo linea4 = new LineTo();
        linea4.setX(xPoint-25);
        linea4.setY(yPoint);
        
         pathActual.setStrokeWidth(4);
        
        createCircle(startT.getX(), startT.getY()+marco);
        createCircle(linea1.getX(), linea1.getY()+marco);
        createCircle(linea2.getX(), linea2.getY()+marco);
        createCircle(linea3.getX(), linea3.getY()+marco);
        createCircle(linea4.getX(), linea4.getY()+marco);

        pathActual.getElements().addAll(startT,linea1,linea2,linea3,linea4);
        
    }
  
    public void dibujarA()
    {
        xPoint = (200+espacio);
        yPoint = (200+superior);
        
        MoveTo startA = new MoveTo();
        startA.setX((xPoint-50));
        startA.setY((yPoint-50));
        
        
         
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((xPoint-50));
        arco1.setControlY((yPoint-60));
        arco1.setX((xPoint-30));
        arco1.setY((yPoint-60));
        
        
        
        LineTo top = new LineTo();
        top.setX((xPoint-20));
        top.setY((yPoint-60));
        
        
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((xPoint-10));
        arco2.setControlY((yPoint-60));
        arco2.setX((xPoint-10));
        arco2.setY((yPoint-50));
        
        
        
        LineTo verti1 = new LineTo();
        verti1.setX((xPoint-10));
        verti1.setY((yPoint-40));
        
        
        
        LineTo verti2 = new LineTo();
        verti2.setX((xPoint-10));
        verti2.setY((yPoint-15));
        
        
        
        QuadCurveTo hori1 = new QuadCurveTo();
        hori1.setControlX((xPoint-10));
        hori1.setControlY((yPoint-5));
        hori1.setX((xPoint-20));
        hori1.setY((yPoint));
        
        
        
        LineTo base = new LineTo();
        base.setX((xPoint-40));
        base.setY((yPoint));
        
        
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((xPoint-50));
        arco3.setControlY((yPoint));
        arco3.setX((xPoint-50));
        arco3.setY((yPoint-20));
        
        
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((xPoint-50));
        arco4.setControlY((yPoint-40));
        arco4.setX((xPoint-30));
        arco4.setY((yPoint-40));
        
        
        
        
        LineTo mid = new LineTo();
        mid.setX((xPoint-10));
        mid.setY((yPoint-40));
        
        
        
        LineTo verti3 = new LineTo();
        verti3.setX((xPoint-10));
        verti3.setY((yPoint-15));
        
        
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setControlX((xPoint-10));
        arco5.setControlY((yPoint-5));
        arco5.setX((xPoint));
        arco5.setY((yPoint));
        
        
        createCircle(startA.getX(), startA.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(top.getX(), top.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(verti1.getX(), verti1.getY()+marco);
        createCircle(verti2.getX(), verti2.getY()+marco);
        createCircle(hori1.getX(), hori1.getY()+marco);
        createCircle(base.getX(), base.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(),arco4.getY()+marco);
        createCircle(mid.getX(), mid.getY()+marco);
        createCircle(verti3.getX(), verti3.getY()+marco);
        createCircle(arco5.getX(),arco5.getY()+marco);
       
        pathActual.getElements().addAll(startA,arco1,top,arco2,verti1,verti2,hori1,base,arco3,arco4,mid,verti3,arco5);

       
    }
    
    
    public void dibujarO()
    {
        xPoint = (200+espacio);
        yPoint = (200+superior);
        
        MoveTo startO = new MoveTo();
        startO.setX((xPoint-50));
        startO.setY((yPoint-30));
        
        
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((xPoint-50));
        arco1.setControlY((yPoint-60));
        arco1.setX((xPoint-25));
        arco1.setY((yPoint-60));
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((xPoint));
        arco2.setControlY((yPoint-60));
        arco2.setX((xPoint));
        arco2.setY((yPoint-30));
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((xPoint));
        arco3.setControlY((yPoint));
        arco3.setX((xPoint-25));
        arco3.setY((yPoint));
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((xPoint-50));
        arco4.setControlY((yPoint));
        arco4.setX((xPoint-50));
        arco4.setY((yPoint-30));
                
        
        createCircle(startO.getX(), startO.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(), arco4.getY()+marco);
        
        pathActual.getElements().addAll(startO,arco1,arco2,arco3,arco4);
  
    }
    
    public void dibujarN()
    {
        xPoint = (200+espacio);
        yPoint = (200+superior);
        
        MoveTo startN = new MoveTo();
        startN.setX((xPoint-50));
        startN.setY((yPoint));
        
        LineTo line1 =new LineTo();
        line1.setX(xPoint-50);
        line1.setY(yPoint-60);
        
        LineTo line2 =new LineTo();
        line2.setX(xPoint-50);
        line2.setY(yPoint-35);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((xPoint-25));
        arco1.setControlY((yPoint-80));
        arco1.setX((xPoint));
        arco1.setY((yPoint-35));
        
        LineTo line3 =new LineTo();
        line3.setX(xPoint);
        line3.setY(yPoint);
        
        
        createCircle(startN.getX(), startN.getY()+marco);
        createCircle(line1.getX(), line1.getY()+marco);
        createCircle(line2.getX(), line2.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(line3.getX(), line3.getY()+marco);
        
        pathActual.getElements().addAll(startN,line1,line2,arco1,line3);
    }
    
    public void dibujarS()
    {
        xPoint = (200+espacio);
        yPoint = (200+superior);
        
        MoveTo startS = new MoveTo();
        startS.setX((xPoint-50));
        startS.setY((yPoint-15));
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((xPoint-50));
        arco1.setControlY((yPoint));
        arco1.setX((xPoint-25));
        arco1.setY((yPoint));
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((xPoint));
        arco2.setControlY((yPoint));
        arco2.setX((xPoint));
        arco2.setY((yPoint-15));
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((xPoint));
        arco3.setControlY((yPoint-30));
        arco3.setX((xPoint-25));
        arco3.setY((yPoint-30));
        
         QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((xPoint-50));
        arco4.setControlY((yPoint-30));
        arco4.setX((xPoint-50));
        arco4.setY((yPoint-45));
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setControlX((xPoint-50));
        arco5.setControlY((yPoint-60));
        arco5.setX((xPoint-25));
        arco5.setY((yPoint-60));
        
         QuadCurveTo arco6 = new QuadCurveTo();
        arco6.setControlX((xPoint));
        arco6.setControlY((yPoint-60));
        arco6.setX((xPoint));
        arco6.setY((yPoint-50));
        
        createCircle(startS.getX(), startS.getY()+marco);
        createCircle(arco1.getX(), arco1.getY()+marco);
        createCircle(arco2.getX(), arco2.getY()+marco);
        createCircle(arco3.getX(), arco3.getY()+marco);
        createCircle(arco4.getX(), arco4.getY()+marco);
        createCircle(arco5.getX(), arco5.getY()+marco);
        createCircle(arco6.getX(), arco6.getY()+marco);
        
        pathActual.getElements().addAll(startS,arco1,arco2,arco3,arco4,arco5,arco6);
    }
    public void setSize(double size){
        root.setScaleX(size);
        root.setScaleY(size);
    }

    //Sólo para arcos. Se configuran algunos detalles de los arcos, como el color, relleno y grosor.
    protected void configuraArco (Arc arc) {
        arc.setStroke(Color.BLACK);
        arc.setFill(null);
        arc.setStrokeWidth(4);
    }
    //Retorna el Path que contiene a un elemento y sus puntos de control.
    public Path getPath(){
        return pathActual;
    }
    //Retorna el identidficador del elemento.
    public String getID() {
        return ID;
    }
    //Retorna la posición en X de un elemento.
    public double getxPoint() {
        return xPoint;
    }
    //Retorna la posición en Y de un elemento.
    public double getyPoint() {
        return yPoint;
    }
    //Retorna la cantidad de elementos de una división.
    public double getAmountOfSymbolsDivide() {
        return amountOfSymbolsDivide;
    }
    //Permite cambiar el valor identificador de un elemento. Utilizado únicamente para división abierta y completa.
    public void setID(String ID) {
        this.ID = ID;
    }
    //Retorna el numero de división.
    public int getNumDivision() {
        return numDivision;
    }

    public String getType() {
        return type;
    }

}
