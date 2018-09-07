package CodingBat;

/**
 * This class contains the LinearIn method of Array3 of Codingbat
 * @author Juan Sebastián Pérez Salazar
 */
public class Array3LinearIn {
    /**
     * This method solves the following statement:
     * "Given two arrays of ints sorted in increasing order, outer and inner, 
     * return true if all of the numbers in inner appear in outer. The best 
     * solution makes only a single "linear" pass of both arrays, taking advantage 
     * of the fact that both arrays are already in sorted order.".
     * @param outer an array
     * @param inner an array
     * @return a boolean
     */
    public boolean linearIn(int[] outer, int[] inner) {
        int start =0;
        for(int i=0; i<inner.length;i++){
          int num = inner[i];
          for(int j=start; j<outer.length;j++){
            if(outer[j]==num){
              start=j;
              break;
            }
            if(j==(outer.length-1) && outer[j]!=num) return false;
          }
        }
        return true; 
    }
}
