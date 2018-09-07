package CodingBat;

/**
 * This class contains the SquareUp method of Array3 of Codingbat
 * @author Juan Sebastián Pérez Salazar
 */
public class Array3SquareUp {
    /**
     * This method solves the following statement:
     * "Given n>=0, create an array length n*n with 
     * the following pattern, shown here for n=3 : 
     * {0, 0, 1,    0, 2, 1,    3, 2, 1} 
     * (spaces added to show the 3 groups)."
     * @param n control value
     * @return an array
     */
    public int[] squareUp(int n) {
        int[] arr = new int[n*n]; 
        int cont = 0;
        for(int i=1; i<=n; i++){
          for(int j=n; j>=1; j--){
            if((i-j)<0){
              arr[cont]=0;
            }else arr[cont]=j;
            cont++;
          }
        }
        return arr;
    }
}
