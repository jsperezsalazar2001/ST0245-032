package CodingBat;

/**
 * This class contains the MaxSpan method of Array3 of Codingbat
 * @author Juan Sebastián Pérez Salazar
 */
public class Array3MaxSpan {
    /**
     * This method solves the following statement:
     * "Consider the leftmost and righmost appearances of some value in an array. 
     * We'll say that the "span" is the number of elements between the two inclusive. 
     * A single value has a span of 1. Returns the largest span found in the given array. 
     * (Efficiency is not a priority.)".
     * @param nums array received
     * @return an int
     */
    public int maxSpan(int[] nums) {
        int max=0;
        for(int i=0; i<=(nums.length/2); i++){
          for(int j=nums.length-1; j>=0; j--){
            if(nums[i]==nums[j]){
              if((j-i+1)>max) max = j-i+1;
              break;
            }
          }
        }
        return max;
    }
}
