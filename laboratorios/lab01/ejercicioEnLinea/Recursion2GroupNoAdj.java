
/**
 *
 * @author Yhoan Alejandro Guzman
 */
public class Recursion2GroupNoAdj {

    /*
    * Method that solves the following statement of CodingBat - Recursion2:
    "Given an array of ints, is it possible to choose a group of some of the ints, 
    such that the group sums to the given target with this additional constraint:
    If a value in the array is chosen to be in the group, the value immediately 
    following it in the array must not be chosen. (No loops needed.)"
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (start + 1 < nums.length && nums[start + 1] == 1) {
            start++;
        }
        return groupNoAdj(start + 2, nums, target - nums[start]) || groupNoAdj(start + 1, nums, target);

    }

}
