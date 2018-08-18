
/**
 *
 * @author Yhoan Alejandro Guzman
 */
public class Recursion2GroupSum6 {
    /**
    * Method that solves the following statement of CodingBat - Recursion2:
    "Given an array of ints, is it possible to choose a group of some of the ints, 
    beginning at the start index, such that the group sums to the given target? However, 
    with the additional constraint that all 6's must be chosen. (No loops needed.)"
    */
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (nums[start] == 6) {
            target -= nums[start];
            if (start + 1 < nums.length && nums[start + 1] == 1) {
                start++;
            }
            return groupSum6(start + 1, nums, target);
        } else {
            return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);
        }
    }

}
