/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javafx.scene.Group;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Matias.Erenchun
 */
public class Symbol extends Dibujo
{
    
    public Symbol(float f,float level) {
        super(f, level);
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
    
    public Group drawDividePrincipal(double xIni,double yIni, double xFin)
    {
        this.setElement("/");
        
        
        
        MoveTo startDiv = new MoveTo();
        startDiv.setX((0+xIni)*this.factorResize);
        startDiv.setY((50+yIni)*this.factorResize);
        
        this.addPathElementList(startDiv);
        
        LineTo line1 = new LineTo();
        line1.setX((xFin)*this.factorResize);
        line1.setY((50+yIni)*this.factorResize);
        
        this.addPathElementList(line1);
        
        this.setDawnPoint(startDiv.getY());
        this.setTopPoint(startDiv.getY());
        this.setStartPoint(startDiv.getX());
        this.setEndPoint(line1.getX());
        Group miGroup = new Group();
        Path miPath = new Path();
        miPath.getElements().addAll(startDiv,line1);
        
        miGroup.getChildren().add(miPath);
        
        return miGroup;
    }
    
    public Path drawDivide(double x,double y,Path miPath)
    {
        this.setElement("/");
        
        x+=10;
        
        MoveTo startDiv = new MoveTo();
        startDiv.setX((-30+x)*this.factorResize);
        startDiv.setY((50+y)*this.factorResize);
        
        this.addPathElementList(startDiv);
        
        LineTo line1 = new LineTo();
        line1.setX((50+x)*this.factorResize);
        line1.setY((50+y)*this.factorResize);
        
        this.addPathElementList(line1);
        
        this.setDawnPoint(startDiv.getY());
        this.setTopPoint(startDiv.getY());
        this.setStartPoint(startDiv.getX());
        this.setEndPoint(line1.getX());
        
        miPath.getElements().addAll(startDiv,line1);
        
        return miPath;
    }
    
    public Path drawE(double x,double y,Path miPath)
    {
        MoveTo startE = new MoveTo();
        startE.setX((0+x)*this.factorResize);
        startE.setY((65+y)*this.factorResize);
        
        this.addPathElementList(startE);
        
        LineTo midE = new LineTo();
        midE.setX((50+x)*this.factorResize);
        midE.setY((65+y)*this.factorResize);
        
        this.addPathElementList(midE);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((50+x)*this.factorResize);
        arco1.setControlY((40+y)*this.factorResize);
        arco1.setX((25+x)*this.factorResize);
        arco1.setY((40+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((0+x)*this.factorResize);
        arco2.setControlY((40+y)*this.factorResize);
        arco2.setX((0+x)*this.factorResize);
        arco2.setY((65+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((0+x)*this.factorResize);
        arco3.setControlY((100+y)*this.factorResize);
        arco3.setX((25+x)*this.factorResize);
        arco3.setY((100+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((50+x)*this.factorResize);
        arco4.setControlY((100+y)*this.factorResize);
        arco4.setX((50+x)*this.factorResize);
        arco4.setY((80+y)*this.factorResize);
        
        this.addPathElementList(arco4);
        
        this.setDawnPoint(arco3.getY());
        this.setTopPoint(arco1.getY());
        this.setStartPoint(startE.getX());
        this.setEndPoint(midE.getX());
        
        miPath.getElements().addAll(startE,midE,arco1,arco2,arco3,arco4);
        
        return miPath;
    }
    
     public Path drawA(double x,double y,Path miPath)
     {
        MoveTo startA = new MoveTo();
        startA.setX((0+x)*this.factorResize);
        startA.setY((50+y)*this.factorResize);
        
        this.addPathElementList(startA);
         
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((0+x)*this.factorResize);
        arco1.setControlY((40+y)*this.factorResize);
        arco1.setX((10+x)*this.factorResize);
        arco1.setY((40+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        LineTo top = new LineTo();
        top.setX((30+x)*this.factorResize);
        top.setY((40+y)*this.factorResize);
        
        this.addPathElementList(top);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((40+x)*this.factorResize);
        arco2.setControlY((40+y)*this.factorResize);
        arco2.setX((40+x)*this.factorResize);
        arco2.setY((50+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        LineTo verti1 = new LineTo();
        verti1.setX((40+x)*this.factorResize);
        verti1.setY((60+y)*this.factorResize);
        
        this.addPathElementList(verti1);
        
        LineTo verti2 = new LineTo();
        verti2.setX((40+x)*this.factorResize);
        verti2.setY((85+y)*this.factorResize);
        
        this.addPathElementList(verti2);
        
        QuadCurveTo hori1 = new QuadCurveTo();
        hori1.setControlX((40+x)*this.factorResize);
        hori1.setControlY((95+y)*this.factorResize);
        hori1.setX((30+x)*this.factorResize);
        hori1.setY((100+y)*this.factorResize);
        
        this.addPathElementList(hori1);
        
        LineTo base = new LineTo();
        base.setX((10+x)*this.factorResize);
        base.setY((100+y)*this.factorResize);
        
        this.addPathElementList(base);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((0+x)*this.factorResize);
        arco3.setControlY((100+y)*this.factorResize);
        arco3.setX((0+x)*this.factorResize);
        arco3.setY((80+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((0+x)*this.factorResize);
        arco4.setControlY((65+y)*this.factorResize);
        arco4.setX((20+x)*this.factorResize);
        arco4.setY((60+y)*this.factorResize);
        
        this.addPathElementList(arco4);
        
        
        LineTo mid = new LineTo();
        mid.setX((40+x)*this.factorResize);
        mid.setY((60+y)*this.factorResize);
        
        this.addPathElementList(mid);
        
        LineTo verti3 = new LineTo();
        verti3.setX((40+x)*this.factorResize);
        verti3.setY((85+y)*this.factorResize);
        
        this.addPathElementList(mid);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setControlX((40+x)*this.factorResize);
        arco5.setControlY((95+y)*this.factorResize);
        arco5.setX((50+x)*this.factorResize);
        arco5.setY((100+y)*this.factorResize);
        
        this.addPathElementList(arco5);
        
        this.setDawnPoint(base.getY());
        this.setTopPoint(arco1.getY());
        this.setStartPoint(startA.getX());
        this.setEndPoint(arco5.getX());
        
        miPath.getElements().addAll(startA,arco1,top,arco2,verti1,verti2,hori1,base,arco3,arco4,mid,verti3,arco5);
       
         return miPath;
     }
     
     public Path drawC(double x,double y,Path miPath)
     {
        MoveTo startC = new MoveTo();
        startC.setX((0+x)*this.factorResize);
        startC.setY((70+y)*this.factorResize);
        
        this.addPathElementList(startC);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setControlX((0+x)*this.factorResize);
        arco1.setControlY((40+y)*this.factorResize);
        arco1.setX((25+x)*this.factorResize);
        arco1.setY((40+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setControlX((50+x)*this.factorResize);
        arco2.setControlY((40+y)*this.factorResize);
        arco2.setX((50+x)*this.factorResize);
        arco2.setY((60+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setControlX((50+x)*this.factorResize);
        arco3.setControlY((40+y)*this.factorResize);
        arco3.setX((25+x)*this.factorResize);
        arco3.setY((40+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setControlX((0+x)*this.factorResize);
        arco4.setControlY((40+y)*this.factorResize);
        arco4.setX((0+x)*this.factorResize);
        arco4.setY((70+y)*this.factorResize);
        
        this.addPathElementList(arco4);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setControlX((0+x)*this.factorResize);
        arco5.setControlY((100+y)*this.factorResize);
        arco5.setX((25+x)*this.factorResize);
        arco5.setY((100+y)*this.factorResize);
        
        this.addPathElementList(arco5);
        
        QuadCurveTo arco6 = new QuadCurveTo();
        arco6.setControlX((50+x)*this.factorResize);
        arco6.setControlY((100+y)*this.factorResize);
        arco6.setX((50+x)*this.factorResize);
        arco6.setY((80+y)*this.factorResize);
        
        this.addPathElementList(arco6);
        
        this.setDawnPoint(arco5.getY());
        this.setTopPoint(arco1.getY());
        this.setStartPoint(startC.getX());
        this.setEndPoint(arco6.getX());
        
        miPath.getElements().addAll(startC,arco1,arco2,arco3,arco4,arco5, arco6);
        
         return miPath;
     }
}
