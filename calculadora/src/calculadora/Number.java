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
    
    public Path draw0(double x,double y,Path miPath)
    {
        this.setElement("0");
        MoveTo start0 = new MoveTo();
        start0.setX((170+x)*this.factorResize);
        start0.setY((200+y)*this.factorResize);
        
        LineTo base = new LineTo();
        base.setX((180+x)*this.factorResize);
        base.setX((200+y)*this.factorResize);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX((200+x)*this.factorResize);
        arco1.setY((180+y)*this.factorResize);
        arco1.setControlX((200+x)*this.factorResize);
        arco1.setControlY((200+y)*this.factorResize);
        
        LineTo vLine1 = new LineTo();
        vLine1.setX((200+x)*this.factorResize);
        vLine1.setY((120+y)*this.factorResize);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX((180+x)*this.factorResize);
        arco2.setY((100+y)*this.factorResize);
        arco2.setControlX((200+x)*this.factorResize);
        arco2.setControlY((100+y)*this.factorResize);
        
        LineTo topLine = new LineTo();
        topLine.setX((170+x)*this.factorResize);
        topLine.setY((100+y)*this.factorResize);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX((150+x)*this.factorResize);
        arco3.setY((120+y)*this.factorResize);
        arco3.setControlX((150+x)*this.factorResize);
        arco3.setControlY((100+y)*this.factorResize);
        
        LineTo vLine2 = new LineTo();
        vLine2.setX((150+x)*this.factorResize);
        vLine2.setY((180+y)*this.factorResize);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX((170+x)*this.factorResize);
        arco4.setY((200+y)*this.factorResize);
        arco4.setControlX((150+x)*this.factorResize);
        arco4.setControlY((200+y)*this.factorResize);
        
        miPath.getElements().addAll(start0,base,arco1,vLine1,arco2,topLine,arco3,vLine2,arco4);
        
        this.setDawnPoint(start0.getY());
        this.setTopPoint(topLine.getY());
        this.setStartPoint(vLine2.getX());
        this.setEndPoint(vLine1.getX());
        
        return miPath;
    }
    
    public Path draw1(double x,double y,Path miPath)
    {
        this.setElement("1");
        
        MoveTo start1 = new MoveTo();
        start1.setX((160+x)*this.factorResize);
        start1.setY((140+y)*this.factorResize);
        
        this.addPathElementList(start1);
        
        LineTo diagonal = new LineTo();
        diagonal.setX((190+x)*this.factorResize);
        diagonal.setY((100+y)*this.factorResize);
        
        this.addPathElementList(diagonal);
        
        LineTo vertical = new LineTo();
        vertical.setX((190+x)*this.factorResize);
        vertical.setY((200+y)*this.factorResize);
        
        this.addPathElementList(vertical);
        
        this.setDawnPoint(vertical.getY());
        this.setTopPoint(diagonal.getY());
        this.setStartPoint(start1.getX());
        this.setEndPoint(vertical.getX());
        
        miPath.getElements().addAll(start1,diagonal,vertical);
        
        return miPath;
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
        start5.setX((150+x)*this.factorResize);
        start5.setY((190+y)*this.factorResize);
        
        this.addPathElementList(start5);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX((160+x)*this.factorResize);
        arco1.setY((200+y)*this.factorResize);
        arco1.setControlX((150+x)*this.factorResize);
        arco1.setControlY((200+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        LineTo base = new LineTo();
        base.setX((180+x)*this.factorResize);
        base.setY((200+y)*this.factorResize);
        
        this.addPathElementList(base);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX((200+x)*this.factorResize);
        arco2.setY((170+y)*this.factorResize);
        arco2.setControlX((200+x)*this.factorResize);
        arco2.setControlY((200+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX((180+x)*this.factorResize);
        arco3.setY((140+y)*this.factorResize);
        arco3.setControlX((200+x)*this.factorResize);
        arco3.setControlY((140+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        LineTo hmid = new LineTo();
        hmid.setX((150+x)*this.factorResize);
        hmid.setY((140+y)*this.factorResize);
        
        this.addPathElementList(hmid);
        
        LineTo vline = new LineTo();
        vline.setX((150+x)*this.factorResize);
        vline.setY((100+y)*this.factorResize);
        
        this.addPathElementList(vline);
        
        LineTo htop = new LineTo();
        htop.setX((200+x)*this.factorResize);
        htop.setY((100+y)*this.factorResize);
        
        this.addPathElementList(htop);
        
        this.setDawnPoint(arco1.getY());
        this.setTopPoint(htop.getY());
        this.setStartPoint(start5.getX());
        this.setEndPoint(arco3.getX());
        
         miPath.getElements().addAll(start5,arco1,base,arco2,arco3,hmid,vline,htop);
         
        return miPath;
    }
    
    public Path draw6(double x,double y,Path miPath)
    {
        this.setElement("6");
        MoveTo start6 = new MoveTo();
        start6.setX((150+x)*this.factorResize);
        start6.setY((175+y)*this.factorResize);
        
        this.addPathElementList(start6);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX((175+x)*this.factorResize);
        arco1.setY((200+y)*this.factorResize);
        arco1.setControlX((150+x)*this.factorResize);
        arco1.setControlY((200+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX((200+x)*this.factorResize);
        arco2.setY((175+y)*this.factorResize);
        arco2.setControlX((200+x)*this.factorResize);
        arco2.setControlY((200+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX((175+x)*this.factorResize);
        arco3.setY((150+y)*this.factorResize);
        arco3.setControlX((200+x)*this.factorResize);
        arco3.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX((150+x)*this.factorResize);
        arco4.setY((175+y)*this.factorResize);
        arco4.setControlX((150+x)*this.factorResize);
        arco4.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco4);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setX((180+x)*this.factorResize);
        arco5.setY((100+y)*this.factorResize);
        arco5.setControlX((155+x)*this.factorResize);
        arco5.setControlY((110+y)*this.factorResize);
        
        this.addPathElementList(arco5);
        
        this.setDawnPoint(arco1.getY());
        this.setTopPoint(arco5.getY());
        this.setStartPoint(start6.getX());
        this.setEndPoint(arco2.getX());
        
        miPath.getElements().addAll(start6,arco1,arco2,arco3,arco4,arco5);
         
        return miPath;
    }
    
    public Path draw9(double x,double y,Path miPath)
    {
        this.setElement("9");
        
        MoveTo start9 = new MoveTo();
        start9.setX((150+x)*this.factorResize);
        start9.setY((125+y)*this.factorResize);
        
        this.addPathElementList(start9);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX((175+x)*this.factorResize);
        arco1.setY((150+y)*this.factorResize);
        arco1.setControlX((150+x)*this.factorResize);
        arco1.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX((200+x)*this.factorResize);
        arco2.setY((125+y)*this.factorResize);
        arco2.setControlX((200+x)*this.factorResize);
        arco2.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        LineTo lineaV = new LineTo();
        lineaV.setY((200+y)*this.factorResize);
        lineaV.setX((200+x)*this.factorResize);
        
        this.addPathElementList(lineaV);
        
        LineTo lineaV2 = new LineTo();
        lineaV2.setY((125+y)*this.factorResize);
        lineaV2.setX((200+x)*this.factorResize);
        
        this.addPathElementList(lineaV2);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX((175+x)*this.factorResize);
        arco3.setY((100+y)*this.factorResize);
        arco3.setControlX((200+x)*this.factorResize);
        arco3.setControlY((100+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX((150+x)*this.factorResize);
        arco4.setY((125+y)*this.factorResize);
        arco4.setControlX((150+x)*this.factorResize);
        arco4.setControlY((100+y)*this.factorResize);
        
        this.addPathElementList(arco4);
        
        this.setDawnPoint(lineaV.getY());
        this.setTopPoint(arco3.getY());
        this.setStartPoint(start9.getX());
        this.setEndPoint(lineaV.getX());
        
        miPath.getElements().addAll(start9,arco1,arco2,lineaV,lineaV2,arco3,arco4);
        
        return miPath;
    }
    
    public Path draw7(double x,double y,Path miPath)
    {
        this.setElement("7");
        
        MoveTo start7 = new MoveTo();
        start7.setX((150+x)*this.factorResize);
        start7.setY((200+y)*this.factorResize);
        
        this.addPathElementList(start7);
        
        LineTo diagonal1 = new LineTo();
        diagonal1.setX((175+x)*this.factorResize);
        diagonal1.setY((150+y)*this.factorResize);
        
        this.addPathElementList(diagonal1);
        
        LineTo hMidLine1 = new LineTo();
        hMidLine1.setX((200+x)*this.factorResize);
        hMidLine1.setY((150+y)*this.factorResize);
        
        this.addPathElementList(hMidLine1);
        
        LineTo hMidLine2 = new LineTo();
        hMidLine2.setX((150+x)*this.factorResize);
        hMidLine2.setY((150+y)*this.factorResize);
        
        this.addPathElementList(hMidLine2);
        
        LineTo hMidLine3 = new LineTo();
        hMidLine3.setX((175+x)*this.factorResize);
        hMidLine3.setY((150+y)*this.factorResize);
        
        this.addPathElementList(hMidLine3);
        
        LineTo diagonal2 = new LineTo();
        diagonal2.setX((200+x)*this.factorResize);
        diagonal2.setY((100+y)*this.factorResize);
        
        this.addPathElementList(diagonal2);
        
        LineTo lineTop = new LineTo();
        lineTop.setX((150+x)*this.factorResize);
        lineTop.setY((100+y)*this.factorResize);
        
        this.addPathElementList(lineTop);
        
        this.setDawnPoint(start7.getY());
        this.setTopPoint(lineTop.getY());
        this.setStartPoint(start7.getX());
        this.setEndPoint(diagonal2.getX());
        
         miPath.getElements().addAll(start7,diagonal1,hMidLine1,hMidLine2,hMidLine3,diagonal2,lineTop);
        
        return miPath;
    }
    
    public Path draw8(double x,double y,Path miPath)
    {
        this.setElement("8");
        
        MoveTo start8 = new MoveTo();
        start8.setX((150+x)*this.factorResize);
        start8.setY((175+y)*this.factorResize);
        
        this.addPathElementList(start8);
        
        QuadCurveTo arco1 = new QuadCurveTo();
        arco1.setX((170+x)*this.factorResize);
        arco1.setY((200+y)*this.factorResize);
        arco1.setControlX((150+x)*this.factorResize);
        arco1.setControlY((200+y)*this.factorResize);
        
        this.addPathElementList(arco1);
        
        LineTo base = new LineTo();
        base.setX((180+x)*this.factorResize);
        base.setY((200+y)*this.factorResize);
        
        this.addPathElementList(base);

        QuadCurveTo arco2 = new QuadCurveTo();
        arco2.setX((200+x)*this.factorResize);
        arco2.setY((175+y)*this.factorResize);
        arco2.setControlX((200+x)*this.factorResize);
        arco2.setControlY((200+y)*this.factorResize);
        
        this.addPathElementList(arco2);
        
        QuadCurveTo arco3 = new QuadCurveTo();
        arco3.setX((180+x)*this.factorResize);
        arco3.setY((150+y)*this.factorResize);
        arco3.setControlX((200+x)*this.factorResize);
        arco3.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco3);
        
        LineTo mid1 = new LineTo();
        mid1.setX((170+x)*this.factorResize);
        mid1.setY((150+y)*this.factorResize);
        
        this.addPathElementList(mid1);
        
        QuadCurveTo arco4 = new QuadCurveTo();
        arco4.setX((150+x)*this.factorResize);
        arco4.setY((125+y)*this.factorResize);
        arco4.setControlX((150+x)*this.factorResize);
        arco4.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco4);
        
        QuadCurveTo arco5 = new QuadCurveTo();
        arco5.setX((170+x)*this.factorResize);
        arco5.setY((100+y)*this.factorResize);
        arco5.setControlX((150+x)*this.factorResize);
        arco5.setControlY((100+y)*this.factorResize);
        
        this.addPathElementList(arco5);
        
        LineTo htop = new LineTo();
        htop.setX((180+x)*this.factorResize);
        htop.setY((100+y)*this.factorResize);
        
        this.addPathElementList(htop);
        
        QuadCurveTo arco6 = new QuadCurveTo();
        arco6.setX((200+x)*this.factorResize);
        arco6.setY((125+y)*this.factorResize);
        arco6.setControlX((200+x)*this.factorResize);
        arco6.setControlY((100+y)*this.factorResize);
        
        this.addPathElementList(arco6);
        
        QuadCurveTo arco7 = new QuadCurveTo();
        arco7.setX((180+x)*this.factorResize);
        arco7.setY((150+y)*this.factorResize);
        arco7.setControlX((200+x)*this.factorResize);
        arco7.setControlY((150+y)*this.factorResize);
        
        this.addPathElementList(arco7);
        
        LineTo mid2 = new LineTo();
        mid2.setX((170+x)*this.factorResize);
        mid2.setY((150+y)*this.factorResize);
        
        this.addPathElementList(mid2);
        
        QuadCurveTo arco8 = new QuadCurveTo();
        arco8.setX((150+x)*this.factorResize);
        arco8.setY((175+y)*this.factorResize);
        arco8.setControlX((150+x)*this.factorResize);
        arco8.setControlY((150+y)*this.factorResize);
        
        this.setDawnPoint(arco1.getY());
        this.setTopPoint(arco3.getY());
        this.setStartPoint(start8.getX());
        this.setEndPoint(arco2.getX());
        
        this.addPathElementList(arco8);
        
        miPath.getElements().addAll(start8,arco1,base,arco2,arco3,mid1,arco4,arco5,htop,arco6,arco7,mid2,arco8);
        
        return miPath;
    }
}
