
/**
 * Esta clase contiene los atributos de un punto y unos métodos respectivos.
 * 
 * @author (Juan Sebastián Pérez Salazar)
 * @author (Yoan Alejandro Guzman)
 * @version (17 de julio, 2018)
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

    public double radioPolar() {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)); 
    }

    public double anguloPolar() {
        return Math.atan2(y,x);
    }

    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow((x-otro.x()),2)+Math.pow((y-otro.y()),2));
    }
}
