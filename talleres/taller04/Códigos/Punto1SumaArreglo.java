package taller4;

/**
 * Esta clase contiene un método que suma los elementos de un arreglo y la prueba del mismo.
 * @author Juan Sebastián Pérez Salazar
 * @author Yohan Alejandro Guzman 
 */
import java.util.concurrent.TimeUnit;

public class Punto1
{
    /**
     * Este método ejecuta las preubas del método principal para calcular los 20 diferentes tiempos.
     * @param args 
     */
    public static void main(String[] args){
        for (int i = 1; i <= 20; i++){
          int[] a = new int[i];
          for (int j = 0; j < i; j++ ){
            a[j] = j;
          }
          long start = System.currentTimeMillis();
          System.out.println(suma(a));
          long fin = System.currentTimeMillis();       
          System.out.println(fin-start);
        }
    }
    
    /**
     * Este es el método auciliar del principal.  
     * @param a Es el arreglo que se le pasará al método principal. 
     * @return 
     */
    public static int suma(int[] a){
      return suma(a, 0);
    }
    
    /**
     * Este es el método principal el cual suma los elementos del arrelgo que ha recibido. 
     * @param a el arreglo en el cual se encuentran los elementos que se van a sumar. 
     * @param i el indice en el cual se empezará a evaluar el arreglo
     * @return 
     */
    private static int suma(int[] a, int i){
        if (i == a.length)
           return 0;
        else{
            try{
               TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
            }
           return a[i] + suma(a,i+1);
        }
    }
}
