/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;

/**
 *
 * @author Matias.Erenchun
 */
public class Number extends Dibujo
{

    public Number(float f) 
    {
        super(f);
        
    }
    
    public Path draw2(double x,double y,Path miPath)
    {
        this.setElement("2");
        MoveTo start2 = new MoveTo();
        start2.setX((150+x)*this.factorResize);
        start2.setY((125+y)*this.factorResize);
        
        this.addPathElementList(start2);
        
        LineTo base = new LineTo();
        base.setX((200+x)*this.factorResize);
        base.setY((200+y)*this.factorResize);
        
        this.addPathElementList(base);
        
        LineTo diagonal = new LineTo();
        diagonal.setX((150+x)*this.factorResize);
        diagonal.setY((200+y)*this.factorResize);
        
        this.addPathElementList(diagonal);
        
        QuadCurveTo primerArco = new QuadCurveTo();
        primerArco.setX((175+x)*this.factorResize);
        primerArco.setY((100+y)*this.factorResize);
        primerArco.setControlX((150+x)*this.factorResize);
        primerArco.setControlY((100+y)*this.factorResize);
        
        this.addPathElementList(primerArco);
        
        QuadCurveTo segundoArco = new QuadCurveTo();
        segundoArco.setX((200+x)*this.factorResize);
        segundoArco.setY((125+y)*this.factorResize);
        segundoArco.setControlX((200+x)*this.factorResize);
        segundoArco.setControlY((100+y)*this.factorResize);
        
        this.addPathElementList(segundoArco);
        
        this.setDawnPoint(base.getY());
        this.setTopPoint(primerArco.getY());
        this.setStartPoint(start2.getX());
        this.setEndPoint(base.getX());
        
         miPath.getElements().addAll(start2,primerArco,segundoArco,diagonal,base);
        
        return miPath;
    }
    
    public Path draw3(double x,double y,Path miPath)
    {
        // revisar la cabeza del 3 se podria hacer sus curbas mas pequeñas y subir el punto central para que quedara mejor
        
        this.setElement("3");
        
        MoveTo start3 = new MoveTo();
        start3.setX((150+x)*this.factorResize);
        start3.setY((200+y)*this.factorResize);
        
        this.addPathElementList(start3);
        
        LineTo base = new LineTo();
        base.setX((160+x)*this.factorResize);
        base.setY((200+y)*this.factorResize);
        
        this.addPathElementList(base);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX((200+x)*this.factorResize);
        arco1.setY((175+y)*this.factorResize);
        arco1.setControlX((200+x)*this.factorResize);
        arco1.setControlY((200+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX((170+x)*this.factorResize);
        arco2.setY((150+y)*this.factorResize);
        arco2.setControlX((200+x)*this.factorResize);
        arco2.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX((200+x)*this.factorResize);
        arco3.setY((125+y)*this.factorResize);
        arco3.setControlX((200+x)*this.factorResize);
        arco3.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX((170+x)*this.factorResize);
        arco4.setY((100+y)*this.factorResize);
        arco4.setControlX((200+x)*this.factorResize);
        arco4.setControlY((100+y)*this.factorResize);
        
        this.addPathElementList(arco4);
        
        LineTo htop = new LineTo();
        htop.setX((150+x)*this.factorResize);
        htop.setY((100+y)*this.factorResize);
        
        this.addPathElementList(htop);
        
        this.setDawnPoint(start3.getY());
        this.setTopPoint(htop.getY());
        this.setStartPoint(start3.getX());
        this.setEndPoint(arco1.getX());
        
         miPath.getElements().addAll(start3,base,arco1,arco2,arco3,arco4,htop);
         
        return miPath;
    }
    
    public Path draw5(double x,double y,Path miPath)
    {
        this.setElement("5");
        
        MoveTo start5 = new MoveTo();
        start5.setX(150+x);
        start5.setY(190+y);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX(160+x);
        arco1.setY(200+y);
        arco1.setControlX(150+x);
        arco1.setControlY(200+y);
        
        HLineTo base = new HLineTo();
        base.setX(180+x);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX(200+x);
        arco2.setY(170+y);
        arco2.setControlX(200+x);
        arco2.setControlY(200+y);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX(180+x);
        arco3.setY(140+y);
        arco3.setControlX(200+x);
        arco3.setControlY(140+y);
        
        
        
        LineTo hmid = new LineTo();
        hmid.setX(150+x);
        hmid.setY(140+y);
        
        LineTo vline = new LineTo();
        vline.setX(150+x);
        vline.setY(100+y);
        
        LineTo htop = new LineTo();
        htop.setX(200+x);
        htop.setY(100+y);
        
        this.setDawnPoint(arco1.getY());
        this.setTopPoint(htop.getY());
        this.setStartPoint(start5.getX());
        this.setEndPoint(arco1.getX());
        
         miPath.getElements().addAll(start5,arco1,base,arco2,arco3,hmid,vline,htop);
         
        return miPath;
    }
}
