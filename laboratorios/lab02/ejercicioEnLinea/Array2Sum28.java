package CodingBat;

/**
 * This class contains the Sum28 method of Array2 of Codingbat
 * @author Juan Sebastián Pérez Salazar
 */
public class Array2Sum28 {
    /**
     * This method solves the following statement:
     * "Given an array of ints, return true if the sum of all the 2's in the array is exactly 8".
     * @param nums array received.
     * @return a boolean
     */
    public boolean sum28(int[] nums) {
        int cont =0;
        for(int i =0; i<nums.length; i++){
          if(nums[i]==2) cont += nums[i];
        }
        return cont==8;
    }   
}
