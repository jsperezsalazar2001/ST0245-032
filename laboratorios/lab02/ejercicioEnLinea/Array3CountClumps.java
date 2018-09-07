
/**
 * This class contains the countClumps method to solve Codingbat's 
 * array 3 countClumps excercise.
 * @author Yhoan Alejandro Guzmán
 */
public class Array3CountClumps
{
    /**
     * This method solves the following statement:
     * "Say that a "clump" in an array is a series of 2 or more adjacent elements of the 
     * same value. Return the number of clumps in the given array.".
     * @param nums is an array of integers
     * @return clumps is the number of "clumps" (as defined in the previous statement) found in the array.
     */
    public int countClumps(int[] nums) {
        int clumps = 0;
        boolean lastClumpMatch = false;
        for (int i = 0; (i + 1)< nums.length; i++) {
            if (nums[i] == nums[i+1] && !lastClumpMatch) {
                //If two adjacent elements in the array are the same, there is a clump, but if there was 
                //a clump in the last comparison, it means there are 3 adjacent numbers and it only counts as one.
                //The same applies for 3 or more adjacent numbers.
                lastClumpMatch = true;
                clumps++;
            } 
            else if (nums[i] != nums[i+1]) {
                lastClumpMatch = false;
            }
        }
        return clumps;
    }
}
