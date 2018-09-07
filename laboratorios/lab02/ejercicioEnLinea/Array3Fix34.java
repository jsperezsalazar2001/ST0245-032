package CodingBat;

/**
 * This class contains the Fix34 method of Array3 of Codingbat
 * @author Juan Sebastián Pérez Salazar
 */
public class Array3Fix34 {
    /**
     * This method solves the following statement:
     * "Return an array that contains exactly the same numbers as the given array, 
     * but rearranged so that every 3 is immediately followed by a 4. Do not move 
     * the 3's, but every other number may move. The array contains the same number 
     * of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears 
     * in the array before any 4.".
     * @param nums array received
     * @return an array
     */
    public int[] fix34(int[] nums) {
        int mem = nums.length-1;
        for(int i=0; i<nums.length; i++){
          if(nums[i]==3){
            for(int j=mem; j>=0; j--){
              if(nums[j]==4){
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = temp;
                mem = j;
                break;
              }
            }
          }
        }
        return nums;
    }
}
