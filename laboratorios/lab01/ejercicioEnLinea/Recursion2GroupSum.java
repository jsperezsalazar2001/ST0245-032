
/**
 *
 * @author Yhoan Alejandro Guzman
 */
public class Recursion2GroupSum {

    /*
    * Method that solves the following statement of CodingBat - Recursion2:
    "Given an array of ints, is it possible to choose a group of some of the ints, 
    such that the group sums to the given target? This is a classic backtracking 
    recursion problem. Once you understand the recursive backtracking strategy in 
    this problem, you can use the same pattern for many problems to search a space of choices. 
    Rather than looking at the whole array, our convention is to consider the part of the array 
    starting at index start and continuing to the end of the array. The caller can specify the
    whole array simply by passing start as 0. No loops are needed -- the recursive calls progress 
    down the array."
    */
    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        if (start + 1 < nums.length && nums[start + 1] == 1) {
            start++;
        }
        return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);
    }

}
