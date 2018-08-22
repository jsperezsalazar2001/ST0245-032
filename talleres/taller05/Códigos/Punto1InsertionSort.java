
import java.util.concurrent.TimeUnit;

/**
 * Esta calse se encarga de realizar el método de insertion sort para el ordenamiento de arreglos.
 * @author Juan Sebastián Pérez Salazar
 */
public class Punto1InsertionSort {
    
    public static void insertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int comp = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > comp) {
                  a[j] = a[j - 1];
                  j--;
            }
            a[j] = comp;
        }
    }
    
    public static void main(String[] args){
        for (int i = 10000000; i <= 200000000; i+=10000000){
          int[] a = new int[i];
          for (int j = 0; j < i; j++ ){
            a[j] = j;
          }
          long start = System.currentTimeMillis();
          insertionSort(a);
          long end = System.currentTimeMillis();       
          System.out.println(end-start);
        }
    }
}


