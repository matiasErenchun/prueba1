/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Matias.Erenchun
 */
public class Point 
{
    public float nivel;
    public double coordenadaX;
    public double CoordenadaY;

    public Point(float nivel, double coordenadaX, double CoordenadaY) 
    {
        this.nivel = nivel;
        this.coordenadaX = coordenadaX;
        this.CoordenadaY = CoordenadaY;
    }

    public float getNivel() 
    {
        return this.nivel;
    }

    public void setNivel(float nivel) 
    {
        this.nivel = nivel;
    }

    public double getCoordenadaX() 
    {
        return this.coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) 
    {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() 
    {
        return this.CoordenadaY;
    }

    public void setCoordenadaY(double CoordenadaY) 
    {
        this.CoordenadaY = CoordenadaY;
    }
    
    
    
}
