package CodingBat;

/**
 * This class contains the TripleUp method of Array2 of Codingbat
 * @author Juan Sebastián Pérez Salazar
 */
public class Array2TripleUp {
    /**
    * This method solves the following statement:
    * "Return true if the array contains, somewhere, 
    * three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.".
    * @param nums array received.
    * @return a boolean
    */
    public boolean tripleUp(int[] nums) {
        for(int i=0; i<nums.length-2; i++){
          int val = nums[i];
          if(nums[i+1]==val+1 && nums[i+2]==val+2) return true;
        }
        return false; 
    }
}
