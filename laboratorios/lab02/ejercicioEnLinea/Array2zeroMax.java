
/**
 * This class contains the zeroMax method to solve Codingbat's 
 * array 2 zeroMax excercise
 * @author Yhoan Alejandro Guzmán.
 */
public class Array2zeroMax
{
    /**
     * This method solves the following statement:
     * "Return a version of the given array where each zero value in the array
     * is replaced by the largest odd value to the right of the zero in the 
     * array. If there is no odd value to the right of the zero, leave the zero
     * as a zero.".
     * @param nums is an array of integers
     * @return nums is the array of integers already organized as asked in the previous
     * statement
     */
    public int[] zeroMax(int[] nums) {
        int max = 0;
        for (int i = nums.length - 1; i >= 0 ;i--){
            if(nums[i] > max && nums[i] % 2 !=0){
                max = nums[i];
            }
            if(nums[i] == 0){
                nums[i] = max;
            }
        }
        return nums;
    }
}
