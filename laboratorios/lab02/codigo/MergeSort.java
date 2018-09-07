package lab02;
/**
 * This class is responsible for performing the merge sort method for ordering arrays.
 * @author Juan Sebastián Pérez Salazar
 */
public class MergeSort {
    /**
     * These methods are responsibles for ordering an array using the Merge Sort method. Methods based in https://www.geeksforgeeks.org/merge-sort/
     * @param arr array that is received to be ordered
     * @param l left halve of the array
     * @param m middle point of the array
     * @param r rigth halve of the array
     */
    public static void merge(int arr[], int l, int m, int r){
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2];   
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2){ 
            if (L[i] <= R[j]){ 
                arr[k] = L[i]; 
                i++; 
            }else{ 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1){ 
            arr[k] = L[i]; 
            i++; 
            k++; 
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2){ 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }
    }
    
    public static void sort(int arr[], int l, int r){ 
        if (l < r){ 
            // Find the middle point 
            int m = (l+r)/2;
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r);
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }
    
    /**
     * This method is responsible for executing the tests of the previous method and measuring the times it takes to execute. 
     * @param args 
     */
    public static void main(String[] args){
        for (int i = 100000; i <= 2000000; i+=100000){
          int[] a = new int[i];
          for (int j = 0; j < i; j++ ){
            int rand = (int)(Math.random()*5000);
            a[j] = rand;
          }
          long start = System.currentTimeMillis();
          sort(a, 0, a.length-1);
          long end = System.currentTimeMillis();       
          System.out.println(end-start);
        }
    }
}
