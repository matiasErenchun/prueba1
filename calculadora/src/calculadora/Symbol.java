/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author Matias.Erenchun
 */
public class Symbol extends Dibujo
{
    
    public Symbol(float f) {
        super(f);
    }
    
    public Path drawLess(double x,double y,Path miPath)
    {
        
        this.setElement("-");
        
        MoveTo startLess = new MoveTo();
        startLess.setX((160+x)*this.factorResize);
        startLess.setY((150+y)*this.factorResize);
        
        this.addPathElementList(startLess);
        
        LineTo line = new LineTo();
        line.setX((190+x)*this.factorResize);
        line.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line);
        
        this.setDawnPoint(startLess.getY());
        this.setTopPoint(startLess.getY());
        this.setStartPoint(startLess.getX());
        this.setEndPoint(line.getX());
        
        miPath.getElements().addAll(startLess,line);
        
        return miPath;
    }
    
    public Path drawPlus(double x,double y,Path miPath)
    {
        this.setElement("+");
        
        MoveTo startPlus = new MoveTo();
        startPlus.setX((160+x)*this.factorResize);
        startPlus.setY((150+y)*this.factorResize);
        
        this.addPathElementList(startPlus);
        
        LineTo line1 = new LineTo();
        line1.setX((175+x)*this.factorResize);
        line1.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line1);
        
        LineTo line2 = new LineTo();
        line2.setX((190+x)*this.factorResize);
        line2.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line2);
        
        LineTo line3 = new LineTo();
        line3.setX((175+x)*this.factorResize);
        line3.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line3);
        
        LineTo line4 = new LineTo();
        line4.setX((175+x)*this.factorResize);
        line4.setY((165+y)*this.factorResize);
        
        this.addPathElementList(line4);
        
        LineTo line5 = new LineTo();
        line5.setX((175+x)*this.factorResize);
        line5.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line5);
        
        LineTo line6 = new LineTo();
        line6.setX((175+x)*this.factorResize);
        line6.setY((135+y)*this.factorResize);
        
        this.addPathElementList(line6);
        
        this.setDawnPoint(line4.getY());
        this.setTopPoint(line6.getY());
        this.setStartPoint(startPlus.getX());
        this.setEndPoint(line2.getX());
        
        miPath.getElements().addAll(startPlus,line1,line2,line3,line4,line5,line6);
        
        return miPath;
    }
    
    public Path drawMultiplication(double x,double y,Path miPath)
    {
        this.setElement("*");
        MoveTo startMulti = new MoveTo();
        startMulti.setX((160+x)*this.factorResize);
        startMulti.setY((170+y)*this.factorResize);
        
        LineTo line1 = new LineTo();
        line1.setX((175+x)*this.factorResize);
        line1.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line1);
        
        LineTo line2 = new LineTo();
        line2.setX((190+x)*this.factorResize);
        line2.setY((170+y)*this.factorResize);
        
        this.addPathElementList(line2);
        
        LineTo line3 = new LineTo();
        line3.setX((175+x)*this.factorResize);
        line3.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line3);
        
        LineTo line4 = new LineTo();
        line4.setX((190+x)*this.factorResize);
        line4.setY((130+y)*this.factorResize);
        
        this.addPathElementList(line4);
        
        LineTo line5 = new LineTo();
        line5.setX((175+x)*this.factorResize);
        line5.setY((150+y)*this.factorResize);
        
        this.addPathElementList(line5);
        
        LineTo line6 = new LineTo();
        line6.setX((160+x)*this.factorResize);
        line6.setY((130+y)*this.factorResize);
        
        this.addPathElementList(line6);
        
        this.setDawnPoint(line2.getY());
        this.setTopPoint(line6.getY());
        this.setStartPoint(startMulti.getX());
        this.setEndPoint(line2.getX());
        
        miPath.getElements().addAll(startMulti,line1,line2,line3,line4,line5,line6);
        
        return miPath;
    }
    
    public Path drawDivide(double x,double y,Path miPath)
    {
        this.setElement("/");
        
        x+=10;
        
        MoveTo startDiv = new MoveTo();
        startDiv.setX((140+x)*this.factorResize);
        startDiv.setY((200+y)*this.factorResize);
        
        this.addPathElementList(startDiv);
        
        LineTo line1 = new LineTo();
        line1.setX((200+x)*this.factorResize);
        line1.setY((200+y)*this.factorResize);
        
        this.addPathElementList(line1);
        
        this.setDawnPoint(startDiv.getY());
        this.setTopPoint(startDiv.getY());
        this.setStartPoint(startDiv.getX());
        this.setEndPoint(line1.getX());
        
        miPath.getElements().addAll(startDiv,line1);
        
        return miPath;
    }
}
