
/**
 * Write a description of class Punto here.
 * 
 * @author (Juan Sebastián Pérez Salazar) 
 * @version (a version number or a date)
 */
public class Punto
{
    private double x, y; 
    
     public Punto(double x, double y) {
         this.x = x;
         this.y = y; 
    }

    public double x() {
        return this.x; 
    }

    public double y() {
        return this.y; 
    }

    // http://mathworld.wolfram.com/PolarCoordinates.html
    public double radioPolar() {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)); 
    }

    // http://mathworld.wolfram.com/PolarCoordinates.html
    public double anguloPolar() {
        return Math.atan2(y,x);
    }

    // http://mathworld.wolfram.com/Distance.html
    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow((x-otro.x()),2)+Math.pow((y-otro.y()),2));
    }
}
