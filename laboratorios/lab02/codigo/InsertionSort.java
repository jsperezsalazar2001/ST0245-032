package lab02;
/**
 * This class is responsible for performing the insertion sort method for ordering arrays.
 * @author Juan Sebastián Pérez Salazar
 */
public class InsertionSort {
    /**
     * This method is responsible for ordering an array using the Insertion Sort method.
     * @param a array that is received to be ordered
     */
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
    /**
     * This method is responsible for executing the tests of the previous method and measuring the times it takes to execute. 
     * @param args 
     */
    public static void main(String[] args){
        for (int i = 10000; i <= 200000; i+=10000){
          int[] a = new int[i];
          for (int j = 0; j < i; j++ ){
            int rand = (int)(Math.random()*5000);
            a[j] = rand;
          }
          long start = System.currentTimeMillis();
          insertionSort(a);
          long end = System.currentTimeMillis();       
          System.out.println(end-start);
        }
    }
}