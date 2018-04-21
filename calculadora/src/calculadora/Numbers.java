/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Matias.Erenchun
 */
public class Numbers extends Dibujo
{

    public Numbers() 
    {
        
    }
    
    public Path dibujar2(double x,double y,Path miPath)
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
}
